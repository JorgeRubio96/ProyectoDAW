package mx.tec.inscripciones.servlet;

import com.github.mustachejava.Mustache;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.tec.inscripciones.model.User;
import mx.tec.inscripciones.store.UserStore;
import mx.tec.inscripciones.viewmodel.BaseViewModel;
import mx.tec.inscripciones.viewmodel.LoginViewModel;
        
public class LoginServlet extends BaseServlet {
    Mustache view;
    LoginViewModel vm = new LoginViewModel();
    
    @Override
    public void init() {
        super.init();
        view = getMustacheFactory().compile("login.mustache");
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            view.execute(resp.getWriter(), getViewModel());
        } catch (IOException e) {
            getServletContext().log("", e);
        }
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        UserStore userStore = new UserStore(getDatabaseConnection());
        
        try {
            User user = userStore.login(username, password);
            
            if(user != null) {
                resp.sendRedirect("/");
            } else {
                vm.setError("Usuario o contraseña incorrecta");                
                view.execute(resp.getWriter(), getViewModel());
            }
        } catch(Exception e) {
            getServletContext().log("", e);
        }
    }
    
    @Override
    protected BaseViewModel getViewModel() {
        return vm;
    }
}
