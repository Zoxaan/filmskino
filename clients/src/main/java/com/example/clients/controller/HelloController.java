package com.example.clients.controller;

import com.example.clients.HelloApplication;
import com.example.clients.entity.ClientsEntity;
import com.example.clients.entity.OrdersEntity;
import com.example.clients.entity.ProductsEntity;
import com.example.clients.utils.HTTPUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    public static String api = "http://localhost:2825/api/v1/";
    public static ObservableList<ClientsEntity> clientsData = FXCollections.observableArrayList();
    static HTTPUtils http = new HTTPUtils();
    static Gson gson = new Gson();

    @FXML
    public TableView<ClientsEntity> tableClients;
    @FXML
    private TableColumn<ClientsEntity, String> clientsName;
    @FXML
    private TableColumn<ClientsEntity, String> clientsLastname;
    @FXML
    private TableColumn<ClientsEntity, String> clientsSurname;
    @FXML
    public TableView<ProductsEntity> tableProducts;
    @FXML
    private TableColumn<ProductsEntity, String> productsName;
    @FXML
    private TableColumn<ProductsEntity, String> productsProducts;
    @FXML
    private TableColumn<ProductsEntity, String> productsCategory;
    @FXML
    private TableColumn<ProductsEntity, String> productsMaterial;
    @FXML
    private TableColumn<ProductsEntity, String> productsQanitity;
    @FXML
    private void initialize() throws Exception {
        getDataClients();
        updateTableClients();
    }
    private void updateTableClients() throws Exception {
        clientsName.setCellValueFactory(new PropertyValueFactory<ClientsEntity, String>("name"));
        clientsSurname.setCellValueFactory(new PropertyValueFactory<ClientsEntity, String>("surname"));
        clientsLastname.setCellValueFactory(new PropertyValueFactory<ClientsEntity, String>("lastname"));
        tableClients.setItems(clientsData);
    }
    @FXML
    private void click_newClient() throws Exception {

        ClientsEntity tempClient = new ClientsEntity();
        clientsData.add(tempClient);
        HelloApplication.showClientsAddDialog(tempClient, clientsData.size()-1);
        tableClients.getItems().clear();
        getDataClients();
    }
    public static void getDataClients() throws Exception {
        String res = http.get(api,"clients/all");
        System.out.println(res);

        JsonObject base = gson.fromJson(res, JsonObject.class);
        JsonArray dataArr = base.getAsJsonArray("data");

        for (int i = 0; i < dataArr.size(); i++) {
            ClientsEntity newClient = gson.fromJson(dataArr.get(i).toString(), ClientsEntity.class);
            clientsData.add(newClient);
        }
    }
}