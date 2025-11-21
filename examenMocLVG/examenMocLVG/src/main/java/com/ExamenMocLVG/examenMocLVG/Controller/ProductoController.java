package com.ExamenMocLVG.examenMocLVG.Controller;

import com.ExamenMocLVG.examenMocLVG.Entity.Producto;
import com.ExamenMocLVG.examenMocLVG.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping(value = "/productos")
    public Producto addProducto(@RequestBody Producto producto) {
        return this.productoService.addProducto(producto);
    }

    @DeleteMapping(value = "/producto/{productoId}")
    public void deleteProducto(@PathVariable Long productoId) {
        productoService.eliminarProductoById(productoId);
    }

    @PutMapping(value = "/producto/{productoId}")
    public Producto modificarProducto(@PathVariable Long productoId, @RequestBody Producto producto) {
        return this.productoService.modificarProducto(productoId,producto);
    }

    @GetMapping(value = "/productos")
    public List<Producto> getProductos(@RequestParam(defaultValue = "0.0") Float precio,
                                       @RequestParam(defaultValue = "") String categoria) {
        /*
            - Si no se indica ni precio ni categoría -> obtener todos los productos.
            - Si se indica el precio -> obtener los productos con ese precio.
            - Si se indica la categoria -> obtener los productos con esa categoria.
         */
        List<Producto> listaProductos = new ArrayList<>();
        if (precio!=0.0){
            listaProductos = this.productoService.findByPrecio(precio);
        }else if (categoria!=""){
            listaProductos = this.productoService.findByCategoria(categoria);
        }else {
            listaProductos = this.productoService.findAllProductos();

        }
        return listaProductos;
    }

    @GetMapping(value = "/producto/{productoId}")
    public Optional<Producto> getProducto(@PathVariable Long productoId) {

        return this.productoService.findProducto(productoId);
    }

}