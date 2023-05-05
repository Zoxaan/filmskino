package ru.biponline.demo.repo;

import org.springframework.data.repository.CrudRepository;
import ru.biponline.demo.entity.ClientsEntity;

public interface ClientsRepo extends CrudRepository<ClientsEntity, Long> {
}