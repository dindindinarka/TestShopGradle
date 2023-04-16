package org.example.repositories;

import org.example.ProdsAbstract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface ProductRepository <T extends ProdsAbstract> extends JpaRepository<T, Long> {
    ProdsAbstract findByName(String name);
}
