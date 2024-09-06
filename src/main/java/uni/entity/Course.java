package uni.entity;

public class Course {

    private int id;
    private String name;
    private String description;
    private String quota;
    private Teacher teacher;
    private int situation;
    private  Define faculty;
    private  Define department ;
    private  Define term ;
    private  Define credit;
    private  Define courseStatus;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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

    public Define getTerm() {
        return term;
    }

    public void setTerm(Define term) {
        this.term = term;
    }

    public Define getCredit() {
        return credit;
    }

    public void setCredit(Define credit) {
        this.credit = credit;
    }

    public Define getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(Define courseStatus) {
        this.courseStatus = courseStatus;
    }


}
