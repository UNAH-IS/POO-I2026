package com.alumnos;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alumnos.classes.Carrera;
import com.alumnos.classes.Maestro;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class MaestrosController implements Initializable{
    @FXML private TextField txtNumeroEmpleado;
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private TextField txtEdad;
    @FXML private TextField txtSueldo;
    @FXML private ComboBox<Carrera> cmbCarrera;
    @FXML private ToggleGroup tglGenero;
    @FXML private DatePicker dtpFechaNacimiento;
    @FXML private TableView<Maestro> tblMaestros;

    @FXML private Button btnGuardar;
    @FXML private Button btnActualizar;
    @FXML private Button btnEliminar;

    // private ObservableList<Carrera> carreras;
    private ObservableList<Maestro> maestros;

    public MaestrosController() {
        maestros = FXCollections.observableArrayList();
        

        maestros.add(new Maestro("20210001", 1000,"Juan", "Perez", App.carreras.get(0), 20, "Masculino", new Date()));
        maestros.add(new Maestro("20210002", 20000,"Maria", "Gomez", App.carreras.get(1), 21, "Femenino", new Date()));
        maestros.add(new Maestro("20210003", 200000,"Carlos", "Lopez", App.carreras.get(2), 22, "Masculino", new Date()));
        maestros.add(new Maestro("20210004", 30000, "Ana", "Martinez", App.carreras.get(3), 23, "Femenino", new Date()));
    }

    @FXML
    public void guardarMaestro() {
        String errores = validarFormulario();
        if (!errores.isEmpty()) {
            //Mostrar cuadro de dialogo con JavaFX indicando que el formulario no es valido
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Formulario no válido");
            alert.setContentText(errores);
            alert.showAndWait();
            return;
        }

        System.out.println("Guardar maestro con numero de empleado: " + txtNumeroEmpleado.getText()
                + ", nombre: " + txtNombre.getText()
                + ", apellido: " + txtApellido.getText()
                + ", edad: " + txtEdad.getText());
 
        LocalDate localDate = dtpFechaNacimiento.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        
        Maestro a = new Maestro(
                txtNumeroEmpleado.getText(),
                Double.parseDouble(txtSueldo.getText()),
                txtNombre.getText(),
                txtApellido.getText(),
                cmbCarrera.getSelectionModel().getSelectedItem(),
                Integer.parseInt(txtEdad.getText()),
                ((RadioButton) tglGenero.getSelectedToggle()).getText(),
                Date.from(instant)
        );

        maestros.add(a);
        limpiarComponentes();
    }

    @FXML
    public void actualizarMaestro() {
        Maestro maestroSeleccionado = tblMaestros.getSelectionModel().getSelectedItem();
        System.out.println("Maestro a actualizar" + maestroSeleccionado);
        
        if (maestroSeleccionado != null) {
            LocalDate localDate = dtpFechaNacimiento.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));

            maestroSeleccionado.setCodigoEmpleado(txtNumeroEmpleado.getText());
            maestroSeleccionado.setSueldo(Double.parseDouble(txtSueldo.getText()));
            maestroSeleccionado.setNombre(txtNombre.getText());
            maestroSeleccionado.setApellido(txtApellido.getText());
            maestroSeleccionado.setEdad(Integer.parseInt(txtEdad.getText()));
            maestroSeleccionado.setCarrera(cmbCarrera.getSelectionModel().getSelectedItem());
            maestroSeleccionado.setGenero(((RadioButton) tglGenero.getSelectedToggle()).getText());
            maestroSeleccionado.setFechaNacimiento(Date.from(instant));
            tblMaestros.refresh(); //Refresca la vista de la lista para mostrar los cambios
            limpiarComponentes();
        }
    }

    @FXML
    public void eliminarMaestro() {
        Maestro maestroSeleccionado = tblMaestros.getSelectionModel().getSelectedItem();
        System.out.println("Maestro a eliminar" + maestroSeleccionado);
        if (maestroSeleccionado != null) {
            maestros.remove(maestroSeleccionado);
            limpiarComponentes();
        }
    }

    @FXML
    public void salir() {
        System.exit(0);
    }

    public void limpiarComponentes() {
        txtNumeroEmpleado.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        txtSueldo.setText("");
        cmbCarrera.getSelectionModel().clearSelection();
        tglGenero.selectToggle(null);
        dtpFechaNacimiento.setValue(null);

        btnActualizar.setDisable(true);
        btnEliminar.setDisable(true);
        btnGuardar.setDisable(false);

        tblMaestros.getSelectionModel().clearSelection();
    }

    public String validarFormulario() {
        String errores = "";
        if (txtNumeroEmpleado.getText().isEmpty()) {
            errores += "El numero de empleado es obligatorio\n";
        }
        if (txtNombre.getText().isEmpty()) {
            errores += "El nombre es obligatorio\n";
        }
        if (txtApellido.getText().isEmpty()) {
            errores += "El apellido es obligatorio\n";
        }
        if (txtEdad.getText().isEmpty()) {
            errores += "La edad es obligatoria\n";
        }
        if (txtSueldo.getText().isEmpty()) {
            errores += "El sueldo es obligatorio\n";
        }

        if (cmbCarrera.getSelectionModel().getSelectedItem() == null ) {
            errores += "La carrera es obligatoria\n";
        } 

        if (tglGenero.getSelectedToggle() == null) {
            errores += "El genero es obligatorio\n";
        }

        //Validar el nombre y apellido solo con letras
        Pattern patternNombre = Pattern.compile("[a-zA-Z ]+");
        Matcher matcherNombre = patternNombre.matcher(txtNombre.getText());
        if (!matcherNombre.matches()) {
            errores += "El nombre solo debe contener letras\n";
        }

        Pattern patternApellido = Pattern.compile("[a-zA-Z ]+");
        Matcher matcherApellido = patternApellido.matcher(txtApellido.getText());
        if (!matcherApellido.matches()) {
            errores += "El apellido solo debe contener letras\n";
        }

        return errores;
    }

    public void seleccionarMaestro(Maestro oldValue, Maestro newValue) {
        System.out.println("Old Value: " + oldValue);
        System.out.println("New Value: " + newValue);
        if (newValue == null) {
            limpiarComponentes();
            return;
        }
        txtNumeroEmpleado.setText(newValue.getCodigoEmpleado());
        txtNombre.setText(newValue.getNombre());
        txtApellido.setText(newValue.getApellido());
        txtSueldo.setText(Double.toString(newValue.getSueldo()));
        cmbCarrera.getSelectionModel().select(newValue.getCarrera());
        if (newValue.getGenero().equals("Masculino")) {
            tglGenero.selectToggle(tglGenero.getToggles().get(1));
        } else if (newValue.getGenero().equals("Femenino")) {
            tglGenero.selectToggle(tglGenero.getToggles().get(0));
        } else {
            tglGenero.selectToggle(null);
        }

        dtpFechaNacimiento.setValue(newValue.getFechaNacimiento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

        btnActualizar.setDisable(false);
        btnEliminar.setDisable(false);
        btnGuardar.setDisable(true);
    }

    public void volver() {
        try {
            App.setRoot("Principal");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Finalizo la carga del FXML, es decir se crearon todos los controles");
        cmbCarrera.setItems(App.carreras);
        tblMaestros.setItems(maestros);

        //Inicializar las columnas del tableview
        TableColumn<Maestro, String> colNumeroEmpleado = new TableColumn<Maestro, String>("Número de Empleado");
        colNumeroEmpleado.setCellValueFactory(new PropertyValueFactory<>("codigoEmpleado"));
        tblMaestros.getColumns().add(colNumeroEmpleado);

        TableColumn<Maestro, String> colNombre = new TableColumn<Maestro, String>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tblMaestros.getColumns().add(colNombre);

        TableColumn<Maestro, String> colApellido = new TableColumn<Maestro, String>("Apellido");
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        tblMaestros.getColumns().add(colApellido);

        TableColumn<Maestro, Double> colSueldo = new TableColumn<Maestro, Double>("Sueldo");
        colSueldo.setCellValueFactory(new PropertyValueFactory<>("sueldo"));
        tblMaestros.getColumns().add(colSueldo);

        TableColumn<Maestro, Carrera> colCarrera = new TableColumn<Maestro, Carrera>("Carrera");
        colCarrera.setCellValueFactory(new PropertyValueFactory<>("carrera"));
        tblMaestros.getColumns().add(colCarrera);

        TableColumn<Maestro, String> colGenero = new TableColumn<Maestro, String>("Genero");
        colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        tblMaestros.getColumns().add(colGenero);

        TableColumn<Maestro, Date> colFechaNacimiento = new TableColumn<Maestro, Date>("Fecha de Nacimiento");
        colFechaNacimiento.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        tblMaestros.getColumns().add(colFechaNacimiento);
        
        tblMaestros.refresh();

        tblMaestros.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Maestro>() {
            @Override
            public void changed(ObservableValue<? extends Maestro> observable, Maestro oldValue, Maestro newValue) {
                seleccionarMaestro(oldValue, newValue);
            }

        }); 
    }
}

//listener