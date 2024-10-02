package uni.controller;

import org.springframework.web.bind.annotation.*;
import uni.dto.StudentDTO;
import uni.repository.StudentRepository;
import uni.service.StudentService;
import uni.service.impl.StudentServiceImpl;
import uni.utility.RestResult;

import java.util.ArrayList;


@RestController
@RequestMapping("/StudentController")
public class StudentController {


    StudentService studentService = new StudentServiceImpl();

    @PostMapping("/selectStudent/{dummy}")
    @ResponseBody
    public ArrayList<StudentDTO> selectStudent(@RequestBody StudentDTO studentDTO){
        ArrayList<StudentDTO> studentList = new ArrayList<>();
        studentList = studentService.selectStudent(studentDTO);
        return studentList;
    }

    @PostMapping("/insertStudent")
    @ResponseBody
    public RestResult insertStudent(@RequestBody StudentDTO studentDTO){
        return studentService.insertStudent(studentDTO);
    }

    @PostMapping("/updateStudent")
    @ResponseBody
    public RestResult updateStudent(@RequestBody StudentDTO studentDTO){
        return studentService.updateStudent(studentDTO);
    }
    @PostMapping("/deleteStudent")
    @ResponseBody
    public RestResult deleteStudent(@RequestBody StudentDTO studentDTO){
        return studentService.deleteStudent(studentDTO);
    }



}
