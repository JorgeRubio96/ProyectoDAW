package mx.tec.inscripciones.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.tec.inscripciones.PasswordStorage;
import mx.tec.inscripciones.model.TimeSlot;
import mx.tec.inscripciones.model.Class;
import mx.tec.inscripciones.store.ClassStore;
import mx.tec.inscripciones.viewmodel.BaseViewModel;

import mx.tec.inscripciones.viewmodel.BaseViewModel;

@WebServlet(name = "AddToDataBaseServlet", urlPatterns = {"/AddToDataBaseServlet"})
public class AddToDataBaseServlet extends BaseServlet {
    BaseViewModel vm = new BaseViewModel("Database");

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
        times = (List<TimeSlot>) request.getAttribute("times");
        ServletContext  context = getServletContext();  
 
        ClassStore classStore = null;
        try {
            classStore = new ClassStore(getDatabaseConnection());
        } catch (SQLException ex) {
            Logger.getLogger(AddToDataBaseServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            classStore = new ClassStore(getDatabaseConnection());
        } catch (SQLException ex) {
            Logger.getLogger(AddToDataBaseServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Class group = new Class( courseId, teacherId, igroupNumber, times);
            
            if(classStore.add(group)) {
                
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

    @Override
    protected BaseViewModel getViewModel() {
        return vm;
    }
}
