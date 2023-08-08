package com.multidb.demo.postgresql.repo;

import com.multidb.demo.postgresql.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productrepo extends JpaRepository<Product, Integer> {
    Product findByName(String name) ;
}
