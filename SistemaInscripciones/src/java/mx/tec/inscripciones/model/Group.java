package mx.tec.inscripciones.model;

import java.sql.Date;

public class Group {
    private String clave;
    private String profesor;
    private String materia;
    private Date horario;

    public Group(String c,String p , String m, Date h) {
        this.clave = c;
        this.profesor = p;
        this.materia = m;
        this.horario =  h;
    }

    public Group() {
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
