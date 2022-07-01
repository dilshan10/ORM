package it.ijse.hibernet.dto;

import java.util.Date;

public class ReservationDTO {
    private String res_id;
    private Date DATE;
    private String student_id;
    private String room_type_id;
    private String status;

    public ReservationDTO() {
    }

    public ReservationDTO(String res_id, Date DATE, String student_id, String room_type_id, String status) {
        this.res_id = res_id;
        this.DATE = DATE;
        this.student_id = student_id;
        this.room_type_id = room_type_id;
        this.status = status;
    }

    public String getRes_id() {
        return res_id;
    }

    public void setRes_id(String res_id) {
        this.res_id = res_id;
    }

    public Date getDATE() {
        return DATE;
    }

    public void setDATE(Date DATE) {
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

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "res_id='" + res_id + '\'' +
                ", DATE=" + DATE +
                ", student_id='" + student_id + '\'' +
                ", room_type_id='" + room_type_id + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
