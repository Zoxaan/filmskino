package com.example.clients.controller;

import com.example.clients.entity.ClientsEntity;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.clients.controller.HelloController.*;

public class AddClientsController {
    @FXML
    private TextField clientsLastname_field;
    @FXML
    private TextField clientsName_field;
    @FXML
    private TextField clientsSurname_field;
    private Stage editClientsStage;
    private ClientsEntity clients;
    private int clientsID;
    private boolean okClicked = false;

    public void setDialogStage (Stage dialogStage) {this.editClientsStage = dialogStage;}
    @FXML
    private void handleCancel() {editClientsStage.close();}
    @FXML
    private void handleOk() throws IOException {
        if (isInputValid()) {
            clients.setLastname(clientsLastname_field.getText());
            clients.setName(clientsName_field.getText());
            clients.setSurname(clientsSurname_field.getText());

            okClicked = true;
            editClientsStage.close();
            clientsData.set(clientsID, clients);
            addClients(clients);

        }
    }
    public void setLabels(ClientsEntity clientsIn, int clients_id) {
        this.clients = clientsIn;
        this.clientsID = clients_id;

        clientsLastname_field.setText(clients.getLastname());
        clientsName_field.setText(clients.getName());
        clientsSurname_field.setText(clients.getSurname());
    }
    private boolean isInputValid() {
        String errorMessage = "";

        if (clientsLastname_field.getText() == null || clientsLastname_field.getText().length() == 0) errorMessage = "Не обнаружено отчество клиента!\n";
        if (clientsName_field.getText() == null || clientsName_field.getText().length() == 0) errorMessage = "Не обнаружено имя клиента!\n";
        if (clientsSurname_field.getText() == null || clientsSurname_field.getText().length() == 0) errorMessage = "Не обнаружена фамилия клиента!\n";

        if (errorMessage.length() == 0) return true;
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(editClientsStage);
            alert.setTitle("Ошибка заполнения");
            alert.setHeaderText("Пожалуйста, укажите корректные значения текстовых полей");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }
    public boolean isOkClicked(){return okClicked;}
    public static void addClients(ClientsEntity clients) throws IOException {
        System.out.println(clients.toString());
//        clients.setId(null);
        http.post(api+"clients/add", gson.toJson(clients).toString());
    }
}
