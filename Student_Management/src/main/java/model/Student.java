package model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@Entity(name = "STUDENTS_MANAGEMENT")
public class Student implements Serializable{
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name = "student_seq", sequenceName = "student_seq", allocationSize = 1, initialValue = 1)
    private int ID;

    @Column(name = "FULL_NAME")
    private String fullName  ;

    @Column(name = "NAME")
    private String className ;

    @Column(name = "MAJOR")
    private String major ;

    @Column(name = "HOMETOWN")
    private String hometown ;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "COLUMNAVERAGE_MARK")
    private double averageMmark;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", fullName='" + fullName + '\'' +
                ", className='" + className + '\'' +
                ", major='" + major + '\'' +
                ", hometown='" + hometown + '\'' +
                ", gender='" + gender + '\'' +
                ", averageMmark=" + averageMmark +
                ", birthday=" + birthday +
                '}';
    }
}
