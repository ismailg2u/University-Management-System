package uni.service.impl;

import uni.dto.DefineDTO;
import uni.entity.Define;
import uni.mapper.impl.DefineMapper;
import uni.repository.DefineRepository;
import uni.service.DefineService;

import java.util.ArrayList;

public class DefineServiceImpl implements DefineService {

    DefineRepository defineRepository = new DefineRepository();
    DefineMapper defineMapper = new DefineMapper();

    @Override
    public ArrayList<DefineDTO> selectDefine(DefineDTO defineDTO) {
        ArrayList<Define> defineList = new ArrayList<>();
        Define define = new Define();
        define = defineMapper.mapToEntity(defineDTO);
        defineList= defineRepository.selectDefine(define,null);
        return (ArrayList<DefineDTO>) defineMapper.mapToDTOs(defineList);
    }
}
