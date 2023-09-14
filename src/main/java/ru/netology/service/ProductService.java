package ru.netology.service;

import org.springframework.stereotype.Service;
import ru.netology.model.Customer;
import ru.netology.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<String> getProducts(String name) {
        return repository.getProducts(name);
    }

    public List<Customer> getCustomes() {
        return repository.getCustomes();
    }
}
