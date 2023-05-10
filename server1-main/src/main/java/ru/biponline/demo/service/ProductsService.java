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
    public void save(ProductsEntity products) {repo.save(products);}
    public void delete(Long id){repo.deleteById(id);}
    public Iterable<ProductsEntity> getAll(){return repo.findAll();}
    public Iterable<ProductsEntity> findByName (String  name) { return  repo.findByName(name); }
    public Iterable<ProductsEntity> findByCategory (String  category) { return  repo.findByCategory(category); }
    public Iterable<ProductsEntity> findByMaterial (String  material) { return  repo.findByMaterial(material); }
    public Iterable<ProductsEntity> findByQanitity (int  qanitity) { return  repo.findByQanitity(qanitity); }
}
