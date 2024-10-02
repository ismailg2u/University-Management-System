package uni.controller;


import org.springframework.web.bind.annotation.*;
import uni.dto.CourseSelectionDTO;
import uni.service.CourseSelectionService;
import uni.service.impl.CourseSelectionServiceImpl;
import uni.utility.RestResult;

import java.util.ArrayList;

@RestController
@RequestMapping("/CourseSelectionController")
public class CourseSelectionController {

    CourseSelectionService courseSelectionService = new CourseSelectionServiceImpl();


    @PostMapping("/selectCourseSelection")
    @ResponseBody
    public ArrayList<CourseSelectionDTO> selectCourseSelection(@RequestBody CourseSelectionDTO courseSelectionDTO){
        ArrayList<CourseSelectionDTO> courseSelectionList = new ArrayList<>();
        courseSelectionList = courseSelectionService.selectCourse(courseSelectionDTO);
        return courseSelectionList;
    }

    @PostMapping("/insertCourseSelection")
    @ResponseBody
    public RestResult insertCourseSelection(@RequestBody CourseSelectionDTO courseSelectionDTO){
        return courseSelectionService.insertCourseSelection(courseSelectionDTO);
    }

    @PostMapping("/updateCourseSelection")
    @ResponseBody
    public RestResult updateCourseSelection(@RequestBody CourseSelectionDTO courseSelectionDTO){
        return courseSelectionService.updateCourseSelection(courseSelectionDTO);
    }

    @PostMapping("/deleteCourseSelection")
    @ResponseBody
    public RestResult deleteCourseSelection(@RequestBody CourseSelectionDTO courseSelectionDTO){
        return courseSelectionService.deleteCourseSelection(courseSelectionDTO);
    }
}
