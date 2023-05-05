package ru.biponline.demo.utils;

import ru.biponline.demo.entity.ProductsEntity;
import ru.biponline.demo.exception.ValidationExceptionProducts;

public class ProductsValidationUtils
{
    public static void validationProducts(ProductsEntity data)throws ValidationExceptionProducts
    {
        String title = data.getProducts();
        if (title == null||title.isBlank())
        {
            throw new ValidationExceptionProducts("Название пустое");
        }
        String material = data.getMaterial();
        if (material == null||material.isBlank())
        {
            throw new ValidationExceptionProducts("издательство адрес");
        }
    }
}
