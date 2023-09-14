package ru.netology.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.model.Customer;
import ru.netology.service.ProductService;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getCustomerProducts(@RequestParam("name") String name) {
        return service.getCustomerProducts(name);
    }

    @GetMapping("/customes")
    public List<Customer> getCustomes() {
        return service.getCustomes();
    }
}
