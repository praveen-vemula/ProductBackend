package com.example.SpringReact.repository;

import com.example.SpringReact.domain.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductInfo, Long> {

}
