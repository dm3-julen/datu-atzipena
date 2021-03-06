/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import controller.GestionListaEnMemoria;

import model.Person;

/**
 *
 * @author idoia
 */
public class MainWindow extends Application {

    private final TableView<Person> table = new TableView<>();

    final HBox hb = new HBox();

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());

        ObservableList<Person> data = GestionListaEnMemoria.cargarDatos();

        stage.setTitle("Tabla de caracteristicas");
        stage.setWidth(700);
        stage.setHeight(550);
        final Label label = new Label("Monstruos");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn<Person, String> firstNameCol = new TableColumn<>("Nombre");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        firstNameCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        firstNameCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Person, String> t) -> {
                    ((Person) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())).setFirstName(t.getNewValue());
                });

        TableColumn<Person, String> lastNameCol
                = new TableColumn<>("Especie");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<>("lastName"));
        lastNameCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        lastNameCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Person, String> t) -> {
                    ((Person) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())).setLastName(t.getNewValue());
                });

        TableColumn<Person, String> emailCol = new TableColumn<>("Elemento");
        emailCol.setMinWidth(150);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<>("email"));
        emailCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        emailCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Person, String> t) -> {
                    ((Person) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())).setEmail(t.getNewValue());
                });
        TableColumn<Person, String> WeaknessCol = new TableColumn<>("Debilidad");
        WeaknessCol.setMinWidth(150);
        WeaknessCol.setCellValueFactory(new PropertyValueFactory<>("Weakness"));
        WeaknessCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        WeaknessCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Person, String> t) -> {
                    ((Person) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())).setWeakness(t.getNewValue());
                });
        
        TableColumn<Person, String> endureCol = new TableColumn<>("Resistencia");
        endureCol.setMinWidth(150);
        endureCol.setCellValueFactory(new PropertyValueFactory<>("endure"));
        endureCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        endureCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Person, String> t) -> {
                    ((Person) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())).setEndure(t.getNewValue());
                });

        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol, WeaknessCol, endureCol);
        final TextField addFirstName = new TextField();
        addFirstName.setPromptText("Nombre");
        addFirstName.setMaxWidth(firstNameCol.getPrefWidth());

        final TextField addLastName = new TextField();
        addLastName.setMaxWidth(lastNameCol.getPrefWidth());
        addLastName.setPromptText("Especie");

        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(emailCol.getPrefWidth());
        addEmail.setPromptText("Elemento");

        final TextField addWeakness = new TextField();
        addWeakness.setMaxWidth(WeaknessCol.getPrefWidth());
        addWeakness.setPromptText("Debilidad");
        
        final TextField addEndure = new TextField();
        addEndure.setMaxWidth(endureCol.getPrefWidth());
        addEndure.setPromptText("Resistencia");

        final Button addButton = new Button("Gehitu");
        addButton.setOnAction((ActionEvent e) -> {
            Person p = new Person(
                    addFirstName.getText(),
                    addLastName.getText(),
                    addEmail.getText(),
                    addWeakness.getText(),
                    addEndure.getText());
            data.add(p);

            addFirstName.clear();
            addLastName.clear();
            addEmail.clear();
            addWeakness.clear();
            addEndure.clear();
        });

        final Button removeButton = new Button("Ezabatu");
        removeButton.setOnAction((ActionEvent e) -> {
            Person person = table.getSelectionModel().getSelectedItem();
            data.remove(person);
        });

        hb.getChildren().addAll(addFirstName, addLastName, addEmail, addWeakness, addEndure, addButton, removeButton);
        hb.setSpacing(3);
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
