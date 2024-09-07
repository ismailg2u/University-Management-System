package uni.mapper.impl;

import uni.dto.TeacherDTO;
import uni.entity.Teacher;
import uni.mapper.BaseMapper;

import java.util.ArrayList;
import java.util.List;

public class TeacherMapper implements BaseMapper<Teacher, TeacherDTO> {
    DefineMapper defineMapper = new DefineMapper();

    @Override
    public TeacherDTO mapToDTO(Teacher entity) {
        TeacherDTO dto = new TeacherDTO();
        dto.setId(entity.getId());
        dto.setAddress(entity.getAddress());
        dto.setMail(entity.getMail());
        dto.setName(entity.getName());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setSurname(entity.getSurname());
        dto.setSituation(entity.getSituation());
        dto.setDepartment(defineMapper.mapToDTO(entity.getDepartment()));
        dto.setFaculty(defineMapper.mapToDTO(entity.getFaculty()));
        dto.setTitle(defineMapper.mapToDTO(entity.getTitle()));
        return dto;

    }

    @Override
    public Teacher mapToEntity(TeacherDTO dto) {
        Teacher entity = new Teacher();
        entity.setId(dto.getId());
        entity.setAddress(dto.getAddress());
        entity.setMail(dto.getMail());
        entity.setName(dto.getName());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setSurname(dto.getSurname());
        entity.setSituation(dto.getSituation());
        entity.setDepartment(defineMapper.mapToEntity(dto.getDepartment()));
        entity.setFaculty(defineMapper.mapToEntity(dto.getFaculty()));
        entity.setTitle(defineMapper.mapToEntity(dto.getTitle()));
        return entity;
    }

    @Override
    public List<TeacherDTO> mapToDTOs(List<Teacher> entityList) {
        if (entityList == null)
            return null;
        List<TeacherDTO> dtoList = new ArrayList<>();
        for (Teacher entity: entityList) {
            dtoList.add(mapToDTO(entity));

        }
        return dtoList;
    }

    @Override
    public List<Teacher> mapToEntities(List<TeacherDTO> dtoList) {
        if (dtoList == null)
            return null;
        List<Teacher> entityList = new ArrayList<>();

        for (TeacherDTO dto:dtoList) {
            entityList.add(mapToEntity(dto));
        }
        return entityList;
    }
}
