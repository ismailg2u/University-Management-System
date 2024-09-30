package uni.service.impl;

import uni.dto.TeacherDTO;
import uni.entity.Teacher;
import uni.mapper.impl.TeacherMapper;
import uni.repository.TeacherRepository;
import uni.service.TeacherService;
import uni.utility.RestResult;

import java.util.ArrayList;

public class TeacherServiceImpl implements TeacherService {

    TeacherRepository teacherRepository = new TeacherRepository();
    TeacherMapper teacherMapper = new TeacherMapper();


    @Override
    public ArrayList<TeacherDTO> selectTeacher(TeacherDTO teacherDTO) {
        ArrayList<Teacher> teacherList = new ArrayList<>();
        Teacher teacher = new Teacher();
        teacher = teacherMapper.mapToEntity(teacherDTO);
        teacherList = teacherRepository.selectTeacher(teacher,null);
        return (ArrayList<TeacherDTO>) teacherMapper.mapToDTOs(teacherList);

    }

    @Override
    public RestResult insertTeacher(TeacherDTO teacherDTO) {
        RestResult result = new RestResult();
        Teacher teacher = new Teacher();
        teacher = teacherMapper.mapToEntity(teacherDTO);
        result = teacherRepository.insertTeacher(teacher,null);
        return result;
    }

    @Override
    public RestResult deleteTeacher(TeacherDTO teacherDTO) {
        RestResult result = new RestResult();
        Teacher teacher = new Teacher();
        teacher = teacherMapper.mapToEntity(teacherDTO);
        result = teacherRepository.deleteTeacher(teacher,null);
        return result;
    }

    @Override
    public RestResult updateTeacher(TeacherDTO teacherDTO) {
        RestResult result = new RestResult();
        Teacher teacher = new Teacher();
        teacher = teacherMapper.mapToEntity(teacherDTO);
        result = teacherRepository.updateTeacher(teacher,null);
        return result;
    }
}
