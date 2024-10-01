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

import com.ISILRegalosERP.dao.UsuarioDAO;
import com.ISILRegalosERP.model.Usuario;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/usuario")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcionGet");
		switch (opcion) {
			case "buscarUsuario": {
				try {
					buscarUsuario(request,response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case "eliminar": {
				try {
					eliminar(request,response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case "editar": {
				try {
					editar(request,response);
				} catch (ServletException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.eliminar(id);
		request.setAttribute("mensaje", "El usuario ha sido eliminado con ?xito");
		String paginaDestino = "/gestionUsuario.jsp";
		/*De esta forma redirijo mi sistema a una p?gina en particular*/
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		dispatcher.forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarUsuarioxId(id);
		request.setAttribute("usuario", usuario);
		String paginaDestino = "/editarUsuario.jsp";
		/*De esta forma redirijo mi sistema a una p?gina en particular*/
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		dispatcher.forward(request, response);
	}
	
	private void buscarUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String correo = request.getParameter("correo");
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> listaUsuario = usuarioDAO.buscarUsuarioxCorreo(correo);
		request.setAttribute("listaUsuario", listaUsuario);
		String paginaDestino = "/gestionUsuario.jsp";
		/*De esta forma redirijo mi sistema a una p?gina en particular*/
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcionPost");
		switch (opcion) {
			case "nuevoUsuario":{
				nuevoUsuario(request,response);
				break;
			}
			case "registrar" : {
				try {
					registrar(request,response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}

	private void registrar(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
		String paginaDestino;
		String mensaje;
		String correo = request.getParameter("correo");
		String password = request.getParameter("password");
		String nombre = request.getParameter("nombre");
		String apellidoPaterno = request.getParameter("apellidoPaterno");
		String estado = "Activo";
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		boolean existe = usuarioDAO.validarCorreo(correo);
		if (existe) {
			paginaDestino = "/nuevoUsuario.jsp";
			mensaje = "El correo ya se encuentra registrado";
		}
		else {
			usuarioDAO.registrar(correo, password, estado, nombre, apellidoPaterno);
			paginaDestino = "/gestionUsuario.jsp";
			mensaje = "El usuario ha sido creado con ?xito";
		}
		request.setAttribute("mensaje", mensaje);
		/*De esta forma redirijo mi sistema a una p?gina en particular*/
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		dispatcher.forward(request, response);
	}
	
	private void nuevoUsuario(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String paginaDestino = "/nuevoUsuario.jsp";
		/*De esta forma redirijo mi sistema a una p?gina en particular*/
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		dispatcher.forward(request, response);
	}
	
}
