package mx.tec.inscripciones.servlet;

import com.github.mustachejava.Mustache;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.tec.inscripciones.model.User;
import mx.tec.inscripciones.store.UserStore;
import mx.tec.inscripciones.viewmodel.BaseViewModel;
        
public class LoginServlet extends BaseServlet {
    Mustache view;
    
    @Override
    public void init() {
        super.init();
        view = getMustacheFactory().compile("login.mustache");
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        BaseViewModel vm = new BaseViewModel("Login");
        
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
        
        UserStore userStore = new UserStore(getDataBaseConnection());
        
        try {
            User user = userStore.login(username, password);
            
            if(user != null) {
                resp.sendRedirect("/");
            } else {
                BaseViewModel vm = new BaseViewModel("Login");
                view.execute(resp.getWriter(), vm);
            }
        } catch(Exception e) {
            getServletContext().log("", e);
        }
    }
}
