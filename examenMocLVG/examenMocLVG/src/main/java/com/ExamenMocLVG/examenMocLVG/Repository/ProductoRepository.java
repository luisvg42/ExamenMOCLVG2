package com.ExamenMocLVG.examenMocLVG.Repository;

import com.ExamenMocLVG.examenMocLVG.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByPrecio(float precio);
    List<Producto> findByCategoria(String categoria);

    List<Producto> findByPrecioAndCategoria(float precio, String categoria);
}
