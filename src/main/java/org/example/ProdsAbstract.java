package org.example;

import lombok.Data;

import javax.persistence.*;


@Data
@MappedSuperclass

abstract public class ProdsAbstract {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    protected String name;
    @Column(name="price")
    protected double price;
    @Column(name="remainder")
    protected int remainder;

   /* @Column(name="product_type")
    protected String productType;*/


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRemainder() {
        return remainder;
    }

    public void setRemainder(int remainder) {
        this.remainder = remainder;
    }


}
