package ru.biponline.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.biponline.demo.entity.ClientsEntity;
import ru.biponline.demo.response.BaseResponse;
import ru.biponline.demo.response.ClientsListResponse;
import ru.biponline.demo.service.ClientsService;
import ru.biponline.demo.utils.ClientsValidationUtils;

import static ru.biponline.demo.utils.ClientsValidationUtils.validationClients;

@RestController
@RequestMapping("api/v1/clients")
public class ClientsController {
    private final ClientsService service;
    public ClientsController(ClientsService service) {this.service = service;}

    @PostMapping("/add")
    public ResponseEntity<BaseResponse> add(@RequestBody ClientsEntity data){
        try {
            ClientsValidationUtils.validationClients(data);

            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true,"клиент добавлен"));
        } catch (Exception e){
            return ResponseEntity. badRequest().body(new BaseResponse(false,e.getMessage()));
        }
    }
    @PostMapping("/update")
    public ResponseEntity<BaseResponse> update(@RequestBody ClientsEntity data){
        try {
            validationClients(data);
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "клиент изминен"));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity <BaseResponse> delete(@RequestParam Long id){
        try {
            service.delete(id);

            return ResponseEntity.ok(new BaseResponse(true, "клиент успешно удален"));
        } catch (Exception e) {
            return ResponseEntity. badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll(){return ResponseEntity.ok(new ClientsListResponse(service.getAll())); }





}