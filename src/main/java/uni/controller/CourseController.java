package uni.controller;


import org.springframework.web.bind.annotation.*;
import uni.dto.CourseDTO;
import uni.service.CourseService;
import uni.service.impl.CourseServiceImpl;
import uni.utility.RestResult;

import java.util.ArrayList;

@RestController
@RequestMapping("/CourseController")
public class CourseController {

    CourseService courseService = new CourseServiceImpl();


    @PostMapping("/selectCourse")
    @ResponseBody
    public ArrayList<CourseDTO> selectCourse(@RequestBody CourseDTO courseDTO){
        ArrayList<CourseDTO> courseList = new ArrayList<>();
        courseList = courseService.selectCourse(courseDTO);
        return courseList;

    }

    @PostMapping("/insertCourse")
    @ResponseBody
    public RestResult insertCourse(@RequestBody CourseDTO courseDTO){
        return courseService.insertCourse(courseDTO);
    }

    @PostMapping("/updateCourse")
    @ResponseBody
    public RestResult updateCourse(@RequestBody CourseDTO courseDTO){
        return courseService.updateCourse(courseDTO);
    }

    @PostMapping("/deleteCourse")
    @ResponseBody
    public RestResult deleteCourse(@RequestBody CourseDTO courseDTO){
        return courseService.deleteCourse(courseDTO);
    }
}
