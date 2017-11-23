package mx.tec.inscripciones.servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import mx.tec.inscripciones.store.CourseStore;
import mx.tec.inscripciones.servlet.BaseServlet;
import mx.tec.inscripciones.model.Course;

@WebServlet(urlPatterns = {"/subjectServlet"})
public class subjectServlet extends BaseServlet {
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, SQLException{
    
    Connection con = getDatabaseConnection();
    Statement myStmt;
    
    response.setContentType("text/html;charset=UTF-8");
    
    try (PrintWriter out = response.getWriter()) {
      /* TODO output your page here. You may use following sample code. */
      /*out.println("<!DOCTYPE html>");
       out.println("<html>");
       out.println("<head>");
       out.println("<title>Materias disponibles</title>");            
       out.println("</head>");
       out.println("<body>");*/
      out.println("<h1>Lista de cursos a elegir</h1>");
      out.println("<table id=\"tableResults\">");
      out.println("<tr>"+
                  "<th>Clave</th>"+
                  "<th>Materia</th>"+
                  "<th>Honores</th>"+
                  "</tr>");
      
      List<Course> courses = new CourseStore(con).getAll();

      for(Course miBean : courses) {        
        String honors= miBean.getHonors()?"Honors":"Normal";
        out.println("<tr>");
        out.println("<td>"+miBean.getTitle()+
                    "</td><td>"+miBean.getCode()+
                    "</td><td> "+honors+"</td>");
        out.println("</tr>");
      }
      out.println("</table>");
      /*out.println("</body>");
       out.println("</html>");*/
    }
  }
  
  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    try {
      processRequest(request, response);
    } catch (SQLException ex) {
      Logger.getLogger(subjectServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    try {
      processRequest(request, response);
    } catch (SQLException ex) {
      Logger.getLogger(subjectServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>
  
}
