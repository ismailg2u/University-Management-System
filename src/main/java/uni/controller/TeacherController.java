package uni.controller;


import org.springframework.web.bind.annotation.*;
import uni.dto.TeacherDTO;
import uni.service.TeacherService;
import uni.service.impl.TeacherServiceImpl;
import uni.utility.RestResult;

import java.util.ArrayList;

@RestController
@RequestMapping("/TeacherController")
public class TeacherController {
    TeacherService teacherService = new TeacherServiceImpl();


    @PostMapping("/selectTeacher")
    @ResponseBody
    public ArrayList<TeacherDTO> selectTeacher(@RequestBody TeacherDTO teacherDTO){
        ArrayList<TeacherDTO> teacherList = new ArrayList<>();
        teacherList = teacherService.selectTeacher(teacherDTO);
        return teacherList;
    }

    @PostMapping("/insertTeacher")
    @ResponseBody
    public RestResult insertTeacher(@RequestBody TeacherDTO teacherDTO){
        return teacherService.insertTeacher(teacherDTO);
    }
    @PostMapping("/updateTeacher")
    @ResponseBody
    public RestResult updateTeacher(@RequestBody TeacherDTO teacherDTO){
        return teacherService.updateTeacher(teacherDTO);
    }

    @PostMapping("/deleteTeacher")
    @ResponseBody
    public RestResult deleteTeacher(@RequestBody TeacherDTO teacherDTO){
        return teacherService.deleteTeacher(teacherDTO);
    }
}
