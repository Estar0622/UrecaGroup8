package com.example.UrecaGroup8.service;

import com.example.UrecaGroup8.domain.Product;  // 올바른 경로로 수정
import com.example.UrecaGroup8.domain.dto.ProductDto;

import java.util.List;

public interface ProductService {
    void saveProduct(ProductDto productDto);
    List<Product> getAllProducts();
}
