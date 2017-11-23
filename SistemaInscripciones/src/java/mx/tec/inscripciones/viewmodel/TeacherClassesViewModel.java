package mx.tec.inscripciones.viewmodel;

import java.util.ArrayList;
import java.util.List;

import mx.tec.inscripciones.model.Teacher;
import mx.tec.inscripciones.model.Class;
import mx.tec.inscripciones.model.Course;
import mx.tec.inscripciones.Pair;

public class TeacherClassesViewModel extends BaseViewModel {
    public Teacher selectedTeacher;
    public List<Pair<Class, Course>> classes;
    public List<Teacher> teachers;

    public TeacherClassesViewModel() {
        super("Grupos de Profesor");
        classes = new ArrayList<>();
        teachers = new ArrayList<>();
    }
}
