package com.unah.clases;

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
    public Alumno(String cuenta, String nombre, String apellido, Carrera carrera, int edad, String genero, double promedio) {
        super(nombre, apellido, carrera, edad, genero); //Invoca el constructor de la clase padre Persona, tiene que ser la primera linea del constructor
        this.cuenta = cuenta;
        this.promedio = promedio;
        // this.nombre = nombre;
        // this.apellido = apellido;
        // this.carrera = carrera;
        // this.edad = edad;
        // this.genero = genero;

        
    }

    public Alumno() {
        System.out.println("Constructor vacio");
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

    // public void mostrarInformacion() {
    //     System.out.println(
    //         "Cuenta: " + this.cuenta +
    //         ", Nombre: " + this.nombre +
    //         ", Apellido: " + this.apellido +
    //         ", Edad: " + this.edad +
    //         ", Genero: " + this.genero
    //     );
    // }

    //Sobrecarga de metodos (Polimorfismo)
    // public void mostrarInformacion(String titulo) {
    //     System.out.println("____________ " + titulo + " ____________");
    //     mostrarInformacion();
    // }
}

//POJO: Plain Old Java Object
//Clase simple que contiene atributos y metodos get y set

//Abstracción:
//Proceso de simplificación de un objeto complejo
//Se enfoca en los aspectos esenciales y relevantes del objeto
//Ignorando los detalles innecesarios

//Polimorfismo:
//Capacidad de un objeto de tomar diferentes formass
//Se refiere a la capacidad de un metodo de comportarse de diferentes maneras

//Herencia:
//Mecanismo que permite crear una nueva clase a partir de una clase existente
//La nueva clase hereda los atributos y metodos de la clase existente  
//Permite reutilizar codigo y crear jerarquias de clases
