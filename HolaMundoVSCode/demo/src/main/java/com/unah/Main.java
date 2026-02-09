package com.unah;

import com.unah.clases.Alumno;
import com.unah.clases.Carrera;
import com.unah.clases.Maestro;
import com.unah.clases.Persona;

public class Main {
    //Tipos de datos primitivos
    static int numero = 10; // atribut statico
    long numeroGrande = 100000L;
    double decimal = 5.5;
    char caracter = 'A';
    boolean esVerdadero = true;
    final float PI = 3.14f; // Constante

    public static void main(String[] args) {
        // //Tipo de dato no primitivo
        // String nombre = "Pedro";
        // // tipoDato nombreVarible = valor;
        // Alumno alumno1 = new Alumno(
        //     "20220123",
        //     "Juan",
        //     "Perez",
        //     20,
        //     "M"
        // ); //instanciar la clase Alumno
        
        // //No se puede acceder a los atributos privados:
        // // alumno1.cuenta = "20220123";
        // // alumno1.nombre = "Juan";
        // // alumno1.apellido = "Perez";
        // // alumno1.edad = 20;
        // // alumno1.genero = "M";
        // //System.out.println("Hola " + alumno1.nombre + " " + alumno1.apellido);
        // alumno1.mostrarInformacion();
        // System.out.println("Nombre" + alumno1.getNombre()); 

        // Alumno alumno2 = new Alumno(
        //     "20220124",
        //     "Maria",
        //     "Lopez",
        //     22,
        //     "F"
        // );
        // alumno2.mostrarInformacion();

        // Alumno alumno3 = new Alumno(
        //     "20220125",
        //     "Carlos",
        //     "Ramirez",
        //     19,
        //     "M"
        // );
        // alumno3.mostrarInformacion();
        // alumno3.mostrarInformacion("Información del alumno 3");

        // // Alumno.nombrePorDefecto = "Alumno sin nombre"; 
        // // alumno1.nombrePorDefecto = "Alumno sin nombre 1";
        // // alumno2.nombrePorDefecto = "Alumno sin nombre 2";
        // // alumno3.nombrePorDefecto = "Alumno sin nombre 3";

        // // System.out.println("Nombre por defecto: " + alumno1.nombrePorDefecto);
        // // System.out.println("Nombre por defecto: " + alumno2.nombrePorDefecto);
        // // System.out.println("Nombre por defecto: " + alumno3.nombrePorDefecto);

        // Alumno alumno4 = new Alumno();
        // alumno4.setNombre("Luisa");

        // System.out.println(alumno1);
        // System.out.println(alumno2);
        // System.out.println(alumno3);

        // System.out.println("Alumno 4 nombre: " + alumno4.getNombre());

        Persona persona1 = new Persona(
            "Ana",
            "Gomez",
            new Carrera("IS", "Ingeniería en Sistemas", 56),
            21,
            "F"
        );

        System.out.println("To String de persona1: " + persona1.toString());

        Alumno alumno5 = new Alumno(
            "20220126",
            "Luis",
            "Martinez",
            new Carrera("ARQ", "Arquitectura", 60),
            23,
            "M",
            8.5
        );

        System.out.println("To String de alumno5: " + alumno5.toString());

        Maestro maestro1 = new Maestro(
            "EMP001",
            15000.0,
            "Marta",
            "Sanchez",
            new Carrera("MED", "Medicina", 70),
            35,
            "F"
        );

        System.out.println("To String de maestro1: " + maestro1.toString());
    }
}