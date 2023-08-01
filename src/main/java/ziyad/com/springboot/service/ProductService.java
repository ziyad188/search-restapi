package ziyad.com.springboot.service;

import ziyad.com.springboot.entity.Product;
import ziyad.com.springboot.payload.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> searchProducts(String query);
    ProductDto createProduct(ProductDto productDto);
}
