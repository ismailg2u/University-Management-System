package uni.mapper.impl;

import uni.dto.DefineTypeDTO;
import uni.entity.DefineType;
import uni.mapper.BaseMapper;

import java.util.ArrayList;
import java.util.List;

public class DefineTypeMapper implements BaseMapper<DefineType, DefineTypeDTO> {
    @Override
    public DefineTypeDTO mapToDTO(DefineType entity) {
        DefineTypeDTO dto = new DefineTypeDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSituation(entity.getSituation());
        return dto;
    }

    @Override
    public DefineType mapToEntity(DefineTypeDTO dto) {
        DefineType entity = new DefineType();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSituation(dto.getSituation());
        return entity;
    }

    @Override
    public List<DefineTypeDTO> mapToDTOs(List<DefineType> entityList) {
        if (entityList == null)
            return null;
        List<DefineTypeDTO> dtoList = new ArrayList<>();
        for (DefineType entity: entityList) {
            dtoList.add(mapToDTO(entity));}

        return dtoList;
    }

    @Override
    public List<DefineType> mapToEntities(List<DefineTypeDTO> dtoList) {
        if(dtoList == null)
            return null;
        List<DefineType> entityList = new ArrayList<>();
        for (DefineTypeDTO dto:dtoList) {
            entityList.add(mapToEntity(dto));}
        return entityList;
    }
}
