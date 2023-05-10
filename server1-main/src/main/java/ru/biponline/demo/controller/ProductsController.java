package ru.biponline.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.biponline.demo.entity.ProductsEntity;
import ru.biponline.demo.response.BaseResponse;
import ru.biponline.demo.response.ProductsListResponse;
import ru.biponline.demo.service.ProductsService;

import static ru.biponline.demo.utils.ProductsValidationUtils.validationProducts;

@RestController
@RequestMapping("api/v1/products")
public class ProductsController {

    private final ProductsService service;
    public ProductsController(ProductsService service) {this.service = service;}

    @PostMapping("/add")
    public ResponseEntity<BaseResponse> add(@RequestBody ProductsEntity data){
        try {
            validationProducts(data);
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "Товар добавлен") );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

    @PostMapping("/update")
    public ResponseEntity<BaseResponse> update(@RequestBody ProductsEntity data){
        try {
            validationProducts(data);
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "Товар изминен"));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity <BaseResponse> delete(@RequestParam Long id){
        try {
            service.delete(id);
            return ResponseEntity.ok(new BaseResponse(true, "Товар успешно удален"));
        } catch (Exception e) {
            return ResponseEntity. badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll(){return ResponseEntity.ok(new ProductsListResponse(service.getAll())); }

    @GetMapping("/name")
    public ResponseEntity<BaseResponse> findByName(@RequestParam String name) {
        return ResponseEntity.ok(new ProductsListResponse(service.findByName(name)));
    }
    @GetMapping("/category")
    public ResponseEntity<BaseResponse> findByCategory(@RequestParam String category) {
        return ResponseEntity.ok(new ProductsListResponse(service.findByCategory(category)));
    }
    @GetMapping("/material")
    public ResponseEntity<BaseResponse> findByMaterial(@RequestParam String material) {
        return ResponseEntity.ok(new ProductsListResponse(service.findByMaterial(material)));
    }
    @GetMapping("/qanitity")
    public ResponseEntity<BaseResponse> findByQanitity(@RequestParam int qanitity) {
        return ResponseEntity.ok(new ProductsListResponse(service.findByQanitity(qanitity)));
    }

}
