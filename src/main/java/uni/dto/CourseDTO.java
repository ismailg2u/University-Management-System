package uni.dto;

import uni.entity.Define;
import uni.entity.Teacher;

public class CourseDTO {
    private int id;
    private String name;
    private String description;
    private String quota;
    private TeacherDTO teacher;
    private int situation;
    private DefineDTO faculty;
    private  DefineDTO department ;
    private  DefineDTO term ;
    private  DefineDTO credit;
    private  DefineDTO courseStatus;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuota() {
        return quota;
    }

    public void setQuota(String quota) {
        this.quota = quota;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
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

    public DefineDTO getTerm() {
        return term;
    }

    public void setTerm(DefineDTO term) {
        this.term = term;
    }

    public DefineDTO getCredit() {
        return credit;
    }

    public void setCredit(DefineDTO credit) {
        this.credit = credit;
    }

    public DefineDTO getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(DefineDTO courseStatus) {
        this.courseStatus = courseStatus;
    }


}
