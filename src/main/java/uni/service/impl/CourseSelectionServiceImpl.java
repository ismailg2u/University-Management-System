package uni.service.impl;

import uni.dto.CourseSelectionDTO;
import uni.entity.CourseSelection;
import uni.mapper.impl.CourseSelectionMapper;
import uni.repository.CourseSelectionRepository;
import uni.service.CourseSelectionService;
import uni.utility.RestResult;

import java.util.ArrayList;

public class CourseSelectionServiceImpl implements CourseSelectionService {

    CourseSelectionRepository courseSelectionRepository = new CourseSelectionRepository();
    CourseSelectionMapper courseSelectionMapper = new CourseSelectionMapper();

    @Override
    public ArrayList<CourseSelectionDTO> selectCourse(CourseSelectionDTO courseSelectionDTO) {
        ArrayList<CourseSelection> courseSelectionList = new ArrayList<>();
        CourseSelection courseSelection = new CourseSelection();
        courseSelection = courseSelectionMapper.mapToEntity(courseSelectionDTO);
        courseSelectionList = courseSelectionRepository.selectCourseSelection(courseSelection,null);
        return (ArrayList<CourseSelectionDTO>) courseSelectionMapper.mapToDTOs(courseSelectionList);
     }

    @Override
    public RestResult insertCourseSelection(CourseSelectionDTO courseSelectionDTO) {
        RestResult result = new RestResult();
        CourseSelection courseSelection = new CourseSelection();
        courseSelection = courseSelectionMapper.mapToEntity(courseSelectionDTO);
        result = courseSelectionRepository.insertCourseSelection(courseSelection,null);
        return result;
    }

    @Override
    public RestResult deleteCourseSelection(CourseSelectionDTO courseSelectionDTO) {
        RestResult result = new RestResult();
        CourseSelection courseSelection = new CourseSelection();
        courseSelection = courseSelectionMapper.mapToEntity(courseSelectionDTO);
        result = courseSelectionRepository.deleteCourseSelection(courseSelection,null);
        return result;
    }

    @Override
    public RestResult updateCourseSelection(CourseSelectionDTO courseSelectionDTO) {
        RestResult result = new RestResult();
        CourseSelection courseSelection = new CourseSelection();
        courseSelection = courseSelectionMapper.mapToEntity(courseSelectionDTO);
        result = courseSelectionRepository.updateCourseSelection(courseSelection,null);
        return result;
    }
}
