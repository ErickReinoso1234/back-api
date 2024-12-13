package com.example.users.dto;

import java.time.LocalDate;

public class UserRequestDto {

  private String cedula;
  private String nombre;
  private String apellido;
  private String correo;
  private String password;
  private String celular;
  private LocalDate fechaNacimiento;
  
  // Getters y Setters
public String getCedula() {
    return cedula;
}

public void setCedula(String cedula) {
    this.cedula = cedula;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public String getApellido() {
    return apellido;
}

public void setApellido(String apellido) {
    this.apellido = apellido;
}

public String getCorreo() {
    return correo;
}

public void setCorreo(String correo) {
    this.correo = correo;
}

public String getPassword() {
  return password;
}

public void setPassword(String password) {
  this.password = password;
}

public String getCelular() {
    return celular;
}

public void setCelular(String celular) {
    this.celular = celular;
}

public LocalDate getFechaNacimiento() {
    return fechaNacimiento;
}

public void setFechaNacimiento(LocalDate fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
}
    // Erick
}
