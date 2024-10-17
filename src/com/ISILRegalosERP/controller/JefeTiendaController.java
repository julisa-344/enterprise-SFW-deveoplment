package com.ISILRegalosERP.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ISILRegalosERP.dao.JefeTiendaDAO;
import com.ISILRegalosERP.model.JefeTienda;

@WebServlet("/jefeTienda")

public class JefeTiendaController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "buscar":
                    buscarJefeTienda(request, response);
                    break;
                case "nuevo":
                    mostrarFormularioNuevo(request, response);
                    break;
                case "eliminar":
                    eliminarJefeTienda(request, response);
                    break;
                case "editar":
                    mostrarFormularioEditar(request, response);
                    break;
                default:
                    listarJefeTienda(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void buscarJefeTienda(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String apellidoPaterno = request.getParameter("apellidoPaterno");
        String apellidoMaterno = request.getParameter("apellidoMaterno");
        JefeTiendaDAO jefeTiendaDAO = new JefeTiendaDAO();
        List<JefeTienda> listaJefeTienda = jefeTiendaDAO.buscarJefeTienda(apellidoPaterno, apellidoMaterno);
        request.setAttribute("listaJefeTienda", listaJefeTienda);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/gestionJefeTienda.jsp");
        dispatcher.forward(request, response);
    }

    private void mostrarFormularioNuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/nuevoJefeTienda.jsp");
        dispatcher.forward(request, response);
    }

    private void eliminarJefeTienda(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        JefeTiendaDAO jefeTiendaDAO = new JefeTiendaDAO();
        jefeTiendaDAO.eliminarJefeTienda(codigo);
        response.sendRedirect("jefeTienda");
    }

    private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        JefeTiendaDAO jefeTiendaDAO = new JefeTiendaDAO();
        JefeTienda jefeTienda = jefeTiendaDAO.buscarJefeTiendas(codigo);
        request.setAttribute("jefeTienda", jefeTienda);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/editarJefeTienda.jsp");
        dispatcher.forward(request, response);
    }

    private void listarJefeTienda(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        JefeTiendaDAO jefeTiendaDAO = new JefeTiendaDAO();
        List<JefeTienda> listaJefeTienda = jefeTiendaDAO.buscarJefeTienda(null);
        request.setAttribute("listaJefeTienda", listaJefeTienda);
        System.out.println(listaJefeTienda + "perro");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/gestionJefeTienda.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "registrar":
                    registrarJefeTienda(request, response);
                    break;
                case "actualizar":
                    actualizarJefeTienda(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void registrarJefeTienda(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String nombre = request.getParameter("nombre");
        String apellidoPaterno = request.getParameter("apellidoPaterno");
        String apellidoMaterno = request.getParameter("apellidoMaterno");
        String dni = request.getParameter("dni");

        JefeTienda jefeTienda = new JefeTienda();
        jefeTienda.setNombre(nombre);
        jefeTienda.setApellidoPaterno(apellidoPaterno);
        jefeTienda.setApellidoMaterno(apellidoMaterno);
        jefeTienda.setDni(dni);

        JefeTiendaDAO jefeTiendaDAO = new JefeTiendaDAO();
        jefeTiendaDAO.registrarJefeTienda(jefeTienda);
        response.sendRedirect("jefeTienda");
    }

    private void actualizarJefeTienda(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String nombre = request.getParameter("nombre");
        String apellidoPaterno = request.getParameter("apellidoPaterno");
        String apellidoMaterno = request.getParameter("apellidoMaterno");
        String dni = request.getParameter("dni");

        JefeTienda jefeTienda = new JefeTienda();
        jefeTienda.setCodigo(codigo);
        jefeTienda.setNombre(nombre);
        jefeTienda.setApellidoPaterno(apellidoPaterno);
        jefeTienda.setApellidoMaterno(apellidoMaterno);
        jefeTienda.setDni(dni);

        JefeTiendaDAO jefeTiendaDAO = new JefeTiendaDAO();
        jefeTiendaDAO.actualizarJefeTienda(jefeTienda);
        response.sendRedirect("jefeTienda");
    }
}

