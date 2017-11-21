package mx.tec.inscripciones.model;

import java.sql.Date;

public class Group {
    int id;
    private String clave;
    private String profesor;
    private String materia;
    private Date horario;

    public Group(int id, String c,String p , String m, Date h) {
        this.id = id;
        this.clave = c;
        this.profesor = p;
        this.materia = m;
        this.horario =  h;
    }
    
    public Group(String c,String p , String m, Date h) {
        this(-1, c, p, m, h);
    }

    public void setClave(String c){
        this.clave = c;
    }
    
    public void setProfesor(String p){
        this.profesor = p;
    }
    
    public void setMateria(String m){
        this.materia = m;
    }
    
    public void setHorario(Date h){
        this.horario = h;
    }
    
    public String getClave(){
        return clave;
    }
    
    public String getProfesor(){
        return profesor;
    }
    
    public String getMateria(){
        return materia;
    }
    
    public Date getHorario(){
        return horario;
    }
}
