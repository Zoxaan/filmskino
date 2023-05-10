package ru.biponline.demo.repo;

import org.springframework.data.repository.CrudRepository;
import ru.biponline.demo.entity.ProductsEntity;

public interface ProductsRepo extends CrudRepository<ProductsEntity, Long> {
    Iterable<ProductsEntity> findByCategory (String category);
    Iterable<ProductsEntity> findByName (String name);
    Iterable<ProductsEntity> findByMaterial (String material);
    Iterable<ProductsEntity> findByQanitity (int qanitity);
}