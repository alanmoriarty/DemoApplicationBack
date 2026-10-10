package com.ejemplo.dto_mapstruct.dto;

public class ProductoDTO {

 private Long id;
 private String nombre;
 private double precio;
 private String descripcion;
 private int stock;

 // Constructor vacío
 public ProductoDTO() {
 }

 // Constructor con datos
 public ProductoDTO(Long id, String nombre, double precio, String descripcion, int stock) {
  this.id = id;
  this.nombre = nombre;
  this.precio = precio;
  this.descripcion = descripcion;
  this.stock = stock;
 }

 // Getters
 public Long getId() {
  return id;
 }

 public String getNombre() {
  return nombre;
 }

 public double getPrecio() {
  return precio;
 }

 public String getDescripcion() {
  return descripcion;
 }

 public int getStock() {
  return stock;
 }

 // Setters
 public void setId(Long id) {
  this.id = id;
 }

 public void setNombre(String nombre) {
  this.nombre = nombre;
 }

 public void setPrecio(double precio) {
  this.precio = precio;
 }

 public void setDescripcion(String descripcion) {
  this.descripcion = descripcion;
 }

 public void setStock(int stock) {
  this.stock = stock;
 }
}