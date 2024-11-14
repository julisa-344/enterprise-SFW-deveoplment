# Caso de uso

La empresa ISIL SOFT S.A.C se encuentra desarrollando un proyecto web utilizando como lenguaje de programación JAVA y una base de datos SQL SERVER para una empresa familiar que está abriendo su negocio de compra y venta de artículos de oficina y útiles escolares.

A continuación, se presenta un extracto de las necesidades presentadas por el cliente:

> “Somos una familia que se encuentra evaluando la opción de abrir una empresa relacionada al negocio de la compra y venta de artículos de oficina y útiles escolares”. Para ello la familia se encuentra realizando un estudio del mercado para ver si la empresa tendría un buen futuro. Adicional al estudio del mercado, propusieron algunas ideas sobre los procesos de negocio que manejarían y uno de ellos ha precisado lo siguiente:
> - La empresa necesita manejar la información de los productos que ofrece, por ello es muy importante contar con una funcionalidad que permita buscar los productos que ofrece la empresa que están registrados.

Producto de esta solicitud, el analista funcional y el arquitecto de software plantearon implementar el proyecto utilizando una aplicación web JAVA, bajo el modelo MVC (Model, View, Controller), con una base de datos SQL Server, utilizando el patrón JPA para acceso de datos, el framework Spring y el framework Thymleaf para el manejo del front (html).

## Funcionalidades

### Gestión de Productos

#### Diseño

**Caso de Uso: Gestionar Productos**

- Login Screen --> Principal.html (blank page with a link to `Gestionar productos`)
- GestionarProductos.html (Table with the attributes of the productos table, input field to enter "Categoria", `buscar` button and `Nuevo` button)

#### Arquitectura

- Debe utilizar html.
- Debe utilizar Controller.
- Debe utilizar JPA Repository.
- Debe utilizar Entity.

## Base de Datos

### Tabla Usuario

| Campo           | Tipo          | Permite Nulos |
|-----------------|---------------|---------------|
| id              | int           | No            |
| correo          | varchar(50)   | Sí            |
| password        | varchar(50)   | Sí            |
| estado          | varchar(50)   | Sí            |
| nombre          | varchar(50)   | Sí            |
| apellidoPaterno | varchar(50)   | Sí            |

### Tabla Producto

| Campo    | Tipo         | Permite Nulos |
|----------|--------------|---------------|
| id       | int          | No            |
| nombre   | varchar(100) | No            |
| stock    | int          | No            |
| estado   | varchar(50)  | No            |
| categoria| varchar(50)  | No            |

## Requisitos del Proyecto

Siguiendo el diseño y arquitectura presentado, se le pide que implemente un proyecto WEB en JAVA utilizando una base de datos SQL SERVER, SPRING, JPA y THYMELEAF que permita desarrollar la funcionalidad de Gestionar Producto, iniciando desde el index y en la pantalla Gestionar Producto solo realizar la búsqueda de Productos.