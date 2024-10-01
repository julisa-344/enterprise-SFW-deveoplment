package com.ISILRegalosERP.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ISILRegalosERP.dao.UsuarioDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion =  request.getParameter("opcionPost");
		switch (opcion) {
			case "validarUsuario" : {
				try {
					validarUsuario(request,response);
				} catch (ServletException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}

	private void validarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String correo = request.getParameter("correo");
		String password = request.getParameter("password");
		String paginaDestino;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		boolean existe = usuarioDAO.validarUsuario(correo, password);
		if (existe) {
			paginaDestino = "/principal.jsp";
		}
		else {
			paginaDestino = "/index.jsp";
		}
		/*De esta forma redirijo mi sistema a una pagina en particular*/
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		dispatcher.forward(request, response);
	}
}
