package lesson_21;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = getConnection();

            printStudent(connection);

            printStudent(connection, 2);

            printStudent(connection, "bogdan");

            createStudent(connection);

            printStudent(connection);

            deleteStudent(connection);

            printStudent(connection);

            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    private static Connection getConnection() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter root password: ");
        String pas = scanner.nextLine();
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root" +
                "&password=" + pas + "&serverTimezone=UTC");

    }
    private static String selectBegin(){
        return "select s.id as id, s.full_name as name, s.year_of_entry as year, g.name as gname " +
                "from Students s left join Groups g on s.group_id = g.id";
    }
    private static String selectEnd(){
        return " order by full_name";
    }
    private static void printStudent(Connection connection) throws SQLException {
        printResult(connection, selectBegin() + selectEnd());
    }
    private static void printStudent(Connection connection, long id) throws SQLException {
        printResult(connection, selectBegin() + " where s.id = " + id);
    }
    private static void printStudent(Connection connection, String name) throws SQLException {
        printResult(connection, selectBegin() + " where s.full_name like \"" +
                capitalize(name) + "%\"" + selectEnd());
    }
    private static String capitalize(String s){
        if (s == null || s.length() < 1) return "";
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
    private static void printResult(Connection connection, String sqlQuery) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);
        System.out.println("Students list:");
        while (rs.next()) {
            System.out.printf("  Full name = %-30s group = %-10s year = %4s id = %d\n",
                    rs.getString("name"),
                    rs.getString("gname"),
                    rs.getString("year"),
                    rs.getLong("id"));
        }
        System.out.println();
    }
    private static void createStudent(Connection connection) throws SQLException{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter data like \"FirstName,GroupName,YaerOfEntry\": ");
        String result = scanner.nextLine();
        String [] param = result.split(",");
        if (param.length == 3) {
            long id_group = getGroup(connection, param[1]);
            PreparedStatement statement = connection.prepareStatement("insert into Students (full_name, group_id, " +
                    "year_of_entry) value (?,?,?)" );
            statement.setString(1, param[0]);
            statement.setLong(2, getGroup(connection, param[1]));
            statement.setString(3, param[2]);
            statement.executeUpdate();
            statement.close();
        } else {
            System.out.println("Wrong data");
        }
    }
    private static void deleteStudent(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID student to delete it: ");
        long id = -1;
        try {
            id = scanner.nextLong();
        } catch (InputMismatchException e) {
            e.printStackTrace();
            return;
        }
        PreparedStatement statement = connection.prepareStatement("select id from Grades where student_id = ? limit 1");
        statement.setLong(1, id);
        ResultSet rs = statement.executeQuery();
        if(rs.next()){
            System.out.println("Can not delete Student ID = " + id + ". Links found in table Grades.");
        } else {
            statement = connection.prepareStatement("delete from Students where id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
        }
        rs.close();
        statement.close();
    }
    private static long getGroup(Connection connection, String name) throws SQLException{
        long group_id = -1;
        String query = "select * from Groups where name like ? limit 1";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            group_id = rs.getLong("id");
        } else {
            statement = connection.prepareStatement("insert into Groups (name) value (?)");
            statement.setString(1, name);
            statement.executeUpdate();
            group_id = getGroup(connection, name);
        }
        rs.close();
        statement.close();
        return group_id;
    }
}

