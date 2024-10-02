package uni.controller;

import org.springframework.web.bind.annotation.*;
import uni.dto.DefineDTO;
import uni.dto.DefineTypeDTO;
import uni.service.DefineService;
import uni.service.impl.DefineServiceImpl;

import java.util.ArrayList;

@RestController
@RequestMapping("/DefineController")
public class DefineController {
    DefineService defineService = new DefineServiceImpl();

    @PostMapping("selectDefine/{dummy}")
    @ResponseBody
    public ArrayList<DefineDTO> selectDefine(@RequestBody DefineDTO defineDTO){
        ArrayList<DefineDTO> defineList= new ArrayList<DefineDTO>();
        defineList =  defineService.selectDefine(defineDTO);
        return defineList;
    }






}
