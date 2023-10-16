package com.example.recetario;

import com.example.recetario.models.Receta;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TextField txtNombre;
    @FXML
    private Slider spinnerDuracion;
    @FXML
    private ComboBox comboDificultad;
    @FXML
    private ListView<String> listaTipo;
    @FXML
    private Button btnAñadir;
    @FXML
    private TableColumn<Receta,String> cNombre;
    @FXML
    private TableColumn<Receta,String> cDuracion;
    @FXML
    private TableColumn<Receta,String> cDificultad;
    @FXML
    private TableColumn<Receta,String> cTipo;
    @FXML
    private TableView<Receta> tabla;
    @FXML
    private Label info;
    @FXML
    private Label labelDuracion;

    @FXML
    protected void onHelloButtonClick() {
    }

    @FXML
    public void addToTable(ActionEvent actionEvent) {
        Receta receta = new Receta();
        receta.setDificultad( comboDificultad.getValue().toString() );
        receta.setTipo( listaTipo.getSelectionModel().getSelectedItem());
        receta.setDuracion((int) spinnerDuracion.getValue());
        receta.setNombre( txtNombre.getText());
        tabla.getItems().add(receta);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboDificultad.getItems().addAll("Baja","Media","Alta");
        listaTipo.getItems().addAll("Desayuno","Segundo desayuno","Tapa","Almuerzo","Merienda","Cena","Recena");
        spinnerDuracion.setValue(60);

        cNombre.setCellValueFactory( fila -> new SimpleStringProperty(fila.getValue().getNombre()) );
        cDificultad.setCellValueFactory( fila -> new SimpleStringProperty(fila.getValue().getDificultad()) );
        cDuracion.setCellValueFactory( fila -> {
            return new SimpleStringProperty((fila.getValue()).getDuracion()+" min");
        } );
        cTipo.setCellValueFactory( fila -> new SimpleStringProperty(fila.getValue().getTipo()) );

        tabla.getItems().add(new Receta("Tacos de carne asada", "Almuerzo", 45, "Fácil"));
        tabla.getItems().add(new Receta("Huevos revueltos con tocino", "Desayuno", 15, "Moderada"));
        tabla.getItems().add(new Receta("Sándwich de jamón y queso", "Merienda", 10, "Fácil"));
        tabla.getItems().add(new Receta("Pollo a la parrilla con verduras", "Almuerzo", 60, "Moderada"));
        tabla.getItems().add(new Receta("Avena con frutas", "Desayuno", 20, "Fácil"));
        tabla.getItems().add(new Receta("Ensalada de atún", "Almuerzo", 30, "Moderada"));
        tabla.getItems().add(new Receta("Pizza casera", "Cena", 35, "Moderada"));
        tabla.getItems().add(new Receta("Batido de frutas", "Merienda", 5, "Fácil"));
        tabla.getItems().add(new Receta("Sopa de pollo casera", "Cena", 40, "Difícil"));
        tabla.getItems().add(new Receta("Pancakes con sirope de arce", "Desayuno", 25, "Moderada"));

    }

    @FXML
    public void actualizaDuracion(Event event) {
        labelDuracion.setText( Math.round(spinnerDuracion.getValue())+" min");
    }


}