import clases.Alumno;
import clases.Carrera;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class App {
    private Alumno alumno1;
    private Alumno alumno2;
    private int numeros[];
    private ArrayList<Alumno> alumnos; //<Alumno> es un tipo de dato generico (raw type)
    private ArrayList<Carrera> carreras;
    

    public App() {
        numeros = new int[5]; //Limitado a solo 5
        alumnos = new ArrayList<Alumno>(); //Sin limite
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
                    break;
                case "3":
                    System.out.println("Agregar carrera");
                    break;
                case "4":
                    System.out.println("Listar alumnos");
                    listarAlumnos();
                    break;
                case "5":
                    System.out.println("Listar maestros");
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
        a.setCuenta(JOptionPane.showInputDialog("Cuenta: "));
        a.setNombre(JOptionPane.showInputDialog("Nombre: "));
        a.setApellido(JOptionPane.showInputDialog("Apellido: "));
        a.setEdad(
            Integer.parseInt(
                JOptionPane.showInputDialog("Edad: ")
            )
        );
        a.setGenero(JOptionPane.showInputDialog("Genero: "));
        a.setPromedio(
            Double.parseDouble(
                JOptionPane.showInputDialog("Promedio: ")
            )
        );

        String listaCarreras = "Carreras disponibles:\n";
        for (int i = 0; i < carreras.size(); i++) {
            listaCarreras += (i+1) + ".- " + carreras.get(i).getNombreCarrera() + "\n";
        }

        String carreraSeleccionada = JOptionPane.showInputDialog(listaCarreras);
        int indiceCarreraSeccionada = Integer.parseInt(carreraSeleccionada) - 1;
        a.setCarrera(carreras.get(indiceCarreraSeccionada));

        System.out.println(" Carrera seleccionada: " + carreraSeleccionada);
        alumnos.add(a);
    }

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

    public static void main(String[] args) throws Exception {
        new App();
    }
}
