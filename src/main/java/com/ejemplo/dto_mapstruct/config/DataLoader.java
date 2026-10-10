package com.ejemplo.dto_mapstruct.config;

import com.ejemplo.dto_mapstruct.entity.Producto;
import com.ejemplo.dto_mapstruct.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initData(ProductoRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(crearProducto("Laptop", 999.99, "Laptop de alto rendimiento", 10));
                repository.save(crearProducto("Mouse", 29.99, "Mouse inalámbrico", 50));
                repository.save(crearProducto("Teclado", 49.99, "Teclado mecánico", 30));
            }
        };
    }

    private Producto crearProducto(String nombre, Double precio, String descripcion, Integer stock) {
        Producto p = new Producto();
        p.setNombre(nombre);
        p.setPrecio(precio);
        p.setDescripcion(descripcion);
        p.setStock(stock);
        return p;
    }
}
