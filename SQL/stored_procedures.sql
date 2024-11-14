-- SQL script to create stored procedures for managing products

-- Stored Procedure to add a new product
CREATE PROCEDURE AddProduct
    @nombre VARCHAR(100),
    @stock INT,
    @estado VARCHAR(50),
    @categoria VARCHAR(50)
AS
BEGIN
    INSERT INTO Producto (nombre, stock, estado, categoria)
    VALUES (@nombre, @stock, @estado, @categoria);
END
GO

-- Stored Procedure to update an existing product
CREATE PROCEDURE UpdateProduct
    @id INT,
    @nombre VARCHAR(100),
    @stock INT,
    @estado VARCHAR(50),
    @categoria VARCHAR(50)
AS
BEGIN
    UPDATE Producto
    SET nombre = @nombre,
        stock = @stock,
        estado = @estado,
        categoria = @categoria
    WHERE id = @id;
END
GO

-- Stored Procedure to delete a product
CREATE PROCEDURE DeleteProduct
    @id INT
AS
BEGIN
    DELETE FROM Producto
    WHERE id = @id;
END
GO

-- Stored Procedure to search for products by category
CREATE PROCEDURE SearchProductsByCategory
    @categoria VARCHAR(50)
AS
BEGIN
    SELECT * FROM Producto
    WHERE categoria = @categoria;
END
GO

-- Stored Procedure to get all products
CREATE PROCEDURE GetAllProducts
AS
BEGIN
    SELECT * FROM Producto;
END
GO