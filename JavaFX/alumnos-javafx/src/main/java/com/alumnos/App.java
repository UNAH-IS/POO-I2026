package com.alumnos;

import java.io.IOException;

import com.alumnos.classes.Carrera;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static ObservableList<Carrera> carreras;

    @Override
    public void start(Stage stage) throws IOException {
        carreras = FXCollections.observableArrayList();
        carreras.add(new Carrera("ISC", "Ingeniería en Sistemas Computacionales", 56));
        carreras.add(new Carrera("IQ", "Ingeniería Quimica", 56));
        carreras.add(new Carrera("MM", "Matematicas", 56));
        carreras.add(new Carrera("FS", "Fisica", 56));

        scene = new Scene(loadFXML("Principal"));
        stage.setTitle("Gestion de matricula de alumnos");
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}