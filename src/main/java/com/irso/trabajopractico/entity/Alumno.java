package com.irso.trabajopractico.entity;


import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "ALUMNO")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name ="dni", nullable = false, length = 100)
    private String dni;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "telefono", nullable = false )
    private int telefono;

    @Column(name = "fecha_de_nacimiento", nullable = false)
    private Date fecha_de_nacimiento;

    public Alumno() {
    }

    public Alumno(int id, String dni, String nombre, String apellido, String email, int telefono, Date fecha_de_nacimiento) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_de_nacimiento() {
        return fecha_de_nacimiento;
    }

    public void setFecha_de_nacimiento(Date fecha_de_nacimiento) {
        this.fecha_de_nacimiento = fecha_de_nacimiento;
    }
    
}