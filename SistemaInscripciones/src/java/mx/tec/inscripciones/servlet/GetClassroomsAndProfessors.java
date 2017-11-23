package mx.tec.inscripciones.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.tec.inscripciones.model.Classroom;
import mx.tec.inscripciones.model.Course;
import mx.tec.inscripciones.model.Teacher;
import mx.tec.inscripciones.store.ClassroomStore;
import mx.tec.inscripciones.store.CourseStore;
import mx.tec.inscripciones.store.TeacherStore;
import mx.tec.inscripciones.viewmodel.BaseViewModel;

public class GetClassroomsAndProfessors extends BaseServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        TeacherStore storet = new TeacherStore(getDatabaseConnection());
        CourseStore storec = new CourseStore(getDatabaseConnection());
        ClassroomStore storecr = new ClassroomStore(getDatabaseConnection()); 
        try {
            List<Teacher> teachers = storet.getAll();

            List<Course> courses = storec.getAll();
            List<Classroom> classrooms = storecr.getAll();
            req.setAttribute("teachers", teachers);
            req.setAttribute("courses", courses);
            req.setAttribute("classrooms", classrooms);
        } catch (Exception e) {
            getServletContext().log("", e);
        }
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
    }
}
