1. Agregar alumno
2. Agregar maestro
3. Agregar carrera
3. Listar alumnos
4. Listar maestros


--Graphic User Interface (JAVA)
    -- AWT (Abstract Window Toolkit)
        OptionPane  
        Button
        CheckBox
        RadioButton
    -- SWING (Swing Toolkit)
        JOptionPane  
        JButton
        JCheckBox
        JRadioButton
    -- JavaFX

Fechas de examen
1er examen 27 feb (4pm - 7pm~8pm) (42%)
2do examen 10 abril (43%)
Proyecto 15 abril (15%)
Reposición 17 abril


Clases abstractas:
Usualmente se utilizan para definir una estructura común para un grupo de clases relacionadas, pero no se desea que se puedan crear objetos directamente de esa clase. 
En su lugar, se espera que otras clases hereden de la clase abstracta y proporcionen implementaciones específicas para los métodos abstractos definidos en la clase abstracta.
1. Son clases que no se pueden instanciar
2. Para declarlas es necesario agregar el prefijo abstract a la clase
3. Una clase abstracta puede tener o no métodos abstractos
4. Los métodos deben sobreescribirse obligatoriamente en clases hijas
5. Los métodos abstractos no pueden tener un cuerpo, es decir, no pueden tener una implementación, solo se define su firma (nombre, parámetros y tipo de retorno)
5. A pesar de que no se puedan instanciar, si pueden tener constructores


Interfaces
Es una estructura de datos parecida a una clase abstracta, 
se utiliza para definir un contrato que las clases que implementen la interfaz deben cumplir, es decir, deben proporcionar implementaciones para los métodos definidos en la interfaz.
Características:
1. No pueden tener atributos, solo constantes (public static final)
2. Todos los métodos son abstractos, es decir, no pueden tener un cuerpo, solo se define su firma (nombre, parámetros y tipo de retorno)
3. Para declarar una interfaz se utiliza la palabra reservada interface
4. Las clases hijas que tengan una interfaz padre, deben 
sobreescribir obligatoriamente todos los métodos de la interfaz, de lo contrario, la clase hija también debe ser declarada como abstracta.
5. Una clase puede implementar varias interfaces, pero solo puede heredar de una clase padre (herencia simple)
6. No se pueden instanciar.

Podríamos utilizar una interfaz para:
1. Librerias de constantes
2. Definir reglas a seguir para un grupo de clases relacionadas.
3. Para gestion de eventos (listeners) en interfaces graficas