import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class App {
    public App() {
        // File file = new File("Archivo.txt"); // Crear un objeto File con la ruta del archivo
        // File directorio = new File("directorio");
        // if (file.exists()) { // Verificar si el archivo existe
        //     System.out.println("El archivo existe.");
        //     System.out.println("Es un archivo: " + file.isFile());
        //     System.out.println("Es un directorio: " + file.isDirectory());
        //     System.out.println("Tamaño del archivo: " + file.length() + " bytes");
        //     System.out.println("Última modificación: " + file.lastModified());

        // } else {
        //     System.out.println("El archivo no existe.");
        //     try {
        //         file.createNewFile();
        //     } catch (IOException e) {
        //         System.out.println("Error al crear el archivo: " + e.getMessage());
        //     }
        // }

        // if (!directorio.exists()) {
        //     directorio.mkdir(); //make directory
        // }

        //Crear múltiples archivos en un bucle
        // try {    
        //     for (int i = 0; i< 100; i++) {
        //         File nuevoArchivo = new File ("spam" + i + ".txt");
        //         nuevoArchivo.createNewFile();
        //     }
        // } catch (IOException e) {
        //     System.out.println("Error al crear los archivos: " + e.getMessage());
        // }



        //Leer un archivo basado en caracteres con FileReader
        // try {
        //     FileReader reader = new FileReader("Readme.md");
        //     int character;
        //     while ((character = reader.read()) != -1) {
        //         System.out.print((char) character); // Imprimir el carácter leído
        //     }
        //     reader.close(); // Cerrar el FileReader
        // } catch (IOException e) {
        //     System.out.println("Error al leer el archivo: " + e.getMessage());
        // }

        //Leer un archivo utilizando bufferedReader
        // try {
        //     BufferedReader bufferedReader = new BufferedReader(new FileReader("Readme.md"));
        //     String linea;
        //     while ((linea = bufferedReader.readLine()) != null) {
        //         System.out.println(linea); // Imprimir la línea leída
        //     }
        //     bufferedReader.close(); // Cerrar el BufferedReader
        // } catch (IOException e) {
        //     System.out.println("Error al leer el archivo: " + e.getMessage());
        // }

        //Escribir un archivo utilizando FileWriter
        // try {
        //     FileWriter writer = new FileWriter("Archivo.txt");
        //     writer.write("Hola, este es un nuevo archivo creado con FileWriter.");
        //     writer.close(); // Cerrar el FileWriter
        // } catch (IOException e) {
        //     System.out.println("Error al escribir en el archivo: " + e.getMessage());
        // }

        //Escribir un archivo utilizando BufferedWriter
        // try {
        //     BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Archivo.txt"));
        //     bufferedWriter.write("Hola, este es un nuevo archivo creado con BufferedWriter.");
        //     bufferedWriter.newLine(); // Agregar una nueva línea
        //     bufferedWriter.write("Esta es otra línea en el archivo.");
        //     bufferedWriter.close(); // Cerrar el BufferedWriter 
        // } catch (Exception e) {
        // }


        Alumno alumno1 = new Alumno("Pedro", 20);

        //Escribir el objeto alumno1 en un archivo utilizando ObjectOutputStream
        // try {
        //     ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("alumno.ser", true)); //ser: serializar
        //     objectOutputStream.writeObject(alumno1);
        //     objectOutputStream.close(); // Cerrar el ObjectOutputStream
        // } catch (IOException e) {
        //     System.out.println("Error al escribir el objeto en el archivo: " + e.getMessage());
        //     e.printStackTrace();
        // }

        // Leer el objeto alumno1 desde el archivo utilizando ObjectInputStream
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("alumno.ser"));
            //Leer todos los objetos del archivo hasta que no haya más
            
            Alumno alumnoLeido = (Alumno) objectInputStream.readObject();
            while (alumnoLeido != null) {
                System.out.println("Nombre: " + alumnoLeido.getNombre());
                System.out.println("Edad: " + alumnoLeido.getEdad());
                alumnoLeido = (Alumno) objectInputStream.readObject();
            }

            objectInputStream.close(); // Cerrar el ObjectInputStream

            // Imprimir los datos del alumno leído
            System.out.println("Nombre: " + alumnoLeido.getNombre());
            System.out.println("Edad: " + alumnoLeido.getEdad());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el objeto desde el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new App();   
    }
}
