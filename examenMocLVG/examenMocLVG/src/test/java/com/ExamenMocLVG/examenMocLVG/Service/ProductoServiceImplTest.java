package com.ExamenMocLVG.examenMocLVG.Service;

import com.ExamenMocLVG.examenMocLVG.Entity.Producto;
import com.ExamenMocLVG.examenMocLVG.Repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductoServiceImplTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    @Test
    void findAllProductos() {

        // 1. ARRANGE (Preparar los datos de prueba)
        // Creamos unos productos "falsos"
        Producto p1 = new Producto();
        p1.setNombre("Ordenador"); // Ajusta esto según tu clase Producto

        Producto p2 = new Producto();
        p2.setNombre("Ratón");

        List<Producto> listaSimulada = Arrays.asList(p1, p2);

        // Le decimos al Mock: "Cuando alguien llame a findAll(), devuelve esta lista que acabo de inventar"
        when(productoRepository.findAll()).thenReturn(listaSimulada);

        // 2. ACT (Ejecutar el método que queremos probar)
        List<Producto> resultado = productoService.findAllProductos();

        // 3. ASSERT (Verificar que el resultado es el esperado)
        assertNotNull(resultado); // Que no sea null
        assertEquals(2, resultado.size()); // Que tenga exactamente 2 elementos
        assertEquals("Ordenador", resultado.get(0).getNombre()); // Que el primero sea el correcto
    }
}