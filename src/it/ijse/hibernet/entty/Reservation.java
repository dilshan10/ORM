package it.ijse.hibernet.entty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @JoinColumn
    private Student student;

    @ManyToOne
    @JoinColumn
    private Room room;


    public Reservation(String res_id, String date, String student_id, String room_type_id, String status) {
        this.res_id = res_id;
        this.DATE =date;
        this.student_id = student_id;
        this.room_type_id = room_type_id;
        this.status = status;
    }
}
