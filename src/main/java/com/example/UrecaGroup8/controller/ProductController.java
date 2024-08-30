package com.example.UrecaGroup8.controller;

import com.example.UrecaGroup8.domain.Product;
import com.example.UrecaGroup8.domain.dto.ProductDto;
import com.example.UrecaGroup8.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/add")
    public ModelAndView showAddProductForm() {
        ModelAndView mav = new ModelAndView("addProduct");
        mav.addObject("productDto", new ProductDto()); // 빈 ProductDto 객체를 모델에 추가
        return mav;
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("productDto") ProductDto productDto) {
        productService.saveProduct(productDto); // DTO를 사용하여 제품 저장
        return "redirect:/products"; // 상품 목록 페이지로 리다이렉트
    }

    @GetMapping
    public ModelAndView getAllProducts() {
        List<Product> products = productService.getAllProducts();
        ModelAndView mav = new ModelAndView("productsList"); // productsList.html 뷰 반환
        mav.addObject("products", products);
        return mav;
    }
}
