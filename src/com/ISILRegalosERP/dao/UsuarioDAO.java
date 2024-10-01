package com.ISILRegalosERP.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ISILRegalosERP.model.Usuario;

public class UsuarioDAO {
	
	private String url; /*Cadena de conexion*/
	private Connection conexion; /*Objeto que me permitir? la conexi?n con la BD*/
	
	public UsuarioDAO() {
		/*Definir todo lo necesario para la conexi?n a BD*/
		/*1. Definir la cadena de conexi?n*/
		this.url = "jdbc:sqlserver://localhost:1433;databaseName=IsilERPDae1;user=sa;password=sa";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			this.conexion = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean validarUsuario(String correo, String password) throws SQLException {
		boolean existe = false;
		String sentenciaSQL = "select * from Usuario where correo='" + correo + "' and password='" + password +"' and estado='Activo'";
		Statement stmt = this.conexion.createStatement();
		ResultSet rs = stmt.executeQuery(sentenciaSQL);
		while (rs.next()) {
			existe = true;
		}
		return existe;
	}
	
	public boolean validarCorreo(String correo) throws SQLException {
		boolean existe = false;
		String sentenciaSQL = "select * from Usuario where correo='" + correo + "'";
		Statement stmt = this.conexion.createStatement();
		ResultSet rs = stmt.executeQuery(sentenciaSQL);
		while (rs.next()) {
			existe = true;
		}
		if (existe) {
			this.conexion.close();			
		}
		return existe;
	}
	
	public List<Usuario> buscarUsuarioxCorreo(String correo) throws SQLException{
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		String sentenciaSQL = "select * from Usuario where correo like '%" + correo + "%'";
		Statement stmt = this.conexion.createStatement();
		ResultSet rs = stmt.executeQuery(sentenciaSQL);
		while (rs.next()) { //Este while me permite ir registro por registro en el resultado que obtuve de BD
			int id = rs.getInt(1);
			String correoBD = rs.getString(2);
			String password = rs.getString(3);
			String estado = rs.getString(4);
			String nombre = rs.getString(5);
			String apellidoPaterno = rs.getString(6);
			
			Usuario objUsuario = new Usuario();
			objUsuario.setId(id);
			objUsuario.setCorreo(correoBD);
			objUsuario.setPassword(password);
			objUsuario.setEstado(estado);
			objUsuario.setNombre(nombre);
			objUsuario.setApellidoPaterno(apellidoPaterno);
			listaUsuarios.add(objUsuario);
		}
		this.conexion.close();
		return listaUsuarios;
	}
	
	public Usuario buscarUsuarioxId(int id) throws SQLException{
		Usuario objUsuario=null;
		String sentenciaSQL = "select * from Usuario where id = ?";
		PreparedStatement stmt = this.conexion.prepareStatement(sentenciaSQL);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) { //Este while me permite ir registro por registro en el resultado que obtuve de BD
			String correoBD = rs.getString(2);
			String password = rs.getString(3);
			String estado = rs.getString(4);
			String nombre = rs.getString(5);
			String apellidoPaterno = rs.getString(6);
			
			objUsuario = new Usuario();
			objUsuario.setId(id);
			objUsuario.setCorreo(correoBD);
			objUsuario.setPassword(password);
			objUsuario.setEstado(estado);
			objUsuario.setNombre(nombre);
			objUsuario.setApellidoPaterno(apellidoPaterno);
		}
		this.conexion.close();
		return objUsuario;
	}
	
	public void registrar(String correo, String password, String estado, String nombre, String apellidoPaterno) throws SQLException {
		String sentenciaSQL = "insert into Usuario(correo,password,estado,nombre,apellidoPaterno) values (?,?,?,?,?);";
		PreparedStatement stmt = this.conexion.prepareStatement(sentenciaSQL);
		stmt.setString(1, correo);
		stmt.setString(2, password);
		stmt.setString(3, estado);
		stmt.setString(4, nombre);
		stmt.setString(5, apellidoPaterno);
		stmt.execute();
		this.conexion.close();
	}
	
	public void eliminar(int id) throws SQLException {
		String sentenciaSQL = "delete Usuario where id= ?";
		PreparedStatement stmt = this.conexion.prepareStatement(sentenciaSQL);
		stmt.setInt(1, id);
		stmt.execute();
		this.conexion.close();
	}
}
