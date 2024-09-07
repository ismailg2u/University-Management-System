package uni.mapper;

import java.util.List;

/**
 * In this class we convert entities' to dtos' and dtos' to entities'
 * but we don't actually convert in this class. We created a base mapper
 * interface because, for each type of entity and dto, we will add a mapper class.
 * In each mapper class we will do same functions so, we created a base mapper interface.
 *
 */
public interface BaseMapper <Entity,DTO>{

     DTO mapToDTO(Entity entity);
     Entity mapToEntity(DTO dto);
     List<DTO> mapToDTOs(List<Entity> entities);
     List<Entity> mapToEntities(List<DTO> dtos);


}
