package lessons_04;

import External.ExternalFunction;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        byte choose = 0;
        do{
            showInfo();
            choose = Menu();
            System.out.println();
            switch (choose){
                case 1:
                    Task.car = initCar();
                    break;
                case 2:
                    Task.fuelCost = initFuelCost();
                    break;
                case 3:
                    Task.routes = initRoute();
                    break;
                case 4:
                    Task.routes = initStopPoint(Task.routes);
                    break;
                case 0:
                default:
                    choose = 0;
            }
        }
        while(choose > 0);
    }
    static void showInfo(){
        String separator = ExternalFunction.getSeparator();
        // car parameters
        if(Task.car != null){
            System.out.println(separator);
            System.out.println("Car information:");
            Task.car.showInfo();
            Task.car.fillTank(Task.car.getFuelTank());
        }
        // fuel cost
        if(Task.fuelCost != 0){
            System.out.println(separator);
            System.out.printf("Fuel cost = %20.2f\n", Task.fuelCost);
        }
        // route info
        if (Task.routes != null){
            double TotalCost = 0;
            System.out.println(separator);
            System.out.println("Route information:");
            for (int i = 0; i < Task.routes.length; i++) {
                System.out.printf("%2d - ", i+1);
                Task.routes[i].showRoute();
                double distance = Task.car.getDistanceRide();
                if(Task.routes[i].distance > distance){
                    System.out.printf("Tank is empty! Ride distance = %.2f. it's %.2f to go.\n", distance, Task.routes[i].distance  - distance);
                    break;
                }
                System.out.printf("   Ride %.2f km. Fuel = %.2f litres. ", Task.routes[i].distance, Task.car.getFuelLevelAfterRide(Task.routes[i].distance));
                double cost = 0;
                if (i != Task.routes.length -1 ) {
                    double litres = Task.car.getLitresNeedToFullTankAfterRide(Task.routes[i].distance);
                    cost = Task.car.getLitresNeedToFullTankAfterRide(Task.routes[i].distance) * Task.fuelCost;
                    Task.car.Ride(Task.routes[i].distance);
                    Task.car.fillTank(litres);
                }
                else {
                    Task.car.Ride(Task.routes[i].distance);
                    cost = Task.car.getLitresNeedToRide(Task.routes[i].distance) * Task.fuelCost;
                }
                TotalCost += cost;
                System.out.printf("Cost = %.2f\n", cost);
            }
            System.out.println(separator);
            System.out.printf("Total cost = %.2f\n", TotalCost);
        }
    }
    static byte Menu(){
        String separator = ExternalFunction.getSeparator();
        Scanner scan = new Scanner(System.in);
       // Create menu
        System.out.println(separator);
        System.out.println("MENU:");
        System.out.println("1 - car initialization");
        System.out.println("2 - enter fuel cost");
        if (Task.car != null){
            System.out.println("3 - enter route");
            if(Task.routes != null) {
                System.out.println("4 - make stop in point");
            }
        }
        System.out.println("0 - exit");
        System.out.print("Make your choose: ");
        return scan.nextByte();
    }
    static Car initCar(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter tank size(liters), fuel consumption(litres/100 km) with a comma: ");
        String parameters = scan.nextLine();
        System.out.println();
        String [] param = parameters.split(",");
        if (param.length == 2) {
            boolean inputError = false;
            double tankSize = Double.valueOf(param[0].trim());
            double fuelConsumption = Double.valueOf(param[1].trim());
            if (tankSize <= 0 ) {
                System.out.println("Tank size must be greater than 0");
                inputError = true;
            }
            if (fuelConsumption <= 0 ) {
                System.out.println("Fuel consumption must be greater than 0");
                inputError = true;
            }
            if(!inputError){
                return new Car(tankSize, fuelConsumption);
            }
        }
        else {
            System.out.println("Input wrong parameters");
        }
        return null;
    }
    static double initFuelCost() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter fuel cost: ");
        double fuelCost = scan.nextDouble();
        System.out.println();
        if(fuelCost <= 0)
        {
            System.out.println("Fuel cost must be greater than 0");
            return 0;
        }
        return fuelCost;
    }
    static Route[] initRoute(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter name of start point, name of finish point, distance(km) with a comma: ");
        String parameters = scan.nextLine();
        System.out.println();
        String [] param = parameters.split(",");
        if (param.length == 3) {
            double distance = Double.valueOf(param[2].trim());
            if (distance < 0 ) {
                System.out.println("Distance must not be negative");
            }
            else {
                Route [] routes = new Route[1];
                routes[0] = new Route(param[0].trim(), param[1].trim(), distance);
                return routes;
            }
        }
        else {
                System.out.println("Input wrong parameters");
            }
        return null;
    }
    static Route[] initStopPoint(Route[] routes) {
        Scanner scan = new Scanner(System.in);
        double maxDistance = routes[routes.length-1].distance;
        System.out.printf("Please enter name of point, distance(km) lesser %.2f: with a comma: ", maxDistance);
        String parameters = scan.nextLine();
        System.out.println();
        String [] param = parameters.split(",");
        if (param.length == 2) {
            double distance = Double.valueOf(param[1].trim());
            if (distance < 0 || distance >= maxDistance){
                System.out.printf("Distance must be greater than 0 and lesser %.2f \n", maxDistance);
            }
            else {
                Route [] newRoutes = new Route [routes.length + 1];
                for (int i = 0; i < routes.length - 1; i++) {
                    newRoutes[i] = new Route(routes[i].fromPoint, routes[i].toPoint, routes[i].distance);
                }
                String newPointName = param[0].trim();
                newRoutes[routes.length - 1] = new Route(routes[routes.length-1].fromPoint, newPointName, distance);
                newRoutes[newRoutes.length - 1] = new Route(newPointName, routes[routes.length-1].toPoint, routes[routes.length-1].distance - distance);
                return newRoutes;
            }
        }
        else {
            System.out.println("Input wrong parameters");
        }
        return routes;
    }
}
