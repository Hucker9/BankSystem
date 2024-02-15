package com.Threeball.OnlineShop.service.impl;

import com.Threeball.OnlineShop.entities.Products;
import com.Threeball.OnlineShop.model.requestDTO.ProductsDTO;
import com.Threeball.OnlineShop.model.responseDTO.ProductResponseDTO;
import com.Threeball.OnlineShop.repository.ProductRepository;
import com.Threeball.OnlineShop.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<?> ToSeeAllProducts() {
       List<Products>products = productRepository.findAll();
       List<ProductResponseDTO>productResponseDTOS = new ArrayList<>();
        for (Products product :products) {
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setTitle(product.getTitle());
            productResponseDTO.setDescription(product.getDescription());
            productResponseDTO.setPrice(product.getPrice());
            productResponseDTOS.add(productResponseDTO);
        }
        return productResponseDTOS;
    }

    @Override
    public List<Products> FindByName(String name) {
        List<Products>products = productRepository.searchProduct(name);
        return products;
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Products getById(int id) {
        Optional<Products> byId = productRepository.findById(id);
        return byId.get();
    }

    public void create(ProductsDTO productsDto) {
          Products products  = new Products();
          products.setIdproducts(0);
          products.setTitle(productsDto.getName());
          products.setDescription(productsDto.getDescription());
          products.setPrice(productsDto.getPrice());
          productRepository.save(products);
    }
}
