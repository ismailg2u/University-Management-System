package uni.dto;



public class DefineDTO {
    private int id;
    private DefineTypeDTO defineType;
    private String name;
    private int situation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DefineTypeDTO getDefineType() {
        return defineType;
    }

    public void setDefineType(DefineTypeDTO defineType) {
        this.defineType = defineType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSituation() {
        return situation;
    }

    public void setSituation(int situation) {
        this.situation = situation;
    }



}