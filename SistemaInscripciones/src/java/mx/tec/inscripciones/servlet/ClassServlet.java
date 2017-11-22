/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.tec.inscripciones.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> 2de2b0d42fdc9b85d7ca96af14bf01e7644238f5
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.tec.inscripciones.model.Course;
import mx.tec.inscripciones.model.Teacher;
import mx.tec.inscripciones.model.Class;
import mx.tec.inscripciones.model.TimeSlot;
import mx.tec.inscripciones.store.ClassStore;
import mx.tec.inscripciones.viewmodel.TeacherListViewModel;

/**
 *
 * @author inspiron
 */
public class ClassServlet extends BaseServlet {
    
    @Override
<<<<<<< HEAD
    public void doGet(HttpServletRequest req, HttpServletResponse resp) 
        throws ServletException, IOException {
        ClassStore store = null;
=======
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        ClassStore store;
>>>>>>> 2de2b0d42fdc9b85d7ca96af14bf01e7644238f5
        try {
            store = new ClassStore(getDatabaseConnection());
        } catch (SQLException ex) {
            Logger.getLogger(ClassServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        int teacher_id = Integer.parseInt(req.getParameter("proffs"));
        int course_id = Integer.parseInt(req.getParameter("courses"));
<<<<<<< HEAD
        int group = Integer.parseInt(req.getParameter("group"));
        String[] time_starth = req.getParameterValues("time_starth");
        String[] time_startm = req.getParameterValues("time_startm");
        String[] time_endh = req.getParameterValues("time_endh");
        String[] time_endm = req.getParameterValues("time_endm");
        String[] day = req.getParameterValues("day");
        String[] classrooms = req.getParameterValues("salon");
        List<TimeSlot> times = new ArrayList();
        for (int i=0; i < time_starth.length; i++) {
            if ((!time_starth[i].equals(""))&&(!time_startm[i].equals(""))&&(!time_endh[i].equals(""))&&(!time_endm[i].equals(""))) {
                TimeSlot time = new TimeSlot(time_starth[i]+":"+time_startm[i]+":00", time_endh[i]+":"+time_endm[i]+":00", day[i], Integer.parseInt(classrooms[i]));
                times.add(time);
            }
        }
        Class classs = new Class(course_id, teacher_id, group, times);
=======
        Class aClass;
        aClass = new Class( teacher_id);
>>>>>>> 2de2b0d42fdc9b85d7ca96af14bf01e7644238f5
        try {
            if(store.add(classs)) {
                // Success!
            } else {
                // Failure :(
            }
        } catch (Exception e) {
            getServletContext().log("", e);
        }
    }
}
