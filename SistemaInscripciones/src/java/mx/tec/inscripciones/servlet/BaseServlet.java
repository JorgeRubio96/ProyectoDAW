package mx.tec.inscripciones.servlet;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.MustacheFactory;
import java.net.MalformedURLException;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

import mx.tec.inscripciones.TomcatResolver;
import mx.tec.inscripciones.viewmodel.BaseViewModel;

public abstract class BaseServlet extends HttpServlet {
    private Connection databaseConnection;
    private MustacheFactory mustacheFactory;
    
    @Override
    public void init() {
        try {
            InitialContext initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/sistema_inscripciones");

            databaseConnection = ds.getConnection();
        } catch(SQLException | NamingException e) {
            getServletContext().log("", e);
        }
        
        BaseViewModel vm = getViewModel();
        if(vm != null) {
            vm.urlBase = getServletContext().getContextPath();
            vm.cssUriList.add("/estiloInscripciones.css");
        }
    }
    
    protected Connection getDatabaseConnection() {
        return databaseConnection;
    }
    
    protected MustacheFactory getMustacheFactory() {
        if(mustacheFactory == null) {
            TomcatResolver resolver = new TomcatResolver(getServletContext(), "/WEB-INF/templates/");
            mustacheFactory = new DefaultMustacheFactory(resolver);
        }
        return mustacheFactory;
    }

    protected BaseViewModel getViewModel() {
        return null;
    }
}