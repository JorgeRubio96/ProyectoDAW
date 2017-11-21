/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.tec.inscripciones.servlet;

import java.io.*;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mx.tec.inscripciones.model.TimeSlot;
import mx.tec.inscripciones.store.ClassStore;

@WebServlet(name = "UpdateToDataBaseServlet", urlPatterns = {"/UpdateToDataBaseServlet"})
public class UpdateToDataBaseServlet extends BaseServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        int id = Integer.parseInt(request.getParameter("classId"));
        int courseId = Integer.parseInt( request.getParameter("materia"));
        int teacherId = Integer.parseInt(request.getParameter("profesor"));
        String dia = request.getParameter("dia");
        String hrInicio = request.getParameter("hrInicio");
        String hrFin = request.getParameter("hrFin");
        String salon = request.getParameter("classroom");
        int igroupNumber = Integer.parseInt(request.getParameter("numGroup"));
        List<TimeSlot> times;
        ServletContext  context = getServletContext();  
 
        ClassStore classStore;
        try {
            classStore = new ClassStore(getDatabaseConnection());
        } catch (SQLException ex) {
            Logger.getLogger(AddToDataBaseServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            mx.tec.inscripciones.model.Class group = new mx.tec.inscripciones.model.Class( courseId, teacherId, igroupNumber, times);
            
            if(classStore.update(group)) {
                
            } else {
                
            }
        } catch(SQLIntegrityConstraintViolationException e) {
            getServletContext().log("",e);
        } catch(SQLException e) {
            getServletContext().log("", e);
        }
      
        
        
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateToDataBaseServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateToDataBaseServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

}
