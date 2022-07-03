package it.ijse.hibernet.entty;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
