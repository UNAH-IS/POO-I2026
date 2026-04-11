package com.alumnos;

import java.io.IOException;

import javafx.fxml.FXML;

public class PrincipalController {
    
    @FXML
    public void abrirFormularioAlumnos() {
        System.out.println("Se debería abrir el formulario de alumnos");
        try {
            App.setRoot("Alumnos");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void abrirFormularioMaestros() {
        System.out.println("Se debería abrir el formulario de maestros");
        try {
            App.setRoot("Maestros");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void abrirFormularioCarreras() {
        try {
            App.setRoot("Carreras");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
