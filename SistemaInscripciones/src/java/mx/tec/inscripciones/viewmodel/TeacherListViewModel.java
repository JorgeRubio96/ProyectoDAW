package mx.tec.inscripciones.viewmodel;

import java.util.List;

import mx.tec.inscripciones.model.Teacher;

public class TeacherListViewModel extends BaseViewModel {
    public List<Teacher> teachers;
    
    public TeacherListViewModel(List<Teacher> teachers) {
        super("Profesores");
        this.teachers = teachers;
    }
}
