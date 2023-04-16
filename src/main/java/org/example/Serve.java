package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name="prods")

public class Serve extends ProdsAbstract {

    public Serve(String name, double price) {
       // this.type = ProductType.SERVE;
        this.name = name;
        this.price = price;
    }

    public Serve() {
    }
}
