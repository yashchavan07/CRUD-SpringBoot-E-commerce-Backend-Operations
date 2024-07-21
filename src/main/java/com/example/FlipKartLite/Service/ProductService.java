package com.example.FlipKartLite.Service;
import com.example.FlipKartLite.Product;

import java.util.List;

public interface ProductService {
	Product createProduct(Product product);

	Product getProductById(Long productId);

    List<Product> getAllProduct();

    Product updateProduct(Product product);

    void deleteProduct(Long productId);
}