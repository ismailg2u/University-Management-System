package uni.service.impl;

import uni.dto.StudentDTO;
import uni.entity.Student;
import uni.mapper.impl.StudentMapper;
import uni.repository.StudentRepository;
import uni.service.StudentService;
import uni.utility.RestResult;

import java.util.ArrayList;

public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository = new StudentRepository();
    StudentMapper studentMapper = new StudentMapper();

    @Override
    public ArrayList<StudentDTO> selectStudent(StudentDTO studentDTO) {
        ArrayList<Student> studentList = new ArrayList<>();
        Student student = new Student();
        student = studentMapper.mapToEntity(studentDTO);
        studentList = studentRepository.selectStudent(student,null);
        return (ArrayList<StudentDTO>) studentMapper.mapToDTOs(studentList);
    }

    @Override
    public RestResult insertStudent(StudentDTO studentDTO) {
         RestResult result = new RestResult();
         Student student = new Student();
         student = studentMapper.mapToEntity(studentDTO);
         result =studentRepository.insertStudent(student,null);
         return result;
    }

    @Override
    public RestResult deleteStudent(StudentDTO studentDTO) {
        RestResult result = new RestResult();
        Student student = new Student();
        student = studentMapper.mapToEntity(studentDTO);
        result =studentRepository.deleteStudent(student,null);
        return result;
    }

    @Override
    public RestResult updateStudent(StudentDTO studentDTO) {
        RestResult result = new RestResult();
        Student student = new Student();
        student = studentMapper.mapToEntity(studentDTO);
        result =studentRepository.updateStudent(student,null);
        return result;
    }
}
