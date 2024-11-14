package com.example.julisaleonspringep3.controller;

import com.example.julisaleonspringep3.model.Product;
import com.example.julisaleonspringep3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/gestionarProductos")
    public String gestionarProductos(Model model) {
        model.addAttribute("productos", productService.findAll());
        return "gestionarProductos";
    }

    @GetMapping("/buscarProducto")
    public String buscarProducto(@RequestParam("categoria") String categoria, Model model) {
        List<Product> productos = productService.findByCategoria(categoria);
        model.addAttribute("productos", productos);
        return "gestionarProductos";
    }
}