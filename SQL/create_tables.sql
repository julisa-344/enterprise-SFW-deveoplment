-- SQL script to create necessary tables for the application

-- Table for Users
CREATE TABLE Usuario (
    id INT PRIMARY KEY IDENTITY(1,1),
    correo VARCHAR(50) NULL,
    password VARCHAR(50) NULL,
    estado VARCHAR(50) NULL,
    nombre VARCHAR(50) NULL,
    apellidoPaterno VARCHAR(50) NULL
);

-- Table for Products
CREATE TABLE Producto (
    id INT PRIMARY KEY IDENTITY(1,1),
    nombre VARCHAR(100) NOT NULL,
    stock INT NOT NULL,
    estado VARCHAR(50) NOT NULL,
    categoria VARCHAR(50) NOT NULL
);