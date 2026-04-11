package com.alumnos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.alumnos.classes.Carrera;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class CarrerasController implements Initializable {
    @FXML private ListView<Carrera> lstCarreras;
    @FXML private TextField txtCodigoCarrera;
    @FXML private TextField txtNombreCarrera;
    @FXML private TextField txtCantidadClases;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lstCarreras.setItems(App.carreras);
    }
    
    @FXML
    public void agregarCarrera() {
        Carrera carrera = new Carrera(
            txtCodigoCarrera.getText(),
            txtNombreCarrera.getText(),
            Integer.parseInt(txtCantidadClases.getText())
        );

        App.carreras.add(carrera);
        guardarCarreraCSV(carrera);
    }

    public void guardarCarreraCSV(Carrera carrera) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("carreras.csv", true));
            bw.newLine();
            bw.write(carrera.toCSV());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void volver() {
        try {
            App.setRoot("Principal");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
