package ru.netology.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import ru.netology.model.Customer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    @PersistenceContext
    private final EntityManager entityManager;
    private final String queryStr;

    public ProductRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.queryStr = read("fetch-product.sql");
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getCustomerProducts(String customerName) {
        List<String> products = (List<String>) entityManager.createNativeQuery(queryStr, String.class)
                .setParameter("paramName", customerName)
                .getResultList();
        //products.forEach(System.out::println);
        return products;
    }

    public List<Customer> getCustomes() {
        String q = "select * from jdata36.customers";
        List<Customer> customers = entityManager.createNativeQuery(q, Customer.class).getResultList();
        //customers.forEach(System.out::println);
        return customers;
    }
}
