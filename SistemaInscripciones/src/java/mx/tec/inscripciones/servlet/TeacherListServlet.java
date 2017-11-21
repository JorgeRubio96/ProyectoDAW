package mx.tec.inscripciones.servlet;

import com.github.mustachejava.Mustache;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.tec.inscripciones.model.Teacher;
import mx.tec.inscripciones.store.TeacherStore;
import mx.tec.inscripciones.viewmodel.TeacherListViewModel;
        
public class TeacherListServlet extends BaseServlet {
    Mustache view;
    
    @Override
    public void init() {
        super.init();
        view = getMustacheFactory().compile("teacher-list.mustache");
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String pageString = req.getParameter("page");
        int page = 1;
        
        if(pageString != null)
            page = Integer.parseInt(pageString);

        TeacherStore store = new TeacherStore(getDatabaseConnection());
               
        try {
            List<Teacher> teachers = store.getAll(50, (page - 1) * 50);
            TeacherListViewModel vm = new TeacherListViewModel(teachers);
            view.execute(resp.getWriter(), vm);
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
