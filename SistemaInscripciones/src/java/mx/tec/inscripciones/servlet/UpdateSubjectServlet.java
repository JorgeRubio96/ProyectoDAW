package mx.tec.inscripciones.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.tec.inscripciones.servlet.BaseServlet;

@WebServlet(urlPatterns = {"/updateSubjectServlet"})
public class UpdateSubjectServlet extends BaseServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Connection con = getDatabaseConnection();
        Statement myStmt;
        ResultSet myResult= null;
    
        try{
            myStmt = con.createStatement();
            myResult=myStmt.executeQuery("UPDATE course "
                    +"SET code = "+request.getParameter(", title = ")
                    +request.getParameter("nombre")+", honors = "
                    +request.getParameter("honors")
                    +"WHERE code = "+request.getParameter("code")+";");  
         } catch(Exception e){
            System.out.println("ERROR");
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<p>SUCCESS</p>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
