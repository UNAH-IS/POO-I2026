package com.alumnos;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alumnos.classes.Alumno;
import com.alumnos.classes.Carrera;

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
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class AlumnosController implements Initializable{
    @FXML private TextField txtCuenta;
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private TextField txtEdad;
    @FXML private TextField txtPromedio;
    @FXML private ComboBox<Carrera> cmbCarrera;
    @FXML private ToggleGroup tglGenero;
    @FXML private ListView<Alumno> lstAlumnos;
    @FXML private DatePicker dtpFechaNacimiento;
    @FXML private TableView<Alumno> tblAlumnos;

    @FXML private Button btnGuardar;
    @FXML private Button btnActualizar;
    @FXML private Button btnEliminar;

    private ObservableList<Alumno> alumnos;

    public AlumnosController() {
        alumnos = FXCollections.observableArrayList();
        alumnos.add(new Alumno("20210001", "Juan", "Perez", App.carreras.get(0), 20, "Masculino", 8.5, new Date()));
        alumnos.add(new Alumno("20210002", "Maria", "Gomez", App.carreras.get(1), 21, "Femenino", 9.0, new Date()));
        alumnos.add(new Alumno("20210003", "Carlos", "Lopez", App.carreras.get(2), 22, "Masculino", 7.5, new Date()));
        alumnos.add(new Alumno("20210004", "Ana", "Martinez", App.carreras.get(3), 23, "Femenino", 8.0, new Date()));
    }

    @FXML
    public void guardarAlumno() {
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

        System.out.println("Guardar alumno con cuenta: " + txtCuenta.getText()
                + ", nombre: " + txtNombre.getText()
                + ", apellido: " + txtApellido.getText()
                + ", edad: " + txtEdad.getText());
 
        LocalDate localDate = dtpFechaNacimiento.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        
        Alumno a = new Alumno(
                txtCuenta.getText(),
                txtNombre.getText(),
                txtApellido.getText(),
                cmbCarrera.getSelectionModel().getSelectedItem(),
                Integer.parseInt(txtEdad.getText()),
                ((RadioButton) tglGenero.getSelectedToggle()).getText(),
                Double.parseDouble(txtPromedio.getText()),
                Date.from(instant)
        );

        alumnos.add(a);
        limpiarComponentes();
    }

    @FXML
    public void actualizarAlumno() {
        Alumno alumnoSeleccionado = lstAlumnos.getSelectionModel().getSelectedItem();
        System.out.println("Alumno a actualizar" + alumnoSeleccionado);
        
        if (alumnoSeleccionado != null) {
            LocalDate localDate = dtpFechaNacimiento.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));

            alumnoSeleccionado.setCuenta(txtCuenta.getText());
            alumnoSeleccionado.setNombre(txtNombre.getText());
            alumnoSeleccionado.setApellido(txtApellido.getText());
            alumnoSeleccionado.setEdad(Integer.parseInt(txtEdad.getText()));
            alumnoSeleccionado.setCarrera(cmbCarrera.getSelectionModel().getSelectedItem());
            alumnoSeleccionado.setGenero(((RadioButton) tglGenero.getSelectedToggle()).getText());
            alumnoSeleccionado.setPromedio(Double.parseDouble(txtPromedio.getText()));
            alumnoSeleccionado.setFechaNacimiento(Date.from(instant));
            lstAlumnos.refresh(); //Refresca la vista de la lista para mostrar los cambios
            limpiarComponentes();
        }
    }

    @FXML
    public void eliminarAlumno() {
        Alumno alumnoSeleccionado = lstAlumnos.getSelectionModel().getSelectedItem();
        System.out.println("Alumno a eliminar" + alumnoSeleccionado);
        if (alumnoSeleccionado != null) {
            alumnos.remove(alumnoSeleccionado);
            limpiarComponentes();
        }
    }

    @FXML
    public void salir() {
        System.exit(0);
    }

    public void limpiarComponentes() {
        txtCuenta.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        txtPromedio.setText("");
        cmbCarrera.getSelectionModel().clearSelection();
        tglGenero.selectToggle(null);
        dtpFechaNacimiento.setValue(null);

        btnActualizar.setDisable(true);
        btnEliminar.setDisable(true);
        btnGuardar.setDisable(false);

        lstAlumnos.getSelectionModel().clearSelection();
        tblAlumnos.getSelectionModel().clearSelection();
    }

    public String validarFormulario() {
        String errores = "";
        if (txtCuenta.getText().isEmpty()) {
            errores += "La cuenta es obligatoria\n";
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
        if (txtPromedio.getText().isEmpty()) {
            errores += "El promedio es obligatorio\n";
        }

        if (cmbCarrera.getSelectionModel().getSelectedItem() == null ) {
            errores += "La carrera es obligatoria\n";
        } 

        if (tglGenero.getSelectedToggle() == null) {
            errores += "El genero es obligatorio\n";
        }


        //Validar campos especificos
        Pattern patternCuenta = Pattern.compile("\\d{11}");
        Matcher matcherCuenta = patternCuenta.matcher(txtCuenta.getText());
        if (!matcherCuenta.matches()) {
            errores += "La cuenta debe tener 11 digitos\n";
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

    public void seleccionarAlumno(Alumno oldValue, Alumno newValue) {
        System.out.println("Old Value: " + oldValue);
        System.out.println("New Value: " + newValue);
        if (newValue == null) {
            limpiarComponentes();
            return;
        }
        txtCuenta.setText(newValue.getCuenta());
        txtNombre.setText(newValue.getNombre());
        txtApellido.setText(newValue.getApellido());
        txtEdad.setText(String.valueOf(newValue.getEdad()));
        txtPromedio.setText(String.valueOf(newValue.getPromedio()));
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

    @FXML
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
        lstAlumnos.setItems(alumnos);
        tblAlumnos.setItems(alumnos);

        //Inicializar las columnas del tableview
        TableColumn<Alumno, String> colCuenta = new TableColumn<Alumno, String>("Cuenta");
        colCuenta.setCellValueFactory(new PropertyValueFactory<>("cuenta"));
        tblAlumnos.getColumns().add(colCuenta);

        TableColumn<Alumno, String> colNombre = new TableColumn<Alumno, String>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tblAlumnos.getColumns().add(colNombre);

        TableColumn<Alumno, String> colApellido = new TableColumn<Alumno, String>("Apellido");
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        tblAlumnos.getColumns().add(colApellido);

        TableColumn<Alumno, Double> colPromedio = new TableColumn<Alumno, Double>("Promedio");
        colPromedio.setCellValueFactory(new PropertyValueFactory<>("promedio"));
        tblAlumnos.getColumns().add(colPromedio);

        TableColumn<Alumno, Carrera> colCarrera = new TableColumn<Alumno, Carrera>("Carrera");
        colCarrera.setCellValueFactory(new PropertyValueFactory<>("carrera"));
        tblAlumnos.getColumns().add(colCarrera);

        TableColumn<Alumno, String> colGenero = new TableColumn<Alumno, String>("Genero");
        colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        tblAlumnos.getColumns().add(colGenero);

        TableColumn<Alumno, Date> colFechaNacimiento = new TableColumn<Alumno, Date>("Fecha de Nacimiento");
        colFechaNacimiento.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        tblAlumnos.getColumns().add(colFechaNacimiento);
        
        tblAlumnos.refresh();

        lstAlumnos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Alumno>() { //<RawType>
            @Override
            public void changed(ObservableValue<? extends Alumno> observable, Alumno oldValue, Alumno newValue) {
                seleccionarAlumno(oldValue, newValue);
            }
        });
        tblAlumnos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Alumno>() {
            @Override
            public void changed(ObservableValue<? extends Alumno> observable, Alumno oldValue, Alumno newValue) {
                seleccionarAlumno(oldValue, newValue);
            }

        }); 
    }
}

//listener