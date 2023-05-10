package ru.biponline.demo.service;

import org.springframework.stereotype.Service;

import ru.biponline.demo.entity.OrdersEntity;
import ru.biponline.demo.repo.OrdersRepo;

@Service
public class OrdersService {
    private final OrdersRepo repo;
    public OrdersService(OrdersRepo repo) {
        this.repo = repo;
    }
    public void save(OrdersEntity orders) {repo.save(orders);}
    public void delete(Long id){repo.deleteById(id);}
    public Iterable<OrdersEntity> getAll(){return repo.findAll();}
    public Iterable<OrdersEntity> getName(String name){
        return repo.findByClients_name(name); }
}
