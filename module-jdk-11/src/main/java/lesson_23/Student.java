package lesson_23;

import javax.persistence.*;

@Entity
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "full_name")
    private String name;

    @ManyToOne
    @JoinColumn (name = "group_id")
    private Groups group;

    @Column(name = "year_of_entry")
    private String year_of_entry;

    public Student() {
    }

    public Student(String name, Groups group, String year_of_entry) {
        this.name = name;
        this.group = group;
        this.year_of_entry = year_of_entry;
    }

    @Override
    public String toString() {
        return String.format("Full name = %-30s group = %-10s year = %4s id = %d",
                name, group.getName(), year_of_entry, id);
    }
}
