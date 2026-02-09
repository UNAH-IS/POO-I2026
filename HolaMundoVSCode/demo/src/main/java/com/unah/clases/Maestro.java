package com.unah.clases;

public class Maestro extends Persona {
    private String codigoEmpleado;
    private double sueldo;

    public Maestro(String codigoEmpleado, double sueldo, String nombre, String apellido, Carrera carrera, int edad, String genero) {
        super(nombre, apellido, carrera, edad, genero);
        this.codigoEmpleado = codigoEmpleado;
        this.sueldo = sueldo;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return codigoEmpleado + ',' +
               sueldo + ',' +
               super.toString();
    }

    
}
