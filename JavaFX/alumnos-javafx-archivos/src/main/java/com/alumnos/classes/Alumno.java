package com.alumnos.classes;

import java.util.Date;

public class Alumno extends Persona {
    // int x;  //modificador de acceso default: accesible dentro del mismo paquete 
    // public int y; //modificador de acceso public: accesible desde cualquier clase
    private String cuenta; //modificador de acceso private: accesible solo dentro de la misma clase
    private double promedio;

    //Atributo estatico: pertenece a la clase y no a los objetos
    //Se accede a traves del nombre de la clase (es decir, no se necesita un objeto para acceder a el)
    //Se comparte entre todos los objetos de la clase
    //Mantiene el mismo valor para todos los objetos
    public static String nombrePorDefecto = "Sin nombre";

    //Constructor
    //Metodo especial que se ejecuta al momento de crear un objeto
    //Tiene ser publico
    //Tiene que tener el mismo nombre de la clase
    //No tiene tipo de retorno
    //Puede recibir parametros
    //Usualmente se usa para inicializar los atributos del objeto
    //Si no se define un constructor, Java proporciona uno por defecto (sin parametros)
    public Alumno(String cuenta, String nombre, String apellido, Carrera carrera, int edad, String genero, double promedio, Date fechaNacimiento) {
        super(nombre, apellido, carrera, edad, genero, fechaNacimiento); //Invoca el constructor de la clase padre Persona, tiene que ser la primera linea del constructor
        this.cuenta = cuenta;
        this.promedio = promedio;
        // this.nombre = nombre;
        // this.apellido = apellido;
        // this.carrera = carrera;
        // this.edad = edad;
        // this.genero = genero;
        
    }

    public Alumno() {
        // System.out.println("Constructor vacio");
    }

    
    //Encapsulamiento: conjunto de metodos que permiten acceder y modificar los atributos privados de una clase
    //El objetivo es proteger los datos y controlar el acceso a ellos
    //set ==> establecer
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    //get ==> obtener
    public String getCuenta() {
        return this.cuenta;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public double getPromedio() {
        return this.promedio;
    }

    @Override
    public String toString() {
        return cuenta + ',' +
                promedio + ',' +
                super.toString();
    }

///123456,Juan,Perez,30,M,ISC,56,2020-01-15
    public String toCSV() {
        return cuenta + ',' +
                nombre + ',' +
                apellido + ',' +
                edad + ',' +
                (genero.equals("Masculino") ? "M" : "F") + ',' +
                carrera.getCodigoCarrera() + ',' +
                promedio + ',' +
                fechaNacimiento.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
    }
}

