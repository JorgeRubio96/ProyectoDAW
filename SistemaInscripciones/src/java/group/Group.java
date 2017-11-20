package group;

import java.sql.Date;

public class Group {
    private String profesor;
    private String materia;
    private Date horario;

    public Group(String p , String m, Date h) {
        this.profesor = p;
        this.materia = m;
        this.horario =  h;
    }

    public Group() {
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
