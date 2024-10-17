package com.ISILRegalosERP.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ISILRegalosERP.model.JefeTienda;

public class JefeTiendaDAO {

    private String url = "jdbc:sqlserver://172.17.0.1:1433;databaseName=EP2DAE;user=SA;password=Fabuloso344";
    private Connection conexion;

    public JefeTiendaDAO() {
        System.out.println("JefeTiendaDAO");
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.conexion = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.err.println("Error en la conexión a la base de datos");
        }    
    }

    public List<JefeTienda> buscarJefeTienda(String apellidoPaterno, String apellidoMaterno) throws SQLException {
        List<JefeTienda> listaJefeTienda = new ArrayList<>();
        String procedimiento = "{CALL BuscarJefeTiendaPorApellidos(?,?)}";
        CallableStatement stmt = this.conexion.prepareCall(procedimiento);
        stmt.setString(1, apellidoPaterno);
        stmt.setString(2, apellidoMaterno);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.println(rs.toString() + "perro 2");
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


    public List<JefeTienda> buscarJefeTienda(String nombre) throws SQLException {
        List<JefeTienda> listaJefeTienda = new ArrayList<>();
        String procedimiento = "{CALL BuscarJefeTiendaPorNombre(?)}";
        CallableStatement stmt = this.conexion.prepareCall(procedimiento);
        stmt.setString(1, nombre);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.println(rs.toString() + "perro 2");
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
        String procedimiento = "{CALL BuscarJefeTiendaPorCodigo(?)}";
        CallableStatement stmt = this.conexion.prepareCall(procedimiento);
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
        String procedimiento = "{CALL RegistrarJefeTienda(?, ?, ?, ?)}";
        CallableStatement stmt = this.conexion.prepareCall(procedimiento);
        stmt.setString(1, JefeTienda.getNombre());
        stmt.setString(2, JefeTienda.getApellidoPaterno());
        stmt.setString(3, JefeTienda.getApellidoMaterno());
        stmt.setString(4, JefeTienda.getDni());
        stmt.executeUpdate();
        this.conexion.close();
    }

    public void actualizarJefeTienda(JefeTienda JefeTienda) throws SQLException {
        String procedimiento = "{CALL ActualizarJefeTienda(?, ?, ?, ?, ?)}";
        CallableStatement stmt = this.conexion.prepareCall(procedimiento);
        stmt.setInt(1, JefeTienda.getCodigo());
        stmt.setString(2, JefeTienda.getNombre());
        stmt.setString(3, JefeTienda.getApellidoPaterno());
        stmt.setString(4, JefeTienda.getApellidoMaterno());
        stmt.setString(5, JefeTienda.getDni());
        stmt.executeUpdate();
        this.conexion.close();
    }

    public void eliminarJefeTienda(int codigo) throws SQLException {
        String procedimiento = "{CALL EliminarJefeTienda(?)}";
        CallableStatement stmt = this.conexion.prepareCall(procedimiento);
        stmt.setInt(1, codigo);
        stmt.executeUpdate();
        this.conexion.close();
    }
}