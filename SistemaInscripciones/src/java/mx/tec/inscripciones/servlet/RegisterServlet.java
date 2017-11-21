package mx.tec.inscripciones.servlet;

import com.github.mustachejava.Mustache;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.tec.inscripciones.PasswordStorage;

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
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String firstName = req.getParameter("first-name");
        String lastName = req.getParameter("last-name");
        String confirm = req.getParameter("confirm");
        
        UserStore userStore = new UserStore(getDatabaseConnection());
        
        try {
            User user = new User(firstName, lastName, username, password);
            
            if(userStore.add(user)) {
                resp.sendRedirect("login");
                return;
            } else {
                
            }
        } catch(SQLIntegrityConstraintViolationException e) {
            // Empalme de username
            BaseViewModel vm = new BaseViewModel("Register");
            view.execute(resp.getWriter(), vm);
        } catch(SQLException | 
                PasswordStorage.CannotPerformOperationException e) {
            getServletContext().log("", e);
        }
      
        BaseViewModel vm = new BaseViewModel("Register");
        view.execute(resp.getWriter(), vm);
    }
}
