package ru.biponline.demo.service;

import org.springframework.stereotype.Service;

import ru.biponline.demo.entity.OrdersEntity;
import ru.biponline.demo.entity.ProductsEntity;
import ru.biponline.demo.repo.OrdersRepo;

import java.util.Date;

@Service
public class OrdersService {
    private final OrdersRepo repo;
    public OrdersService(OrdersRepo repo) {
        this.repo = repo;
    }
    public Iterable<OrdersEntity> findByDatetime (String datetime) { return  repo.findByDatetime(datetime); }
    public void save(OrdersEntity orders) {repo.save(orders);}
    public void delete(Long id){repo.deleteById(id);}
    public Iterable<OrdersEntity> getAll(){return repo.findAll();}
    public Iterable<OrdersEntity> getName(String name){
        return repo.findByClients_name(name); }
}
