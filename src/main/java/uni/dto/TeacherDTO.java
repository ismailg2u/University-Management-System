package uni.dto;

import uni.entity.Define;

public class TeacherDTO {
    private int id;
    private String name;
    private String surname;
    private String mail;
    private String address;
    private String phoneNumber;
    private int situation;
    private DefineDTO faculty;
    private  DefineDTO department ;
    private  DefineDTO title ;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSituation() {
        return situation;
    }

    public void setSituation(int situation) {
        this.situation = situation;
    }

    public DefineDTO getFaculty() {
        return faculty;
    }

    public void setFaculty(DefineDTO faculty) {
        this.faculty = faculty;
    }

    public DefineDTO getDepartment() {
        return department;
    }

    public void setDepartment(DefineDTO department) {
        this.department = department;
    }

    public DefineDTO getTitle() {
        return title;
    }

    public void setTitle(DefineDTO title) {
        this.title = title;
    }


}
