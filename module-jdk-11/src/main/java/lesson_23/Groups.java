package lesson_23;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "StudentGroups")
public class Groups {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;
//
//    @OneToMany(mappedBy = "group")
//    private List<Student> students;

    public Groups() {
    }
    public Groups(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
