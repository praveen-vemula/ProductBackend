package com.example.SpringReact.controller;

import com.example.SpringReact.domain.Book;
import com.example.SpringReact.domain.ProductInfo;
import com.example.SpringReact.service.BookService;
import com.example.SpringReact.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;


    @CrossOrigin
    @PostMapping("/product")
    public ResponseEntity<?> save(@RequestBody ProductInfo product){

        System.out.println("ProductName" + product.getProdName());
        System.out.println("UnitPrice" + product.getUnitPrice());
        System.out.println("Description" + product.getDesc());
        return new ResponseEntity<>(productService.create(product), HttpStatus.CREATED);

    }


    @CrossOrigin
    @GetMapping("/product")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/product/{id}")
    public ResponseEntity<?> findAll(@PathVariable Long id){

        return new ResponseEntity<>(productService.findProduct(id), HttpStatus.OK);
    }
    @CrossOrigin
    @PutMapping("/product/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductInfo product){
        return new ResponseEntity<>(productService.update(id, product), HttpStatus.OK);
    }
    @CrossOrigin
    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(productService.delete(id), HttpStatus.OK);
    }





}
