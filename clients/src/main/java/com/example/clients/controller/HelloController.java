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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class HelloController {
    public static String api = "http://localhost:2825/api/v1/";
    public static ObservableList<ClientsEntity> clientsData = FXCollections.observableArrayList();
    public static ObservableList<ProductsEntity> productsData = FXCollections.observableArrayList();
    public static ObservableList<OrdersEntity> ordersData = FXCollections.observableArrayList();
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
    public TableView<OrdersEntity> tableOrders;
    @FXML
    private TableColumn<OrdersEntity, String> ordersName;
    @FXML
    private TableColumn<OrdersEntity, String> ordersNameClient;
    @FXML
    private TableColumn<OrdersEntity, String> orderData;

    @FXML
    private void initialize() throws Exception {
        getDataClients();
        getDataProducts();
        getDataOrders();
        updateTableOrders();
        updateTableClients();
        updateTableProducts();
    }
    private void updateTableClients() throws Exception {
        clientsName.setCellValueFactory(new PropertyValueFactory<ClientsEntity, String>("name"));
        clientsSurname.setCellValueFactory(new PropertyValueFactory<ClientsEntity, String>("surname"));
        clientsLastname.setCellValueFactory(new PropertyValueFactory<ClientsEntity, String>("lastname"));
        tableClients.setItems(clientsData);
    }
    private void updateTableProducts() throws Exception {
        productsName.setCellValueFactory(new PropertyValueFactory<ProductsEntity, String>("name"));
        productsProducts.setCellValueFactory(new PropertyValueFactory<ProductsEntity, String>("products"));
        productsCategory.setCellValueFactory(new PropertyValueFactory<ProductsEntity, String>("category"));
        productsMaterial.setCellValueFactory(new PropertyValueFactory<ProductsEntity, String>("material"));
        productsQanitity.setCellValueFactory(new PropertyValueFactory<ProductsEntity, String>("qanitity"));
        tableProducts.setItems(productsData);
    }
    private void updateTableOrders() throws Exception {
        ordersName.setCellValueFactory(new PropertyValueFactory<OrdersEntity, String>("name"));
        ordersNameClient.setCellValueFactory(new PropertyValueFactory<OrdersEntity, String>("NameClient"));
        orderData.setCellValueFactory(new PropertyValueFactory<OrdersEntity, String>("DataOrder"));
        tableOrders.setItems(ordersData);
    }
    @FXML
    private void click_newClient() throws Exception {

        ClientsEntity tempClients = new ClientsEntity();
        clientsData.add(tempClients);
        HelloApplication.showClientsAddDialog(tempClients, clientsData.size()-1);
        tableClients.getItems().clear();
        getDataClients();
    }
    @FXML
    private void click_newProducts() throws Exception {

        ProductsEntity tempProducts = new ProductsEntity();
        productsData.add(tempProducts);
        HelloApplication.showProductsAddDialog(tempProducts, productsData.size()-1);
        tableProducts.getItems().clear();
        getDataProducts();
    }
    @FXML
    private void click_editClients() {
        ClientsEntity selectedClient = tableClients.getSelectionModel().getSelectedItem();
        if (selectedClient != null)
            HelloApplication.showClientsEditDialog(selectedClient, clientsData.indexOf(selectedClient));
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ничего не выбрано");
            alert.setHeaderText("Отсутсвует выбраный издатель!");
            alert.setContentText("Пожалуйста, выберите издателя из таблицы.");
            alert.showAndWait();
        }
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
    public static void getDataProducts() throws Exception {
        String res = http.get(api,"products/all");
        System.out.println(res);

        JsonObject base = gson.fromJson(res, JsonObject.class);
        JsonArray dataArr = base.getAsJsonArray("data");

        for (int i = 0; i < dataArr.size(); i++) {
            ProductsEntity newProducts = gson.fromJson(dataArr.get(i).toString(), ProductsEntity.class);
            productsData.add(newProducts);
        }
    }
    public static void getDataOrders() throws Exception {
        String res = http.get(api,"orders/all");
        System.out.println(res);

        JsonObject base = gson.fromJson(res, JsonObject.class);
        JsonArray dataArr = base.getAsJsonArray("data");

        for (int i = 0; i < dataArr.size(); i++) {
            OrdersEntity newOrders = gson.fromJson(dataArr.get(i).toString(), OrdersEntity.class);
            ordersData.add(newOrders);
        }
    }
    public static void updateClients(ClientsEntity clients) throws IOException {
        http.post(api+"clients/update", gson.toJson(clients).toString());
    }
}