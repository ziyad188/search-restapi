package ziyad.com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ziyad.com.springboot.entity.Product;
import ziyad.com.springboot.payload.ProductDto;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    //here we are going to create a query method so it will give the products when search
    //here :query is used to pass the parameter so here it work like filter the list of products by name or description
    @Query("SELECT p FROM Product p WHERE "+
            "p.name LIKE CONCAT('%',:query,'%')" +
            "Or p.description LIKE CONCAT('%',:query,'%')")
    List<Product> searchProducts(String query);


    //METHOD 2


    //this is how we can implement using native sql query
//    @Query(value = "SELECT * FROM products p WHERE "+
//            "p.name LIKE CONCAT('%',:query,'%')" +
//            "Or p.description LIKE CONCAT('%',:query,'%')",nativeQuery = true)
//    List<Product> searchProductsSQL(String query);

}
