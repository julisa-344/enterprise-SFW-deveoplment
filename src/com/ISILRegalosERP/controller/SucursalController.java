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
import com.ISILRegalosERP.dao.SucursalDAO;
import com.ISILRegalosERP.model.Sucursal;

@WebServlet("/sucursal")
public class SucursalController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "buscar":
                    buscarSucursales(request, response);
                    break;
                case "nuevo":
                    mostrarFormularioNuevo(request, response);
                    break;
                case "eliminar":
                    eliminarSucursal(request, response);
                    break;
                default:
                    listarSucursales(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void buscarSucursales(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String nombre = request.getParameter("nombre");
        SucursalDAO sucursalDAO = new SucursalDAO();
        List<Sucursal> listaSucursales = sucursalDAO.buscarSucursales(nombre);
        request.setAttribute("listaSucursales", listaSucursales);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/gestionSucursales.jsp");
        dispatcher.forward(request, response);
    }

    private void mostrarFormularioNuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/nuevaSucursal.jsp");
        dispatcher.forward(request, response);
    }

    private void eliminarSucursal(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        SucursalDAO sucursalDAO = new SucursalDAO();
        sucursalDAO.eliminarSucursal(codigo);
        response.sendRedirect("sucursal?action=listar");
    }

    private void listarSucursales(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        SucursalDAO sucursalDAO = new SucursalDAO();
        List<Sucursal> listaSucursales = sucursalDAO.buscarSucursales("");
        request.setAttribute("listaSucursales", listaSucursales);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/gestionSucursales.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            registrarSucursal(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void registrarSucursal(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        int estado = Integer.parseInt(request.getParameter("estado"));
        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(nombre);
        sucursal.setDireccion(direccion);
        sucursal.setEstado(estado);
        SucursalDAO sucursalDAO = new SucursalDAO();
        sucursalDAO.registrarSucursal(sucursal);
        response.sendRedirect("sucursal?action=listar");
    }
}