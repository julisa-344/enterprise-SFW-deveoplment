package com.ISILRegalosERP.model;

/**
 * The JefeTienda class represents a store manager with attributes such as 
 * codigo, nombre, apellidoPaterno, apellidoMaterno, and dni.
 * 
 * <p>This class provides getter and setter methods for each attribute, 
 * allowing for encapsulation and data manipulation. Additionally, it 
 * overrides the toString method to provide a string representation of 
 * the JefeTienda object.</p>
 * 
 * <p>Attributes:</p>
 * <ul>
 *   <li>codigo: An integer representing the unique code of the store manager.</li>
 *   <li>nombre: A string representing the first name of the store manager.</li>
 *   <li>apellidoPaterno: A string representing the paternal surname of the store manager.</li>
 *   <li>apellidoMaterno: A string representing the maternal surname of the store manager.</li>
 *   <li>dni: A string representing the national identification number of the store manager.</li>
 * </ul>
 * 
 * <p>Methods:</p>
 * <ul>
 *   <li>getCodigo: Returns the codigo of the store manager.</li>
 *   <li>setCodigo: Sets the codigo of the store manager.</li>
 *   <li>getNombre: Returns the nombre of the store manager.</li>
 *   <li>setNombre: Sets the nombre of the store manager.</li>
 *   <li>getApellidoPaterno: Returns the apellidoPaterno of the store manager.</li>
 *   <li>setApellidoPaterno: Sets the apellidoPaterno of the store manager.</li>
 *   <li>getApellidoMaterno: Returns the apellidoMaterno of the store manager.</li>
 *   <li>setApellidoMaterno: Sets the apellidoMaterno of the store manager.</li>
 *   <li>getDni: Returns the dni of the store manager.</li>
 *   <li>setDni: Sets the dni of the store manager.</li>
 *   <li>toString: Returns a string representation of the JefeTienda object.</li>
 * </ul>
 */
public class JefeTienda {
    private int codigo;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String dni;

    // Getters y Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "jefeTiendaDAO{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
