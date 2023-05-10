package ru.biponline.demo.utils;

import ru.biponline.demo.entity.ProductsEntity;
import ru.biponline.demo.exception.ValidationExceptionProducts;

public class ProductsValidationUtils {
    public static void validationProducts(ProductsEntity data) throws ValidationExceptionProducts {
        String name = data.getName();
        if (name == null || name.isBlank()) {
            throw new ValidationExceptionProducts("Название пустое");
        } else if (name.length() < 3 || name.length() > 20) {
            throw new ValidationExceptionProducts("Название должно быть в диапозоне от 3 до 20");
        }
        String products = data.getProducts();
        if (products == null || products.isBlank()) {
            throw new ValidationExceptionProducts("Название товара пустое");
        } else if (products.length() < 3 || products.length() > 20) {
            throw new ValidationExceptionProducts("Название товара должно быть в диапозоне от 3 до 20");
        }
        if (!products.matches("^[A-ЯЁ][а-яё]+$")) {
            throw new ValidationExceptionProducts("Название товара должно начинаться с заглавной буквы и на русском языке");
        }
        String category = data.getCategory();
        if (category == null || category.isBlank()) {
            throw new ValidationExceptionProducts("Название категории пустое");
        } else if (category.length() < 3 || category.length() > 20) {
            throw new ValidationExceptionProducts("Название категории должно быть в диапозоне от 3 до 20");
        }
        if (!category.matches("^[A-ЯЁ][а-яё]+$")) {
            throw new ValidationExceptionProducts("Название категории должно начинаться с заглавной буквы и на русском языке");
        }

        String material = data.getMaterial();
        if (material == null || material.isBlank()) {
            throw new ValidationExceptionProducts("Название материала пустое");
        } else if (material.length() < 3 || material.length() > 20) {
            throw new ValidationExceptionProducts("Название материала должно быть в диапозоне от 3 до 20");
        }
        if (!material.matches("^[A-ЯЁ][а-яё]+$")) {
            throw new ValidationExceptionProducts("Название материала должно начинаться с заглавной буквы и на русском языке");
        }
        int qanitity = data.getQanitity();

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
