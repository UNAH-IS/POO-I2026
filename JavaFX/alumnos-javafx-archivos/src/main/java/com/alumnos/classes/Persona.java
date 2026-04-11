package com.alumnos.classes;

import java.util.Date;

public abstract class Persona {
    protected String nombre; //protected: accesible dentro del mismo paquete y en las subclases
    protected String apellido;
    protected Carrera carrera; // Asociación/Composición
    protected int edad;
    protected String genero;
    protected Date fechaNacimiento;

    public Persona() {
        // System.out.println("Constructor vacio de Persona");
    }

    public Persona(String nombre, String apellido, Carrera carrera, int edad, String genero, Date fechaNacimiento) {
        this.apellido = apellido;
        this.carrera = carrera;
        this.edad = edad;
        this.genero = genero;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
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

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    //Sobrescritura de metodos (Polimorfismo): es volver a escribir un metodo heredado de la clase padre
    // para darle una nueva funcionalidad en la clase hija
    @Override
    public String toString() {
        return nombre + ',' +
               apellido + ',' +
               carrera + ',' +
               edad + ',' +
               genero + ',' +
               fechaNacimiento;
    }

}