/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.tec.inscripciones.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.tec.inscripciones.model.Course;
import mx.tec.inscripciones.model.Teacher;
import mx.tec.inscripciones.store.CourseStore;
import mx.tec.inscripciones.store.TeacherStore;
/**
 *
 * @author inspiron
 */
public class GetClassroomsAndProfessors extends BaseServlet {

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
        TeacherStore storet = new TeacherStore(getDatabaseConnection());
        CourseStore storec = new CourseStore(getDatabaseConnection()); 
        try {
            List<Teacher> teachers = storet.getAll();
            List<Course> courses = storec.getAll();
            req.setAttribute("teachers", teachers);
            req.setAttribute("courses", courses);  
            //getServletContext().getRequestDispatcher("editAddClass.jsp").forward(req, resp);
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
