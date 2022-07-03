package it.ijse.hibernet.entty;

import javax.persistence.*;
import java.util.Date;

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

    public Reservation() {
    }

    public Reservation(String res_id, String date, String student_id, String room_type_id, String status) {
        this.res_id = res_id;
        this.DATE =date;
        this.student_id = student_id;
        this.room_type_id = room_type_id;
        this.status = status;
    }

    public Reservation(String res_id, String DATE, String student_id, String room_type_id, String status, Student student, Room room) {
        this.res_id = res_id;
        this.DATE = DATE;
        this.student_id = student_id;
        this.room_type_id = room_type_id;
        this.status = status;
        this.student = student;
        this.room = room;
    }

    public String getRes_id() {
        return res_id;
    }

    public void setRes_id(String res_id) {
        this.res_id = res_id;
    }

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getRoom_type_id() {
        return room_type_id;
    }

    public void setRoom_type_id(String room_type_id) {
        this.room_type_id = room_type_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "res_id='" + res_id + '\'' +
                ", DATE='" + DATE + '\'' +
                ", student_id='" + student_id + '\'' +
                ", room_type_id='" + room_type_id + '\'' +
                ", status='" + status + '\'' +
                ", student=" + student +
                ", room=" + room +
                '}';
    }
}
