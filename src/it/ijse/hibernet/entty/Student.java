package it.ijse.hibernet.entty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student implements SuperEntity {
    @Id
    private String student_ID;
    private String name;
    private String address;
    private String contact_no;
    private String dob;
    private String gender;

    @OneToMany(mappedBy = "student")
    private List<Reservation> rese = new ArrayList<>();

    public Student(String student_ID, String name, String address, String contact_no, String dob, String gender) {
        this.student_ID = student_ID;
        this.name = name;
        this.address = address;
        this.contact_no = contact_no;
        this.dob = dob;
        this.gender = gender;

    }
}
