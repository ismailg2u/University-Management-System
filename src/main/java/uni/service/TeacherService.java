package uni.service;

import uni.dto.StudentDTO;
import uni.dto.TeacherDTO;
import uni.utility.RestResult;

import java.util.ArrayList;

public interface TeacherService {
    public ArrayList<TeacherDTO> selectTeacher(TeacherDTO teacherDTO);
    public RestResult insertTeacher(TeacherDTO teacherDTO);
    public RestResult deleteTeacher(TeacherDTO teacherDTO);
    public RestResult updateTeacher(TeacherDTO teacherDTO);
}
