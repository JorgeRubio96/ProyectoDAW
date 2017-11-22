package mx.tec.inscripciones.servlet;

import com.github.mustachejava.Mustache;

import java.io.IOException;
import java.lang.NumberFormatException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.tec.inscripciones.model.Teacher;
import mx.tec.inscripciones.store.TeacherStore;
import mx.tec.inscripciones.viewmodel.BaseViewModel;
import mx.tec.inscripciones.viewmodel.TeacherEditViewModel;

public class TeacherEditServlet extends BaseServlet {
    Mustache view;
    TeacherStore teacherStore;
    TeacherEditViewModel vm = new TeacherEditViewModel();

    @Override
    public void init() {
        super.init();
        view = getMustacheFactory().compile("teacher-edit.mustache");
        teacherStore = new TeacherStore(getDatabaseConnection());
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String path = req.getServletPath();
        String action = path.substring(path.lastIndexOf('/') + 1);

        if(action.equals("edit")) {
            try {
                int id = Integer.parseInt(req.getParameter("id"));
                vm.teacher = teacherStore.get(id);

                if(vm.teacher == null) {
                    resp.sendError(404);
                    return;
                }
            } catch(NumberFormatException e) {
                resp.sendError(400);
                return;
            } catch(SQLException e) {
                getServletContext().log("", e);
                resp.sendError(500, "Check error logs");
                return;
            }
        }

        vm.action = action;

        view.execute(resp.getWriter(), vm);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String path = req.getServletPath();
        String action = path.substring(path.lastIndexOf('/') + 1);
        boolean edit = action.equals("edit");

        String nomina = req.getParameter("nomina");
        String firstName = req.getParameter("first-name");
        String lastName = req.getParameter("last-name");
        String email = req.getParameter("email");

        Teacher teacher = new Teacher(nomina, firstName, lastName, email);

        if(edit) {
            try {
                int id = Integer.parseInt(req.getParameter("id"));
                teacher.setId(id);
            } catch(NumberFormatException e) {
                resp.sendError(400);
                return;
            }
        }


        if(nomina == null || nomina.isEmpty())
            vm.errors.add("Nomina no debería estar vacio");

        if(firstName == null || firstName.isEmpty())
            vm.errors.add("Nombre(s) no debería estar vacio");

        if(lastName == null || lastName.isEmpty())
            vm.errors.add("Apellidos no debería estar vacio");
        
        if(email == null || email.isEmpty())
            vm.errors.add("Email no debería estar vacio");


        if(!vm.errors.isEmpty()) {
            vm.teacher = teacher;
            view.execute(resp.getWriter(), vm);
            return;
        }

        if(edit) {
            try {
                int id = Integer.parseInt(req.getParameter("id"));

                teacher.setId(id);

                if(teacherStore.update(teacher)) {
                    resp.sendRedirect("/teachers");
                }
            } catch(NumberFormatException e) {
                resp.sendError(400);
            } catch(SQLException e) {
                getServletContext().log("", e);
                resp.sendError(500, "Check error logs");
            }
        } else {
            try {
                if(teacherStore.add(teacher)) {
                    resp.sendRedirect("/teachers");
                }
            } catch(SQLException e) {
                getServletContext().log("", e);
                resp.sendError(500, "Check error logs");
            }
        }
    }

    @Override
    protected BaseViewModel getViewModel() {
        return vm;
    }
}
