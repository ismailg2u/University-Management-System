package uni.entity;

public class Define {
    private int id;
    private DefineType defineType;
    private String name;
    private int situation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DefineType getDefineType() {
        return defineType;
    }

    public void setDefineType(DefineType defineType) {
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
