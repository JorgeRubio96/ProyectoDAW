package mx.tec.inscripciones.servlet;

import com.github.mustachejava.Mustache;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.tec.inscripciones.model.User;
import mx.tec.inscripciones.store.UserStore;
import mx.tec.inscripciones.viewmodel.BaseViewModel;
        
public class RegisterServlet extends BaseServlet {
    Mustache view;
    
    @Override
    public void init() {
        super.init();
        view = getMustacheFactory().compile("register.mustache");
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        BaseViewModel vm = new BaseViewModel("Register");
        
        try {
            view.execute(resp.getWriter(), vm);
        } catch (IOException e) {
            getServletContext().log("", e);
        }
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String username = (String) req.getAttribute("username");
        String password = (String) req.getAttribute("password");
        String firstName = (String) req.getAttribute("first-name");
        String lastName = (String) req.getAttribute("last-name");
        String confirm = (String) req.getAttribute("confirm");
        
        UserStore userStore = new UserStore(getDatabaseConnection());
        
        try {
            User user = new User(firstName, lastName, username, password);
            
            if(userStore.add(user)) {
                resp.sendRedirect("/login");
            } else {
                BaseViewModel vm = new BaseViewModel("Register");
                view.execute(resp.getWriter(), vm);
            }
        } catch(Exception e) {
            getServletContext().log("", e);
        }
    }
}
