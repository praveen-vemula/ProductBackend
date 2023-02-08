package com.example.SpringReact.service;

import com.example.SpringReact.domain.Book;
import com.example.SpringReact.domain.BookRepository;
import com.example.SpringReact.domain.ProductInfo;
import com.example.SpringReact.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public ProductInfo create(ProductInfo product){
        return productRepository.save(product);
    }

    /*
    public Book findBook(Long id){
        return bookRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("Check Id");
            }
        });
    }
    */
    @Transactional(readOnly = true)
    public ProductInfo findProduct(Long id){
        return productRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Check Id"));
    }

    @Transactional(readOnly = true)
    public List<ProductInfo> findAll(){
        return productRepository.findAll();
    }

    @Transactional
    public ProductInfo update(Long id, ProductInfo product){
        ProductInfo productEntity = productRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("check Id"));  //Persistence Context

        productEntity.setProdName(product.getProdName());
        productEntity.setUnitPrice(product.getUnitPrice());
        productEntity.setDesc(product.getDesc());

        return productEntity;
    }// When the transaction end, the persisted data to the database update the database (flush)

    @Transactional
    public String delete(Long id){
        productRepository.deleteById(id);
        return "ok";
    }

}
