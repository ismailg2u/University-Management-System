package uni.service;

import uni.dto.StudentDTO;
import uni.dto.TeacherDTO;
import uni.utility.RestResult;

import java.util.ArrayList;

public interface StudentService {

    public ArrayList<StudentDTO> selectTeacher(StudentDTO studentDTO);
    public RestResult insertStudent(StudentDTO studentDTO);
    public RestResult deleteStudent(StudentDTO studentDTO);
    public RestResult updateStudent(StudentDTO studentDTO);
}
