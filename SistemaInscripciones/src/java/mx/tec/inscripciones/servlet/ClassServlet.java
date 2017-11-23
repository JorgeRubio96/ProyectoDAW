package mx.tec.inscripciones.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.tec.inscripciones.model.Course;
import mx.tec.inscripciones.model.Teacher;
import mx.tec.inscripciones.model.Class;
import mx.tec.inscripciones.model.TimeSlot;
import mx.tec.inscripciones.store.ClassStore;
import mx.tec.inscripciones.viewmodel.BaseViewModel;

public class ClassServlet extends BaseServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) 
        throws ServletException, IOException {
        ClassStore store = null;
        try {
            store = new ClassStore(getDatabaseConnection());
        } catch (SQLException ex) {
            Logger.getLogger(ClassServlet.class.getName()).log(Level.SEVERE, null, ex);
            resp.sendError(500, "Check error logs");
            return;
        }

        int teacher_id = Integer.parseInt(req.getParameter("profesor"));
        int course_id = Integer.parseInt(req.getParameter("materia"));
        int group = Integer.parseInt(req.getParameter("numGroup"));
        
        String[] time_start = req.getParameterValues("time_start");
        String[] time_end = req.getParameterValues("time_end");
        String[] day = req.getParameterValues("day");
        String[] classrooms = req.getParameterValues("classroom");
        
        List<TimeSlot> times = new ArrayList();
        
        for (int i=0; i < time_start.length; i++) {

            if (!time_start[i].isEmpty() &&
                !time_end[i].isEmpty()) {
                TimeSlot time = new TimeSlot(time_start[i] + ":00", time_end[i] + ":00", day[i], Integer.parseInt(classrooms[i]));
                times.add(time);
            }
        }
        
        Class classs = new Class(course_id, teacher_id, group, times);
        try {
            if(store.add(classs)) {
                resp.sendRedirect("listGroups.jsp");
            } else {
                // Failure :(
            }
        } catch (Exception e) {
            getServletContext().log("", e);
        }
    }
}
