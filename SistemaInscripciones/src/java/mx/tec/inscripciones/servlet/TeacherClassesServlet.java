package mx.tec.inscripciones.servlet;

import com.github.mustachejava.Mustache;

import java.io.IOException;
import java.lang.NumberFormatException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.tec.inscripciones.model.Teacher;
import mx.tec.inscripciones.model.Class;
import mx.tec.inscripciones.model.Course;
import mx.tec.inscripciones.store.TeacherStore;
import mx.tec.inscripciones.store.ClassStore;
import mx.tec.inscripciones.store.CourseStore;
import mx.tec.inscripciones.viewmodel.BaseViewModel;
import mx.tec.inscripciones.viewmodel.TeacherClassesViewModel;
import mx.tec.inscripciones.Pair;

public class TeacherClassesServlet extends BaseServlet {
    Mustache view;
    TeacherStore teacherStore;
    ClassStore classStore;
    CourseStore courseStore;
    TeacherClassesViewModel vm = new TeacherClassesViewModel();

    @Override
    public void init() {
        super.init();
        view = getMustacheFactory().compile("teacher-classes.mustache");
        teacherStore = new TeacherStore(getDatabaseConnection());
        courseStore = new CourseStore(getDatabaseConnection());
        try {
            classStore = new ClassStore(getDatabaseConnection());
        } catch(SQLException e) {
            getServletContext().log("", e);
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String teacherIdParam = req.getParameter("teacher-id");

        try {
            vm.teachers = teacherStore.getAll();
        } catch(SQLException e) {
            getServletContext().log("", e);
        }

        if(teacherIdParam != null && !teacherIdParam.isEmpty()) {
            try {
                int teacherId = Integer.parseInt(teacherIdParam);
                Teacher selectedTeacher = teacherStore.get(teacherId);
                ArrayList<Pair<Class, Course>> data = new ArrayList<>();

                if(selectedTeacher != null) {
                    List<Class> classes = classStore.getWhereEquals("teacher_id", teacherIdParam);

                    for(Class aClass : classes) {
                        Course course = courseStore.get(aClass.getCourseId());
                        data.add(new Pair<>(aClass, course));
                    }

                    vm.selectedTeacher = selectedTeacher;
                    vm.classes = data;
                }
            } catch(SQLException e) {
                getServletContext().log("", e);
                resp.sendError(500, "Check error logs");
                return;
            } catch(NumberFormatException e) {
                resp.sendError(400);
                return;
            }
        }

        view.execute(resp.getWriter(), vm);
    }

    @Override
    protected BaseViewModel getViewModel() {
        return vm;
    }
}