package uni.service;

import uni.dto.CourseDTO;
import uni.dto.CourseSelectionDTO;
import uni.utility.RestResult;

import java.util.ArrayList;

public interface CourseSelectionService {
    public ArrayList<CourseSelectionDTO> selectCourse(CourseSelectionDTO courseSelectionDTO);
    public RestResult insertCourseSelection(CourseSelectionDTO courseSelectionDTO);
    public RestResult deleteCourseSelection(CourseSelectionDTO courseSelectionDTO);
    public RestResult updateCourseSelection(CourseSelectionDTO courseSelectionDTO);
}
