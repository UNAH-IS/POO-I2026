/*
Las excepciones son eventos que ocurren durante la ejecución de un programa que interrumpen el flujo normal de las instrucciones. 
En Java, las excepciones se manejan utilizando bloques try-catch, donde el código que puede generar una excepción se coloca dentro del bloque try, y el código para manejar la excepción se coloca dentro del bloque catch.

*/

public class App {
    public static void main(String[] args) {
        int resultados[] = new int[1];

        // try {
        //     int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número: "));
        //     int b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese otro número: "));
        //     int resultado = a / b;
        //     resultados[5] = resultado;
        //     JOptionPane.showMessageDialog(null, "La división es: " + resultado);
        // } catch (ArithmeticException e) {
        //     JOptionPane.showMessageDialog(null, "Error: División por cero no permitida.");
        // } catch (NumberFormatException e) {
        //     JOptionPane.showMessageDialog(null, "Error: Entrada no válida. Por favor, ingrese un número.");
        // } catch (ArrayIndexOutOfBoundsException e) {
        //     JOptionPane.showMessageDialog(null, "Error: Índice fuera de los límites del arreglo.");
        // } catch (Exception e) {
        //     JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        // }
        
        dividir(10,0);
    }

    static void dividir(int a, int b) throws ArithmeticException {
        throw new ArithmeticException("Esto está fallando porque quiero que falle.");
    }
}
