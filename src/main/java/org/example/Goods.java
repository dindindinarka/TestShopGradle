package org.example;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name="prods")

public class Goods extends ProdsAbstract {

    private int remainder;
    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
        this.remainder = 1;
        //this.productType = ProductType.GOOD.name();
    }

    public Goods() {
    }

    public int getRemainder() {
        return remainder;
    }

    public void setRemainder(int remainder) {
        this.remainder = remainder;
    }
}
