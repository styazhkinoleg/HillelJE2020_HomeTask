package lesson_23;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Grades")
public class Grades {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column (name = "student_id")
    private long student_id;
}
