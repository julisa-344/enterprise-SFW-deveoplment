package com.ISILRegalosERP.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ISILRegalosERP.model.JefeTienda;

public class JefeTiendaDAO {

    private String url = "jdbc:sqlserver://172.17.0.1:1433;databaseName=EP2DAE;user=SA;password=Fabuloso344";

        private Connection conexion;

    public JefeTiendaDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.conexion = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }    
    }

        public List<JefeTienda> buscarJefeTienda(String nombre) throws SQLException {
        List<JefeTienda> listaJefeTienda = new ArrayList<>();
        String sentenciaSQL;
        if (nombre == null || nombre.isEmpty()) {
            sentenciaSQL = "SELECT * FROM JefeTienda";
        } else {
            sentenciaSQL = "SELECT * FROM JefeTienda WHERE nombre LIKE ?";
        }
        PreparedStatement stmt = this.conexion.prepareStatement(sentenciaSQL);
        if (nombre != null && !nombre.isEmpty()) {
            stmt.setString(1, "%" + nombre + "%");
        }

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            JefeTienda JefeTienda = new JefeTienda();
            JefeTienda.setCodigo(rs.getInt("codigo"));
            JefeTienda.setNombre(rs.getString("nombre"));
            JefeTienda.setApellidoPaterno(rs.getString("apellidoPaterno"));
            JefeTienda.setApellidoMaterno(rs.getString("apellidoMaterno"));
            JefeTienda.setDni(rs.getString("dni"));

            listaJefeTienda.add(JefeTienda);
        }
        this.conexion.close();
        return listaJefeTienda;
    }

        public JefeTienda buscarJefeTiendas(int codigo) throws SQLException {
            JefeTienda JefeTienda = new JefeTienda();
        String sentenciaSQL = "SELECT * FROM JefeTienda WHERE codigo = ?";
        PreparedStatement stmt = this.conexion.prepareStatement(sentenciaSQL);
        stmt.setInt(1, codigo);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            JefeTienda.setCodigo(rs.getInt("codigo"));
            JefeTienda.setNombre(rs.getString("nombre"));
            JefeTienda.setApellidoPaterno(rs.getString("apellidoPaterno"));
            JefeTienda.setApellidoMaterno(rs.getString("apellidoMaterno"));
            JefeTienda.setDni(rs.getString("dni"));
        }
        this.conexion.close();
        return JefeTienda;
    }

    public void registrarJefeTienda(JefeTienda JefeTienda) throws SQLException {
        String sentenciaSQL = "INSERT INTO JefeTienda (nombre, apellidoPaterno, apellidoMaterno, dni) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = this.conexion.prepareStatement(sentenciaSQL);
        stmt.setString(1, JefeTienda.getNombre());
        stmt.setString(2, JefeTienda.getApellidoPaterno());
        stmt.setString(3, JefeTienda.getApellidoMaterno());
        stmt.setString(4, JefeTienda.getDni());
        stmt.executeUpdate();
        this.conexion.close();
    }

    public void actualizarJefeTienda(JefeTienda JefeTienda) throws SQLException {
        String sentenciaSQL = "UPDATE JefeTienda SET nombre = ?, apellidoPaterno = ?, apellidoMaterno = ?, dni = ? WHERE codigo = ?";
        PreparedStatement stmt = this.conexion.prepareStatement(sentenciaSQL);
        stmt.setString(1, JefeTienda.getNombre());
        stmt.setString(2, JefeTienda.getApellidoPaterno());
        stmt.setString(3, JefeTienda.getApellidoMaterno());
        stmt.setString(4, JefeTienda.getDni());
        stmt.setInt(5, JefeTienda.getCodigo());
        stmt.executeUpdate();
        this.conexion.close();
    }

    public void eliminarJefeTienda(int codigo) throws SQLException {
        String sentenciaSQL = "DELETE FROM JefeTienda WHERE codigo = ?";
        PreparedStatement stmt = this.conexion.prepareStatement(sentenciaSQL);
        stmt.setInt(1, codigo);
        stmt.executeUpdate();
        this.conexion.close();
    }
}
