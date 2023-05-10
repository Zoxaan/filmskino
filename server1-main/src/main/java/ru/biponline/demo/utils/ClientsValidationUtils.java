package ru.biponline.demo.utils;

import ru.biponline.demo.entity.ClientsEntity;
import ru.biponline.demo.exception.ValidationExceptionClients;

public class ClientsValidationUtils
{
    public static void validationClients(ClientsEntity data)throws ValidationExceptionClients
    {
        String name = data.getName();
        if (name == null||name.isBlank()) {
            throw new ValidationExceptionClients("Имя клиента не может быть пустым");
        } else if (name.length() < 3 || name.length() > 20){
            throw new ValidationExceptionClients("Имя должно быть в диапозоне от 3 до 20");

        }
        if (!name.matches("^[A-ЯЁ][а-яё]+$")){
            throw new ValidationExceptionClients("Имя должно начинаться с заглавной буквы и на русском языке");
        }

        String lastname = data.getLastname();
        if (!lastname.matches("^[A-ЯЁ][а-яё]+$")){
            throw new ValidationExceptionClients("Фамилия должна начинаться с заглавной буквы и на русском языке");
        }

        String surname = data.getSurname();
        if (!surname.matches("^[A-ЯЁ][а-яё]+$")) {
            throw new ValidationExceptionClients("Отчество должно начинаться с заглавной буквы и на русском языке");
        }
    }
}