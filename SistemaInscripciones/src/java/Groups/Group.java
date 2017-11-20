package Groups;
import java.util.Date;
public class Group {
    private String profesor;
    private String Materia;
    private Integer CantidadAlumnos;
    private Date horario;

    public Group(String p , String m, Integer c, Date h) {
        this.profesor = p;
        this.Materia = m;
        this.CantidadAlumnos = c;
        this.horario =  h;
    }

    public Group() {
    }

    public void setProfesor(String p){
        this.profesor = p;
    }
    
    public void setMateria(String m){
        this.Materia = m;
    }
    
    public void setCantidadAlumnos(Integer c){
         this.CantidadAlumnos = c;
    }
    
    public void setHorario(Date h){
        this.horario = h;
    }
    
    public String getProfesor(){
        return profesor;
    }
    
    public String getMateria(){
        return Materia;
    }
    
    public Integer getCantidadAlumnos(){
        return CantidadAlumnos;
    }
    
    public Date getHorario(){
        return horario;
    }
}
