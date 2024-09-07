package uni.mapper.impl;

import uni.dto.CourseSelectionDTO;
import uni.entity.CourseSelection;
import uni.mapper.BaseMapper;

import java.util.ArrayList;
import java.util.List;

public class CourseSelectionMapper implements BaseMapper<CourseSelection, CourseSelectionDTO> {
    CourseMapper courseMapper = new CourseMapper();
    StudentMapper studentMapper = new StudentMapper();
    @Override
    public CourseSelectionDTO mapToDTO(CourseSelection entity) {
        CourseSelectionDTO dto = new CourseSelectionDTO();
        dto.setId(entity.getId());
        dto.setSituation(entity.getSituation());
        dto.setCourseID(courseMapper.mapToDTO(entity.getCourseID()));
        dto.setStudentID(studentMapper.mapToDTO(entity.getStudentID()));
        return dto;
    }

    @Override
    public CourseSelection mapToEntity(CourseSelectionDTO dto) {
        CourseSelection entity = new CourseSelection();
        entity.setId(dto.getId());
        entity.setSituation(dto.getSituation());
        entity.setCourseID(courseMapper.mapToEntity(dto.getCourseID()));
        entity.setStudentID(studentMapper.mapToEntity(dto.getStudentID()));
        return entity;
    }

    @Override
    public List<CourseSelectionDTO> mapToDTOs(List<CourseSelection> entityList) {
        if (entityList ==null)
            return null;
        List<CourseSelectionDTO> dtoList = new ArrayList<>();
        for (CourseSelection entity: entityList) {
            dtoList.add(mapToDTO(entity));
        }
        return dtoList;
    }

    @Override
    public List<CourseSelection> mapToEntities(List<CourseSelectionDTO> dtoList) {
        if (dtoList == null)
            return null;
        List<CourseSelection> entityList = new ArrayList<>();
        for (CourseSelectionDTO dto:dtoList) {
            entityList.add(mapToEntity(dto));
        }
        return entityList;
    }
}
