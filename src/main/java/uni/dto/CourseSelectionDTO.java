package uni.dto;

import uni.entity.Course;
import uni.entity.Student;

public class CourseSelectionDTO {
    private int id;
    private StudentDTO studentID;
    private CourseDTO courseID;
    private int situation;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StudentDTO getStudentID() {
        return studentID;
    }

    public void setStudentID(StudentDTO studentID) {
        this.studentID = studentID;
    }

    public CourseDTO getCourseID() {
        return courseID;
    }

    public void setCourseID(CourseDTO courseID) {
        this.courseID = courseID;
    }

    public int getSituation() {
        return situation;
    }

    public void setSituation(int situation) {
        this.situation = situation;
    }


}
