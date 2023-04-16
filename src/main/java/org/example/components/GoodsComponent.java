package org.example.components;

import org.example.Goods;
import org.example.Serve;
import org.example.repositories.GoodsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GoodsComponent {
    private final GoodsRepository goodsRepository;

    public GoodsComponent(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }


    public Goods addNewGood(String name, double price) {
        var product = goodsRepository.findByName(name);
        if (product != null) {
            if (!(product instanceof Goods)) {
                throw new IllegalArgumentException("Это имя уже занято, попробуй другое");
            }
            Goods good = (Goods) product;
            good.setRemainder(good.getRemainder() + 1);
            good.setPrice(price);
            goodsRepository.save(good);
            return good;

        }
        var good = new Goods(name, price);
        goodsRepository.save(good);
        return good;
    }

    public List<Goods> getListOfProduct() {
        return goodsRepository.findAll();
    }


    public Goods getProductByName(String productName) {
        var product = goodsRepository.findByName(productName);
        if (product != null) {
            return (Goods) product;
        }
        throw new NoSuchElementException(String.format("Продукт с именем '%s' не существует", productName));

    }
}
