package uni.mapper.impl;

import uni.dto.CourseDTO;
import uni.entity.Course;
import uni.mapper.BaseMapper;

import java.util.ArrayList;
import java.util.List;

public class CourseMapper implements BaseMapper<Course, CourseDTO> {
    DefineMapper defineMapper = new DefineMapper();
    TeacherMapper teacherMapper = new TeacherMapper();
    @Override
    public CourseDTO mapToDTO(Course entity) {
        CourseDTO dto = new CourseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setSituation(entity.getSituation());
        dto.setQuota(entity.getQuota());
        dto.setTeacher(teacherMapper.mapToDTO(entity.getTeacher()));
        dto.setCourseStatus(defineMapper.mapToDTO(entity.getCourseStatus()));
        dto.setCredit(defineMapper.mapToDTO(entity.getCredit()));
        dto.setDepartment(defineMapper.mapToDTO(entity.getDepartment()));
        dto.setFaculty(defineMapper.mapToDTO(entity.getFaculty()));
        dto.setTerm(defineMapper.mapToDTO(entity.getTerm()));
        return dto;
    }

    @Override
    public Course mapToEntity(CourseDTO dto) {
        Course entity = new Course();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setSituation(dto.getSituation());
        entity.setQuota(dto.getQuota());
        entity.setTeacher(teacherMapper.mapToEntity(dto.getTeacher()));
        entity.setCourseStatus(defineMapper.mapToEntity(dto.getCourseStatus()));
        entity.setCredit(defineMapper.mapToEntity(dto.getCredit()));
        entity.setDepartment(defineMapper.mapToEntity(dto.getDepartment()));
        entity.setFaculty(defineMapper.mapToEntity(dto.getFaculty()));
        entity.setTerm(defineMapper.mapToEntity(dto.getTerm()));
        return entity;
    }

    @Override
    public List<CourseDTO> mapToDTOs(List<Course> entityList) {
        if(entityList == null)
            return null;
        List<CourseDTO> dtoList = new ArrayList<>();
        for (Course entity:entityList) {
            dtoList.add(mapToDTO(entity));
        }
        return dtoList;
    }

    @Override
    public List<Course> mapToEntities(List<CourseDTO> dtoList) {
        if (dtoList==null)
            return null;
        List<Course> entityList = new ArrayList<>();
        for (CourseDTO dto:dtoList) {
            entityList.add(mapToEntity(dto));
        }
        return entityList;
    }
}
