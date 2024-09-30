package uni.service.impl;

import uni.dto.DefineTypeDTO;
import uni.entity.DefineType;
import uni.mapper.impl.DefineTypeMapper;
import uni.repository.DefineTypeRepository;
import uni.service.DefineTypeService;

import java.util.ArrayList;

public class DefineTypeServiceImpl implements DefineTypeService {

    DefineTypeRepository defineTypeRepository = new DefineTypeRepository();
    DefineTypeMapper defineTypeMapper = new DefineTypeMapper();

    @Override
    public ArrayList<DefineTypeDTO> selectDefineType(DefineTypeDTO defineTypeDTO) {
        ArrayList<DefineType> defineTypeList = new ArrayList<>();
        DefineType defineType = new DefineType();
        defineType =defineTypeMapper.mapToEntity(defineTypeDTO);
        defineTypeList= defineTypeRepository.selectDefineType(defineType,null);
        return (ArrayList<DefineTypeDTO>) defineTypeMapper.mapToDTOs(defineTypeList);
    }
}
