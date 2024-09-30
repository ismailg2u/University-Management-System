package uni.service;

import uni.dto.CourseDTO;
import uni.utility.RestResult;

import java.util.ArrayList;

public interface CourseService {

    public ArrayList<CourseDTO> selectCourse(CourseDTO courseDTO);
    public RestResult insertCourse(CourseDTO courseDTO);
    public RestResult deleteCourse(CourseDTO courseDTO);
    public RestResult updateCourse(CourseDTO courseDTO);

}
