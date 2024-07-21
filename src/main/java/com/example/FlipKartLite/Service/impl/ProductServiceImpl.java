package com.example.FlipKartLite.Service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.FlipKartLite.Product;
import com.example.FlipKartLite.Repository.ProductRepository;
import com.example.FlipKartLite.Service.ProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class ProductServiceImpl implements ProductService {
	
	private ProductRepository ProductRepository;

	@Override
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		
		return ProductRepository.save(product);
	}

	@Override
	public Product getProductById(Long productId) {
		// TODO Auto-generated method stub
		  Optional<Product> optionalProduct = ProductRepository.findById(productId);
	        return optionalProduct.get();
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return ProductRepository.findAll();
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		 Product existingProduct = ProductRepository.findById(product.getProductId()).get();
		 	existingProduct.setGroupName(product.getGroupName());
	        existingProduct.setCategory(product.getCategory());
	        existingProduct.setProductName(product.getProductName());
	        existingProduct.setPrice(product.getPrice());
	        Product updatedUser = ProductRepository.save(existingProduct);
	        return updatedUser;
	}

	@Override
	public void deleteProduct(Long productId) {
		// TODO Auto-generated method stub
		  ProductRepository.deleteById(productId);

	}

}
