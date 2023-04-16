package org.example.repositories;

import org.example.Goods;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends ProductRepository<Goods> {
}
