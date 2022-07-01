package it.ijse.hibernet.dto;

public class RoomDTO {
    private String room_type_ID;
    private String type;
    private double keyMoney;
    private int QTY;

    public RoomDTO() {
    }

    public RoomDTO(String room_type_ID, String type, double keyMoney, int QTY) {
        this.room_type_ID = room_type_ID;
        this.type = type;
        this.keyMoney = keyMoney;
        this.QTY = QTY;
    }

    public String getRoom_type_ID() {
        return room_type_ID;
    }

    public void setRoom_type_ID(String room_type_ID) {
        this.room_type_ID = room_type_ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getKeyMoney() {
        return keyMoney;
    }

    public void setKeyMoney(double keyMoney) {
        this.keyMoney = keyMoney;
    }

    public int getQTY() {
        return QTY;
    }

    public void setQTY(int QTY) {
        this.QTY = QTY;
    }

    @Override
    public String toString() {
        return "RoomDTO{" +
                "room_type_ID='" + room_type_ID + '\'' +
                ", type='" + type + '\'' +
                ", keyMoney=" + keyMoney +
                ", QTY=" + QTY +
                '}';
    }
}
