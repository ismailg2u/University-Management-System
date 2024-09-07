package uni.mapper.impl;

import uni.dto.StudentDTO;
import uni.entity.Student;
import uni.mapper.BaseMapper;

import java.util.ArrayList;
import java.util.List;

public class StudentMapper implements BaseMapper<Student, StudentDTO> {
    DefineMapper defineMapper = new DefineMapper();
    @Override
    public StudentDTO mapToDTO(Student entity) {
        StudentDTO dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setAddress(entity.getAddress());
        dto.setMail(entity.getMail());
        dto.setName(entity.getName());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setSurname(entity.getSurname());
        dto.setSituation(entity.getSituation());
        dto.setDepartment(defineMapper.mapToDTO(entity.getDepartment()));
        dto.setFaculty(defineMapper.mapToDTO(entity.getFaculty()));
    return dto;
    }

    @Override
    public Student mapToEntity(StudentDTO dto) {
        Student entity = new Student();
        entity.setId(dto.getId());
        entity.setAddress(dto.getAddress());
        entity.setMail(dto.getMail());
        entity.setName(dto.getName());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setSurname(dto.getSurname());
        entity.setSituation(dto.getSituation());
        entity.setDepartment(defineMapper.mapToEntity(dto.getDepartment()));
        entity.setFaculty(defineMapper.mapToEntity(dto.getFaculty()));
        return entity;
    }

    @Override
    public List<StudentDTO> mapToDTOs(List<Student> entityList) {
        if (entityList==null)
            return null;
        List<StudentDTO> dtoList= new ArrayList<>();
        for (Student entity:entityList) {
            dtoList.add(mapToDTO(entity));
        }
        return dtoList;
    }

    @Override
    public List<Student> mapToEntities(List<StudentDTO> dtoList) {
        if (dtoList==null)
            return null;
        List<Student> entityList = new ArrayList<>();
        for (StudentDTO dto:dtoList) {
            entityList.add(mapToEntity(dto));
        }
        return entityList;
    }
}
