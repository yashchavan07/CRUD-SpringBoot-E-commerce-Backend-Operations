package com.example.FlipKartLite.Repository;

import  org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FlipKartLite.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}