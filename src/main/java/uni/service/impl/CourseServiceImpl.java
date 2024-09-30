package uni.service.impl;

import uni.dto.CourseDTO;
import uni.entity.Course;
import uni.mapper.impl.CourseMapper;
import uni.repository.CourseRepository;
import uni.service.CourseService;
import uni.utility.RestResult;

import java.util.ArrayList;

public class CourseServiceImpl implements CourseService {

    CourseRepository courseRepository = new CourseRepository();
    CourseMapper courseMapper = new CourseMapper();

    @Override
    public ArrayList<CourseDTO> selectCourse(CourseDTO courseDTO) {
        ArrayList<Course> courseList = new ArrayList<>();
        Course course = new Course();
        course = courseMapper.mapToEntity(courseDTO);
        courseList = courseRepository.selectCourse(course,null);
        return (ArrayList<CourseDTO>) courseMapper.mapToDTOs(courseList);
    }

    @Override
    public RestResult insertCourse(CourseDTO courseDTO) {
        RestResult result = new RestResult();
        Course course = new Course();
        course = courseMapper.mapToEntity(courseDTO);
        result = courseRepository.insertCourse(course,null);
        return result;
    }

    @Override
    public RestResult deleteCourse(CourseDTO courseDTO) {
        RestResult result = new RestResult();
        Course course = new Course();
        course = courseMapper.mapToEntity(courseDTO);
        result = courseRepository.deleteCourse(course,null);
        return result;
    }

    @Override
    public RestResult updateCourse(CourseDTO courseDTO) {
        RestResult result = new RestResult();
        Course course = new Course();
        course = courseMapper.mapToEntity(courseDTO);
        result = courseRepository.updateCourse(course,null);
        return result;
    }
}
