package com.Threeball.OnlineShop.controller;

import com.Threeball.OnlineShop.entities.Products;
import com.Threeball.OnlineShop.model.requestDTO.ProductsDTO;
import com.Threeball.OnlineShop.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Product")
public class ProductsController {
    @Autowired
    private ProductsService productsService;
    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody ProductsDTO productsDTO){
        productsService.create(productsDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<?>GetAll(){
        return ResponseEntity.ok(productsService.ToSeeAllProducts());
    }
    @GetMapping("/FindByName")
    public ResponseEntity<?>GetByName(@RequestParam String name){
        List<Products> result = productsService.FindByName(name);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?>DeleteProduct(@RequestParam int id){
        productsService.delete(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/FindById")
    public ResponseEntity<?>GetById(@RequestParam int id){
        return ResponseEntity.ok(productsService.getById(id));
    }

}
