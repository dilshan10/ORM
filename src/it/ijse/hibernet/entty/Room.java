package it.ijse.hibernet.entty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room implements SuperEntity {
    @Id
    private String room_type_ID;
    private String type;
    private double keyMoney;
    private int QTY;

    @OneToMany(mappedBy = "room")
    private List<Reservation> reservations = new ArrayList<>();



    public Room(String room_type_ID, String type, double keyMoney, int QTY) {
        this.room_type_ID = room_type_ID;
        this.type = type;
        this.keyMoney = keyMoney;
        this.QTY = QTY;
    }
}
