package com.ejemplo.dto_mapstruct.controller;

import com.ejemplo.dto_mapstruct.dto.ProductoDTO;
import com.ejemplo.dto_mapstruct.entity.Producto;
import com.ejemplo.dto_mapstruct.mapper.ProductoMapper;
import com.ejemplo.dto_mapstruct.repository.ProductoRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

 private final ProductoRepository repository;
 private final ProductoMapper mapper;

 // Constructor
 public ProductoController(
         ProductoRepository repository,
         ProductoMapper mapper) {

  this.repository = repository;
  this.mapper = mapper;
 }

 // GET → Obtener todos los productos
 @GetMapping
 public List<ProductoDTO> listar() {
  return repository.findAll()
          .stream()
          .map(mapper::toDTO)
          .toList();
 }

 // GET → Obtener producto por id
 @GetMapping("/{id}")
 public ProductoDTO obtener(@PathVariable Long id) {
  return repository.findById(id)
          .map(mapper::toDTO)
          .orElse(null);
 }

 // POST → Crear un producto
 @PostMapping
 public ProductoDTO crear(@RequestBody ProductoDTO dto) {
  Producto producto = mapper.toEntity(dto);
  return mapper.toDTO(repository.save(producto));
 }

 // PUT → Actualizar un producto
 @PutMapping("/{id}")
 public ProductoDTO actualizar(@PathVariable Long id, @RequestBody ProductoDTO dto) {
  Optional<Producto> optional = repository.findById(id);
  if (optional.isEmpty()) return null;
  Producto producto = optional.get();
  producto.setNombre(dto.getNombre());
  producto.setPrecio(dto.getPrecio());
  producto.setDescripcion(dto.getDescripcion());
  producto.setStock(dto.getStock());
  return mapper.toDTO(repository.save(producto));
 }

 // DELETE → Eliminar un producto
 @DeleteMapping("/{id}")
 public void eliminar(@PathVariable Long id) {
  repository.deleteById(id);
 }
}