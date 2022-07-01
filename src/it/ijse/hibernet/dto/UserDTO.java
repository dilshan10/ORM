package it.ijse.hibernet.dto;

public class UserDTO {
    private String user_ID;
    private String user_Name;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String user_ID, String user_Name, String password) {
        this.user_ID = user_ID;
        this.user_Name = user_Name;
        this.password = password;
    }

    public String getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "user_ID='" + user_ID + '\'' +
                ", user_Name='" + user_Name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
