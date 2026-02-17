package clases;

import interfaces.Humano;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public abstract class Persona extends Object implements Humano {
    protected String nombre; //protected: accesible dentro del mismo paquete y en las subclases
    protected String apellido;
    protected Carrera carrera; // Asociación/Composición
    protected int edad;
    protected String genero;

    public Persona() {
        // System.out.println("Constructor vacio de Persona");
    }

    public Persona(String nombre, String apellido, Carrera carrera, int edad, String genero) {
        this.apellido = apellido;
        this.carrera = carrera;
        this.edad = edad;
        this.genero = genero;
        this.nombre = nombre;
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

    public void setGenero(String genero) {
        this.genero = genero;
    }

    //Los métodos abstractos son aquellos que no tienen una implementación, es decir, no tienen un cuerpo, solo se define su firma (nombre, parámetros y tipo de retorno)
    public abstract void mostrarInformacion();

    //Sobrescritura de metodos (Polimorfismo): es volver a escribir un metodo heredado de la clase padre
    // para darle una nueva funcionalidad en la clase hija
    @Override
    public String toString() {
        return nombre + ',' +
               apellido + ',' +
               carrera + ',' +
               edad + ',' +
               genero;
    }

    public  void solicitarInformacion(ArrayList<Carrera> carreras) {
        this.nombre = JOptionPane.showInputDialog("Nombre: ");
        this.apellido = JOptionPane.showInputDialog("Apellido: ");
        this.edad = Integer.parseInt(
                JOptionPane.showInputDialog("Edad: ")
            );
        this.genero = JOptionPane.showInputDialog("Genero: ");

        //Solicitar información de la carrera
        String listaCarreras = "Carreras disponibles:\n";
        for (int i = 0; i < carreras.size(); i++) {
            listaCarreras += (i+1) + ".- " + carreras.get(i).getNombreCarrera() + "\n";
        }

        String carreraSeleccionada = JOptionPane.showInputDialog(listaCarreras);
        int indiceCarreraSeccionada = Integer.parseInt(carreraSeleccionada) - 1;
        this.carrera = carreras.get(indiceCarreraSeccionada);

        System.out.println(" Carrera seleccionada: " + carreraSeleccionada);
    }

    @Override
    public void caminar() {
        System.out.println("La persona esta caminando");
    }

    @Override
    public void hablar() {
        System.out.println("La persona esta hablando");
    }

    @Override
    public void dormir() {
        System.out.println("La persona esta durmiendo");
    }

    @Override
    public void comer() {
        System.out.println("La persona esta comiendo");
    }

}