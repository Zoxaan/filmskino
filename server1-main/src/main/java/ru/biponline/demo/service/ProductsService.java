package ru.biponline.demo.service;

import org.springframework.stereotype.Service;
import ru.biponline.demo.entity.ProductsEntity;
import ru.biponline.demo.repo.ProductsRepo;

@Service
public class ProductsService {
    private final ProductsRepo repo;
    public ProductsService(ProductsRepo repo) {
        this.repo = repo;
    }
    public void save(ProductsEntity book) {repo.save(book);}
    public void delete(Long id){repo.deleteById(id);}
    public Iterable<ProductsEntity> getAll(){return repo.findAll();}
}
