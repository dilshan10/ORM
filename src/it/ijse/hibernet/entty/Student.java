package it.ijse.hibernet.entty;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    public Student() {}

    public Student(String student_ID, String name, String address, String contact_no, String dob, String gender) {
        this.student_ID = student_ID;
        this.name = name;
        this.address = address;
        this.contact_no = contact_no;
        this.dob = dob;
        this.gender = gender;

    }

    public String getStudent_ID() {
        return student_ID;
    }

    public void setStudent_ID(String student_ID) {
        this.student_ID = student_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Reservation> getRese() {
        return rese;
    }

    public void setRese(List<Reservation> rese) {
        this.rese = rese;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_ID='" + student_ID + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact_no='" + contact_no + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", rese=" + rese +
                '}';
    }
}
