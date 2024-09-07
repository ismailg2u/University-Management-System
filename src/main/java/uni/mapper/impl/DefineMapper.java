package uni.mapper.impl;

import uni.dto.DefineDTO;
import uni.entity.Define;
import uni.mapper.BaseMapper;

import java.util.ArrayList;
import java.util.List;

public class DefineMapper implements BaseMapper <Define, DefineDTO> {
    DefineTypeMapper defineTypeMapper = new DefineTypeMapper();
    @Override
    public DefineDTO mapToDTO(Define entity) {
        DefineDTO dto = new DefineDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSituation(entity.getSituation());
        dto.setDefineType(defineTypeMapper.mapToDTO(entity.getDefineType()));

        return dto;
    }

    @Override
    public Define mapToEntity(DefineDTO dto) {
        Define entity = new Define();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSituation(dto.getSituation());
        entity.setDefineType(defineTypeMapper.mapToEntity(dto.getDefineType()));
        return entity;
    }

    @Override
    public List<DefineDTO> mapToDTOs(List<Define> entityList) {
        if (entityList == null)
            return null;
        List<DefineDTO> dtoList = new ArrayList<>();
        for (Define entity: entityList) {
            dtoList.add(mapToDTO(entity));}
        return dtoList;
    }

    @Override
    public List<Define> mapToEntities(List<DefineDTO> dtoList) {
        if(dtoList == null)
            return null;
        List<Define> entityList = new ArrayList<>();
        for (DefineDTO dto: dtoList) {
            entityList.add(mapToEntity(dto));}
        return entityList;
    }
}
