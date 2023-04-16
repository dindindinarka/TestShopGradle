package org.example.components;

import org.example.Goods;
import org.example.Serve;
import org.example.repositories.ServRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ServeComponent {


    private final ServRepository servRepository;

    public ServeComponent(ServRepository servRepository) {
        this.servRepository = servRepository;
    }


    public Serve addNewServe(String name, double price) {
        var product = servRepository.findByName(name);
        if (product != null) {
            throw new IllegalStateException(String.format("Product with %s already exists!", name));
        }
        var serve = new Serve(name, price);
        servRepository.save(serve);
        return serve;
    }
    public List<Serve> getListOfProduct() {
        return servRepository.findAll();
    }

    public Serve getProductByName(String productName) {
        var product = servRepository.findByName(productName);
        if (product != null) {
            return (Serve) product;
        }
        throw new NoSuchElementException(String.format("Продукт с именем '%s' не существует", productName));

    }
}
