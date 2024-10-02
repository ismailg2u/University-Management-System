package uni.controller;

import org.springframework.web.bind.annotation.*;
import uni.dto.DefineTypeDTO;
import uni.service.DefineTypeService;
import uni.service.impl.DefineTypeServiceImpl;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;


@RestController
@RequestMapping("/DefineTypeController")
public class DefineTypeController {


    DefineTypeService defineTypeService = new DefineTypeServiceImpl();


    @PostMapping("/selectDefineType/{dummy}")
    @ResponseBody
    public ArrayList<DefineTypeDTO> selectDefineType(@RequestBody DefineTypeDTO defineTypeDTO){
        ArrayList<DefineTypeDTO> DefineTypeList= new ArrayList<DefineTypeDTO>();
        DefineTypeList=defineTypeService.selectDefineType(defineTypeDTO);
        return DefineTypeList;
    }






}
