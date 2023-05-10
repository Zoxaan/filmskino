package ru.biponline.demo.utils;

import ru.biponline.demo.entity.OrdersEntity;
import ru.biponline.demo.exception.ValidationExceptionOrders;

public class OrdersValidationUtils {
    public static void ordersValidationUtils(OrdersEntity orders) throws ValidationExceptionOrders {
        String title = orders.getOrders();
        if (title == null || title.isBlank()) {
            throw new ValidationExceptionOrders("Поле название заказа не должно быть пустым");
        }
        if (orders.getClients() == null) {
            throw new ValidationExceptionOrders("нужно выбрать клиента");
        }
        if (orders.getProducts() == null) {
            throw new ValidationExceptionOrders("нужно выбрать товар");
        }


    }
}
//    String name = data.getName();
//        if (name == null||name.isBlank()) {
//                throw new ValidationExceptionClients("Имя клиента не может быть пустым");
//                } else if (name.length() < 3 || name.length() > 20){
//        throw new ValidationExceptionClients("Имя должно быть в диапозоне от 3 до 20");
//
//        }
//        if (!name.matches("^[A-ЯЁ][а-яё]+$")){
//        throw new ValidationExceptionClients("Имя должно начинаться с заглавной буквы и на русском языке");
//        }
//
//        String lastname = data.getLastname();
//        if (!lastname.matches("^[A-ЯЁ][а-яё]+$")){
//        throw new ValidationExceptionClients("Фамилия должна начинаться с заглавной буквы и на русском языке");
//        }
//
//        String surname = data.getSurname();
//        if (!surname.matches("^[A-ЯЁ][а-яё]+$")) {
//        throw new ValidationExceptionClients("Отчество должно начинаться с заглавной буквы и на русском языке");
//        }
//        }