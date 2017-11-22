/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.tec.inscripciones.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.tec.inscripciones.model.Course;
import mx.tec.inscripciones.model.Teacher;
import mx.tec.inscripciones.store.ClassStore;
import mx.tec.inscripciones.viewmodel.TeacherListViewModel;

/**
 *
 * @author inspiron
 */
public class ClassServlet extends BaseServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        ClassStore store;
        try {
            store = new ClassStore(getDatabaseConnection());
        } catch (SQLException ex) {
            Logger.getLogger(ClassServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        int teacher_id = Integer.parseInt(req.getParameter("proffs"));
        int course_id = Integer.parseInt(req.getParameter("courses"));
        Class aClass;
        aClass = new Class( teacher_id);
        try {
            if(store.add(classroom)) {
                // Success!
            } else {
                // Failure :(
            }
        } catch (Exception e) {
            getServletContext().log("", e);
        }
    }
}
