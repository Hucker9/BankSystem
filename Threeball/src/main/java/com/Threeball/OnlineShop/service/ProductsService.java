package com.Threeball.OnlineShop.service;

import com.Threeball.OnlineShop.entities.Products;
import com.Threeball.OnlineShop.model.requestDTO.ProductsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductsService {
    void create(ProductsDTO productsDTO);
    List<?>ToSeeAllProducts();
    List<Products>FindByName(String name);
    void delete(int id);
    Products getById(int id);
}
