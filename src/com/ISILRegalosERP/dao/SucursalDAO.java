package com.ISILRegalosERP.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.ISILRegalosERP.model.Sucursal;

public class SucursalDAO {
    private String url = "jdbc:sqlserver://172.17.0.1:1433;databaseName=EP1DAE;user=SA;password=Fabuloso344";

    private Connection conexion;

    public SucursalDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.conexion = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Sucursal> buscarSucursales(String nombre) throws SQLException {
        List<Sucursal> listaSucursales = new ArrayList<>();
        String sentenciaSQL;
        if (nombre == null || nombre.isEmpty()) {
            sentenciaSQL = "SELECT * FROM Sucursal";
        } else {
            sentenciaSQL = "SELECT * FROM Sucursal WHERE nombre LIKE ?";
        }
        PreparedStatement stmt = this.conexion.prepareStatement(sentenciaSQL);
        if (nombre != null && !nombre.isEmpty()) {
            stmt.setString(1, "%" + nombre + "%");
        }

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Sucursal sucursal = new Sucursal();
            sucursal.setCodigo(rs.getInt("codigo"));
            sucursal.setNombre(rs.getString("nombre"));
            sucursal.setDireccion(rs.getString("direccion"));
            sucursal.setEstado(rs.getInt("estado"));
            listaSucursales.add(sucursal);
        }
        this.conexion.close();
        return listaSucursales;
    }

    // new method: buscarSucursal(Codigo)
    public Sucursal buscarSucursal(int codigo) throws SQLException {
        Sucursal sucursal = new Sucursal();
        String sentenciaSQL = "SELECT * FROM Sucursal WHERE codigo = ?";
        PreparedStatement stmt = this.conexion.prepareStatement(sentenciaSQL);
        stmt.setInt(1, codigo);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            sucursal.setCodigo(rs.getInt("codigo"));
            sucursal.setNombre(rs.getString("nombre"));
            sucursal.setDireccion(rs.getString("direccion"));
            sucursal.setEstado(rs.getInt("estado"));
        }
        this.conexion.close();
        return sucursal;
    }


    public void registrarSucursal(Sucursal sucursal) throws SQLException {
        String sentenciaSQL = "INSERT INTO Sucursal(nombre, direccion, estado) VALUES (?, ?, ?)";
        PreparedStatement stmt = this.conexion.prepareStatement(sentenciaSQL);
        stmt.setString(1, sucursal.getNombre());
        stmt.setString(2, sucursal.getDireccion());
        stmt.setInt(3, sucursal.getEstado());
        stmt.execute();
        this.conexion.close();
    }

    public void actualizarSucursal(Sucursal sucursal) throws SQLException {
        String sentenciaSQL = "UPDATE Sucursal SET nombre = ?, direccion = ?, estado = ? WHERE codigo = ?";
        PreparedStatement stmt = this.conexion.prepareStatement(sentenciaSQL);
        stmt.setString(1, sucursal.getNombre());
        stmt.setString(2, sucursal.getDireccion());
        stmt.setInt(3, sucursal.getEstado());
        stmt.setInt(4, sucursal.getCodigo());
        stmt.execute();
        this.conexion.close();
    }

    public void eliminarSucursal(int codigo) throws SQLException {
        String sentenciaSQL = "DELETE FROM Sucursal WHERE codigo = ?";
        PreparedStatement stmt = this.conexion.prepareStatement(sentenciaSQL);
        stmt.setInt(1, codigo);
        stmt.execute();
        this.conexion.close();
    }
}