package mx.tec.inscripciones.servlet;

import com.github.mustachejava.Mustache;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.tec.inscripciones.model.Teacher;
import mx.tec.inscripciones.store.TeacherStore;
import mx.tec.inscripciones.viewmodel.BaseViewModel;
import mx.tec.inscripciones.viewmodel.TeacherListViewModel;
        
public class TeacherListServlet extends BaseServlet {
    Mustache view;
    TeacherStore teacherStore;
    TeacherListViewModel vm = new TeacherListViewModel();
    
    @Override
    public void init() {
        super.init();
        view = getMustacheFactory().compile("teacher-list.mustache");
        teacherStore = new TeacherStore(getDatabaseConnection());
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String pageString = req.getParameter("page");
        int page = 1;
        
        if(pageString != null)
            page = Integer.parseInt(pageString);
               
        try {
            List<Teacher> teachers = teacherStore.getAll(50, (page - 1) * 50);
            view.execute(resp.getWriter(), vm);
        } catch (Exception e) {
            getServletContext().log("", e);
        }
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("action").equals("delete")) {
            String[] ids = req.getParameterValues("delete");
            ArrayList<Integer> deleteIds = new ArrayList<>();

            try{
                for(String id : ids) {
                    deleteIds.add(Integer.parseInt(id));
                }
                
                teacherStore.delete(deleteIds);
            } catch(Exception e) {
                getServletContext().log("", e);
            }
        }

        doGet(req, resp);
    }

    @Override
    protected BaseViewModel getViewModel() {
        return vm;
    }
}
