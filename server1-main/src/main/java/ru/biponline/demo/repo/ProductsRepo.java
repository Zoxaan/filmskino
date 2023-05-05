package ru.biponline.demo.repo;

import org.springframework.data.repository.CrudRepository;
import ru.biponline.demo.entity.ProductsEntity;

public interface ProductsRepo extends CrudRepository<ProductsEntity, Long> {
}