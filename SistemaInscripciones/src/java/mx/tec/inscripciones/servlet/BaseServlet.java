package mx.tec.inscripciones.servlet;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.MustacheFactory;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

import mx.tec.inscripciones.TomcatResolver;

public abstract class BaseServlet extends HttpServlet {
    private Connection databaseConnection;
    private MustacheFactory mustacheFactory;
    
    @Override
    public void init() {
        try {
            InitialContext initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/sistema_inscripciones");
            
            databaseConnection = ds.getConnection();
        } catch(Exception e) {
            getServletContext().log("", e);
        }
        
        mustacheFactory = new DefaultMustacheFactory(new TomcatResolver(getServletContext(), "/WEB-INF/templates/"));
    }
    
    protected Connection getDatabaseConnection() {
        return databaseConnection;
    }
    
    protected MustacheFactory getMustacheFactory() {
        return mustacheFactory;
    }
}