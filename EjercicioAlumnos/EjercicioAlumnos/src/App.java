import clases.Alumno;
import clases.Carrera;
import clases.Maestro;
import clases.Persona;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class App {
    private Alumno alumno1;
    private Alumno alumno2;
    private int numeros[];
    private ArrayList<Alumno> alumnos; //<Alumno> es un tipo de dato generico (raw type)
    private ArrayList<Maestro> maestros;
    private ArrayList<Carrera> carreras;
    

    public App() {
        numeros = new int[5]; //Limitado a solo 5
        alumnos = new ArrayList<Alumno>(); //Sin limite
        maestros = new ArrayList<Maestro>();
        carreras = new ArrayList<Carrera>();

        carreras.add(
            new Carrera(
                "C001", 
                "Ingenieria en Sistemas", 
                40
            )
        );

        carreras.add(
            new Carrera(
                "C002", 
                "Ingenieria Industrial", 
                38
            )
        );

        carreras.add(
            new Carrera(
                "C003", 
                "Ingenieria Quimica", 
                45
            )
        );

        alumno1 = new Alumno(
            "20210001",
            "Pedro",
            "Ramirez",
            null,
            20,
            "Masculino",
            8.5
        );

        alumno2 = new Alumno(
            "20210002",
            "Maria",
            "Lopez",
            null,
            22,
            "Femenino",
            9.2
        );

        alumnos.add(alumno1);
        alumnos.add(alumno2);
        alumnos.add(
            new Alumno(
                "20210003",
                "Juan",
                "Perez",
                null,
                21,
                "Masculino",
                7.8
            )
        );

        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println(alumnos.get(i).toString());
        }

        mostrarMenu();
    }

    public void mostrarMenu() {
        String opcion;
        do {
             opcion = JOptionPane.showInputDialog(
                "0. Salir\n" +
                "1. Agregar alumno\n" +
                "2. Agregar maestro\n" +
                "3. Agregar carrera\n" +
                "4. Listar alumnos\n" +
                "5. Listar maestros\n" +
                "6. Listar carreras"
            );
            System.out.println("Opcion seleccionada: " + opcion);
            // if (opcion.equals("0")) {
            //     System.exit(0); //Termina la aplicacion
            // }

            switch (opcion) {
                case "0":
                    System.out.println("Saliendo...");
                    break;
                case "1":
                    System.out.println("Agregar alumno");
                    agregarAlumno();
                    break;
                case "2":
                    System.out.println("Agregar maestro");
                    agregarMaestro();
                    break;
                case "3":
                    System.out.println("Agregar carrera");
                    agregarCarrera();
                    break;
                case "4":
                    System.out.println("Listar alumnos");
                    listarPersonas(alumnos, "Lista de alumnos");
                    break;
                case "5":
                    System.out.println("Listar maestros");
                    listarPersonas(maestros, "Lista de maestros");
                    break;
                case "6": 
                    System.out.println("Listar carreras");
                    listarCarreras();
                    break;
                default:
                    JOptionPane.showMessageDialog(
                        null,
                        "Opcion no valida",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );
            }
            // opcionValida(opcion);
        } while (!opcion.equals("0"));
    }

    // public boolean opcionValida(String opcion) {
    //     int opcionInt = Integer.parseInt(opcion);
    //     if (opcionInt >= 0 && opcionInt <= 5) {
    //         return true;
    //     } else {
    //         JOptionPane.showMessageDialog(
    //             null,
    //             "Opcion no valida",
    //             "Error",
    //             JOptionPane.ERROR_MESSAGE
    //         );
    //         return false;
    //     }
    // }

    public void agregarAlumno() {
        Alumno a = new Alumno();
        a.solicitarInformacion(carreras);
        alumnos.add(a);
    }

    public void agregarMaestro() {
        Maestro m = new Maestro();
        m.solicitarInformacion(carreras);
        maestros.add(m);
    }

    public void agregarCarrera() {
        Carrera c = new Carrera();
        c.solicitarInformacion();
        carreras.add(c);
    }

    public void listarPersonas(ArrayList<? extends Persona> personas, String titulo) {
        String listadoPersonas = titulo + ":\n";
        for (int i = 0; i < personas.size(); i++) {
            listadoPersonas += (i+1) + ".- " + personas.get(i).toString() + "\n";
        }

        JOptionPane.showMessageDialog(
            null,   
            listadoPersonas,
            titulo,
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void listarCarreras() {
        String listaCarreras = "Listado de carreras:\n";
        for (int i = 0; i < carreras.size(); i++) {
            listaCarreras += (i+1) + ".- " + carreras.get(i).toString() + "\n";
        }

        JOptionPane.showMessageDialog(
            null,   
            listaCarreras,
            "Carreras",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    @Deprecated
    public void listarAlumnos() {
        String listadoAlumnos = "Listado de Alumnos:\n";
        for (int i = 0; i < alumnos.size(); i++) {
            listadoAlumnos += (i+1) + ".- " + alumnos.get(i).toString() + "\n";
        }

        JOptionPane.showMessageDialog(
            null,   
            listadoAlumnos,
            "Alumnos",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    @Deprecated
    public void listarMaestros() {
        String listadoMaestros = "Listado de Maestros:\n";
        for (int i = 0; i < maestros.size(); i++) {
            listadoMaestros += (i+1) + ".- " + maestros.get(i).toString() + "\n";
        }

        JOptionPane.showMessageDialog(
            null,   
            listadoMaestros,
            "Maestros",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
