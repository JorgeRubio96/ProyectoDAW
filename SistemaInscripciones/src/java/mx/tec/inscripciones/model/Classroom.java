package mx.tec.inscripciones.model;

public class Classroom {
    private int id;
    private String code;
    private String building;
    private int number;
    
    public Classroom(int id, String code, String building, int number) {
        this.id = id;
        this.code = code;
        this.building = building;
        this.number = number;
    }
    
    public Classroom(String code, String building, int number) {
        this(-1, code, building, number);
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getCode(){
        return this.code;
    }
    
    public void setBuilding(String build){
        this.building = build;
    }

    public String getBuilding(){
        return this.building;
    }
    
    public void setNumber(int number){
        this.number = number;
    }

    public int getNumber(){
        return this.number;
    }
}
