package mx.tec.inscripciones.servlet;

import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.tec.inscripciones.store.ClassroomStore;

public class DeleteClassroomsServlet extends BaseServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<Integer> selectedClassrooms = new ArrayList<>();
        
        for(String val: request.getParameterValues("selected")) {
            selectedClassrooms.add(Integer.parseInt(val));
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try {
            ClassroomStore store = new ClassroomStore(getDatabaseConnection());
            int deleted = store.delete(selectedClassrooms);
            
            if(deleted == selectedClassrooms.size()) {
                // Success!
            } else {
                // Error :(
            }

        } catch(Exception e) {
            getServletContext().log("", e);
        }
    }
}
