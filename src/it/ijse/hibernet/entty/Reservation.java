package it.ijse.hibernet.entty;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation implements SuperEntity {
    @Id
    private String res_id;
    private String DATE;
    private String student_id;
    private String room_type_id;
    private String status;

    @ManyToOne
    @JoinColumn(name = "student_id",referencedColumnName = "student_ID",insertable = false,updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "room_type_id",referencedColumnName = "room_type_id",insertable = false,updatable = false)
    private Room room;

}
