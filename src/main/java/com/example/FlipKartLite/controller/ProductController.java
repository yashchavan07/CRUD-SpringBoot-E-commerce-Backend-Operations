package com.example.FlipKartLite.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FlipKartLite.Product;
import com.example.FlipKartLite.Service.ProductService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("api/Products")
public class ProductController {
	private ProductService productService; 
	// build create User REST API
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
	Product savedProduct = productService.createProduct(product);
	return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}
	@GetMapping("{id}")
	  public ResponseEntity<Product>erById(@PathVariable("id") Long userId){
        Product product = productService.getProductById(userId);
        return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@GetMapping
    public ResponseEntity<List<Product>> getAllUsers(){
        List<Product> products = productService.getAllProduct();
        return new ResponseEntity<>(products, HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Long ProductId,
            @RequestBody Product product){
//product.setProductId(ProductId);
Product updatedProduct = productService.updateProduct(product);
return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	}
	   @DeleteMapping("{id}")
	    public ResponseEntity<String> deleteUser(@PathVariable("id") Long productId){
	        productService.deleteProduct(productId);
	        return new ResponseEntity<>("Product successfully deleted!", HttpStatus.OK);
	    }
	   
}
	
	

        

