package com.emergentes.controller;

import com.emergentes.bean.BeanEstudiante;
import com.emergentes.entidades.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "listar";
        }

        switch (action) {
            case "nuevo":
                request.setAttribute("estudiante", new Estudiante());
                request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                break;
            case "editar":
                Integer id = Integer.parseInt(request.getParameter("id"));
                BeanEstudiante dao = new BeanEstudiante();
                Estudiante estudiante = dao.buscar(id);
                request.setAttribute("estudiante", estudiante);
                request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
                break;
            case "listar":
            default:
                mostrar(request, response);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("email");
        String fechaNacimientoStr = request.getParameter("fechaNacimiento");

        Estudiante estudiante = new Estudiante();
        estudiante.setId(id);
        estudiante.setNombre(nombre);
        estudiante.setApellidos(apellidos);
        estudiante.setEmail(email);
        estudiante.setFechaNacimiento(convierteFecha(fechaNacimientoStr));

        BeanEstudiante dao = new BeanEstudiante();
        if (id == 0) {
            dao.insertar(estudiante);
        } else {
            dao.editar(estudiante);
        }

        response.sendRedirect("MainController");
    }
    
    public java.sql.Date convierteFecha(String fecha) {
        java.sql.Date fechaBD = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date fechaTMP = formato.parse(fecha);
            fechaBD = new java.sql.Date(fechaTMP.getTime());
        } catch (ParseException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return fechaBD;
    }

    private void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BeanEstudiante dao = new BeanEstudiante();
        List<Estudiante> lista = dao.listarTodos();
        
        request.setAttribute("estudiantes", lista);
        request.getRequestDispatcher("estudiantes.jsp").forward(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        BeanEstudiante dao = new BeanEstudiante();
        dao.eliminar(id);
        response.sendRedirect("MainController");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
