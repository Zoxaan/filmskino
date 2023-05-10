package ru.biponline.demo.repo;

import org.springframework.data.repository.CrudRepository;
import ru.biponline.demo.entity.OrdersEntity;

public interface OrdersRepo extends CrudRepository<OrdersEntity, Long> {
    Iterable<OrdersEntity> findByClients_name(String name);

}
