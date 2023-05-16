package com.example.clients.controller;

import com.example.clients.entity.ClientsEntity;
import com.example.clients.entity.OrdersEntity;
import com.example.clients.entity.ProductsEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.clients.controller.HelloController.clientsData;
import static com.example.clients.controller.HelloController.productsData;

public class EditOrdersController {
//    public class EditBookController {
//        @FXML
//        private TextField orderName_field;
//        @FXML
//        private ComboBox<OrdersEntity> ordersClient_field;
//        @FXML
//        private ComboBox<ProductsEntity> ordersProducts_field;
//        @FXML
//        private TextField bookYear_field;
//        @FXML
//        private TextField bookChapter_field;
//
//        private Stage editOrdersStage;
//        private OrdersEntity order;
//        private int orderID;
//        private boolean okClicked = false;
//        private ObservableList<ClientsEntity> clientsOrdersData = FXCollections.observableArrayList();
//        private ObservableList<ProductsEntity> productsOrdersData = FXCollections.observableArrayList();
//
//        public void setDialogStage (Stage dialogStage) {this.editOrdersStage = dialogStage;}
//
//        @FXML
//        private void handleCancel() {editOrdersStage.close();}
//
//        @FXML
//        private void handleOk() throws IOException {
//            if (isInputValid()) {
//                order.setOrders(orderName_field.getText());
//                order.setClients(ordersClient_field.getValue());
//                order.setProducts(ordersProducts_field.getValue());
//
//
//                okClicked = true;
//                editOrdersStage.close();
//                orderData.set(orderID, order);
//                updateOrders(order);
//            }
//        }
//        private void updateMap(){
//            clientsOrdersData.addAll(clientsData);
//            productsOrdersData.addAll(productsData);
//        }
//        @FXML
//        void initialize() throws Exception {
//            if (clientsOrdersData.size() != clientsData.size() || productsOrdersData.size() != productsData.size()){
//                updateMap();
//            }
//            updateComboBox();
//        }
//
//        private void updateComboBox() throws Exception {
//            ordersClient_field.getItems().addAll(clientsOrdersData);
//            ordersProducts_field.getItems().addAll(productsOrdersData);
//        }
//        private boolean isInputValid() {
//
//            String errorMessage = "";
//            if (!bookName_field.getText().matches("[\\sA-ZА-Яa-za-я]{3,20}") ||bookName_field.getText() == null || bookName_field.getText().length() == 0) errorMessage += "Некорректное значение названия книги!\n";
//            if (bookAuthor_field.getValue() == null || bookAuthor_field.getValue().hashCode() == 0) errorMessage += "Не обнаружен автор книги!\n";
//            if (bookPublisher_field.getValue() == null || bookPublisher_field.getValue().hashCode() == 0) errorMessage += "Не обнаружено издание книги!\n";
//            if (bookYear_field.getText() == null || bookYear_field.getText().length() == 0) errorMessage += "Не обнаружен год выпуска книги!\n";
//            else {
//                try {
//                    Integer.parseInt(bookYear_field.getText());
//                } catch (NumberFormatException e) {
//                    errorMessage += "Некорректное значение года выпуски книги (Должен быть целочисленным)!\n";
//                }
//            }
//            if (!bookChapter_field.getText().matches("[\\sA-ZА-Яa-za-я]{3,20}") || bookChapter_field.getText() == null || bookChapter_field.getText().length() == 0) errorMessage += "Некорректное значение жанра книги!\n";
//            if (!bookYear_field.getText().matches("[\\d0-9]{4}") || bookYear_field.getText() == null) errorMessage += "Год выпуска введен некорректно! \n";
//            if (errorMessage.length() == 0) return true;
//            else {
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.initOwner(editBookStage);
//                alert.setTitle("Oops!");
//                alert.setHeaderText("Пожалуйста, укажите корректные значения текстовых полей");
//                alert.setContentText(errorMessage);
//
//                alert.showAndWait();
//                return false;
//            }
//        }
//        public void setLabels(BookEntity bookIn, int book_id) {
//            this.book = bookIn;
//            this.bookID = book_id;
//
//            bookName_field.setText(book.getTitle());
//            bookAuthor_field.setValue(book.getAuthor());
//            bookPublisher_field.setValue(book.getPublishing());
//            bookYear_field.setText(String.valueOf(book.getYear()));
//            bookChapter_field.setText(book.getKind());
//        }
//        public boolean isOkClicked(){return okClicked;}
}
