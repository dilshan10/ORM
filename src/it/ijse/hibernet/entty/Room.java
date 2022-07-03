package it.ijse.hibernet.entty;

import lombok.*;

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
}
