module com.alumnos {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.alumnos to javafx.fxml;
    opens com.alumnos.classes to javafx.base;
    exports com.alumnos;
}
