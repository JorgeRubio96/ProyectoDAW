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

/**
 *
 * @author avm
 */
@WebServlet(urlPatterns = {"/subjectServlet"})
public class subjectServlet extends HttpServlet {
  
  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, SQLException{
    
    String url = "jdbc:odbc:NAMAE";
    String username = "guest";
    String password = "guest";
    Connection con;
    Statement myStmt;
    ResultSet myResult= null;
    
    try{
      con= DriverManager.getConnection(url, username, password);
      myStmt = con.createStatement();
      myResult=myStmt.executeQuery("SELECT * FROM course;");  
    }
    
    catch(Exception e){
      System.out.println("ERROR");
    }
    
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
      
      while ( myResult.next()) {
        
        CourseBean miBean= new CourseBean();
        
        miBean.setCodigo(myResult.getString("code"));
        miBean.setNombre(myResult.getString("title"));
        miBean.setHonores(myResult.getBoolean("honors"));
        
        String honors= miBean.getHonores()?"Honors":"Normal";
        out.println("<tr>");
        out.println("<td>"+miBean.getNombre()+
                    "</td><td>"+miBean.getCodigo()+
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
