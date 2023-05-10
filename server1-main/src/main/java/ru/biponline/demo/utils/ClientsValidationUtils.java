package ru.biponline.demo.utils;

import ru.biponline.demo.entity.ClientsEntity;
import ru.biponline.demo.exception.ValidationExceptionClients;

public class ClientsValidationUtils
{
    public static void validationClients(ClientsEntity data)throws ValidationExceptionClients
    {
        String name = data.getName();
        if (name == null||name.isBlank())
        {
            throw new ValidationExceptionClients("Имя пустое");
        }
        String lastname = data.getLastname();
        if (lastname == null||lastname.isBlank())
        {
            throw new ValidationExceptionClients("Фамилия");
        }
        String surname = data.getSurname();
        if (surname == null||surname.isBlank())
        {
            throw new ValidationExceptionClients("Отчество");
        }
    }
}