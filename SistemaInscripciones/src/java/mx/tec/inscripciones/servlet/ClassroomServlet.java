package mx.tec.inscripciones.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.tec.inscripciones.store.ClassroomStore;
import mx.tec.inscripciones.model.Classroom;
import mx.tec.inscripciones.viewmodel.BaseViewModel;

public class ClassroomServlet extends BaseServlet {
    BaseViewModel vm = new BaseViewModel("Classroom");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("ccode");
        String build = request.getParameter("build");
        int number = Integer.parseInt(request.getParameter("number"));
        
        ClassroomStore store = new ClassroomStore(getDatabaseConnection());
        Classroom classroom = new Classroom(code, build, number);
        
        try {
            if(store.add(classroom)) {
                response.sendRedirect(vm.urlBase + "/listclassrooms.jsp");
            } else {
                // Failure :(
            }
        } catch (Exception e) {
            getServletContext().log("", e);
        }
    }

    protected BaseViewModel getViewModel() {
        return vm;
    }
}
