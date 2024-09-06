package uni.entity;

public class Teacher {
    private int id;
    private String name;
    private String surname;
    private String mail;
    private String address;
    private String phoneNumber;
    private int situation;
    private  Define faculty;
    private  Define department ;
    private  Define title ;

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

    public Define getFaculty() {
        return faculty;
    }

    public void setFaculty(Define faculty) {
        this.faculty = faculty;
    }

    public Define getDepartment() {
        return department;
    }

    public void setDepartment(Define department) {
        this.department = department;
    }

    public Define getTitle() {
        return title;
    }

    public void setTitle(Define title) {
        this.title = title;
    }


}
