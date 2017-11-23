package mx.tec.inscripciones.viewmodel;

import mx.tec.inscripciones.model.Teacher;

import java.util.ArrayList;

public class TeacherEditViewModel extends BaseViewModel {
    public Teacher teacher;
    public ArrayList<String> errors;
    public String action;
    
    public TeacherEditViewModel(Teacher teacher) {
        super("Profesores");
        this.teacher = teacher;
        errors = new ArrayList<>();
    }

    public TeacherEditViewModel() {
        this(null);
    }

    public void reset() {
        teacher = null;
        errors.clear();
        action = null;
    }
}
