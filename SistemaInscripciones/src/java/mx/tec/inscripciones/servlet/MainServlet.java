package mx.tec.inscripciones.servlet;

import com.github.mustachejava.Mustache;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.tec.inscripciones.viewmodel.BaseViewModel;

public class MainServlet extends BaseServlet {
    Mustache view;

    @Override
    public void init() {
        super.init();

        view = getMustacheFactory().compile("home.mustache");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        BaseViewModel vm = new BaseViewModel("Inicio");

        try {
            view.execute(resp.getWriter(), vm);
        } catch(Exception e) {
            getServletContext().log("", e);
        }
    }
}