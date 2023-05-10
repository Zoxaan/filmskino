package ru.biponline.demo.utils;

import ru.biponline.demo.entity.OrdersEntity;
import ru.biponline.demo.exception.ValidationExceptionOrders;

public class OrdersValidationUtils {
    public static void ordersValidationUtils(OrdersEntity orders) throws ValidationExceptionOrders {
        String title = orders.getOrders();
        if (title == null || title.isBlank()) {
            throw new ValidationExceptionOrders("Поле название не должно быть пустым");
        }
        if (orders.getClients() == null) {
            throw new ValidationExceptionOrders("нужно выбрать клиента");
        }
        if (orders.getProducts() == null) {
            throw new ValidationExceptionOrders("нужно выбрать товар");
        }


    }
}