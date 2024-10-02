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
        String sentenciaSQL = "SELECT * FROM Sucursal WHERE nombre LIKE ?";
        PreparedStatement stmt = this.conexion.prepareStatement(sentenciaSQL);
        stmt.setString(1, "%" + nombre + "%");
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

    public void registrarSucursal(Sucursal sucursal) throws SQLException {
        String sentenciaSQL = "INSERT INTO Sucursal(nombre, direccion, estado) VALUES (?, ?, ?)";
        PreparedStatement stmt = this.conexion.prepareStatement(sentenciaSQL);
        stmt.setString(1, sucursal.getNombre());
        stmt.setString(2, sucursal.getDireccion());
        stmt.setInt(3, sucursal.getEstado());
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