package ziyad.com.springboot.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ziyad.com.springboot.entity.Product;
import ziyad.com.springboot.payload.ProductDto;
import ziyad.com.springboot.repository.ProductRepository;
import ziyad.com.springboot.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }
    //create product

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = mapToEntity(productDto);
        Product newProduct =productRepository.save(product);
        return mapToDto(newProduct);
    }


    //search product

    @Override
    public List<ProductDto> searchProducts(String query) {
        List<Product> products = productRepository.searchProducts(query);
        return products.stream().map(product-> mapToDto(product)).collect(Collectors.toList());
    }


    //modelmaper
    private ProductDto mapToDto(Product product){
        ProductDto productDto = modelMapper.map(product,ProductDto.class);
        return productDto;
    }
    private Product mapToEntity(ProductDto productDto){
        Product product = modelMapper.map(productDto,Product.class);
        return product;
    }
}
