package it.ijse.hibernet.entty;

import com.sun.javafx.beans.IDProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements SuperEntity {
    @Id
    private String user_ID;
    private String user_Name;
    private String password;

}
