/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.tec.inscripciones.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import mx.tec.inscripciones.viewmodel.BaseViewModel;

@WebServlet(name = "UpdateToDataBaseServlet", urlPatterns = {"/UpdateToDataBaseServlet"})
public class UpdateToDataBaseServlet extends BaseServlet {
    BaseViewModel vm = new BaseViewModel("Update");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String clave = request.getParameter("clave");
        String materia = request.getParameter("materia");
        String profesor = request.getParameter("profesor");
        String horario = request.getParameter("horario");
        ServletContext  context = getServletContext();
        request.setAttribute(clave, this);
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected BaseViewModel getViewModel() {
        return vm;
    }
}
