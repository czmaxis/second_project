package org.second.project;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Collection;

@CrossOrigin
@RestController
public class ProductController {

    ProductService productService;

    public ProductController()throws SQLException {
        productService = new ProductService();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleError(Exception e){
        return new ErrorResponse(e.getMessage(), LocalDateTime.now());
    }

    @GetMapping("/product")
    public Collection<Product> getAllProducts() throws SQLException{
        return ProductService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product loadProductById(@PathVariable("id") Long id) throws SQLException {
        return ProductService.loadProductById(id);
    }

    @PostMapping("/product")
    public Product postProduct (@RequestBody Product product) throws SQLException {
        ProductService.saveItem(product);
        return product;

    }

    @DeleteMapping("/product")
    public void deleteOutOfSaleItems() throws SQLException {
        ProductService.deleteOutOfSaleItems();
    }

    @PutMapping("/product/{id}")
    public void updateItem(@PathVariable("id") Long id,@RequestParam BigDecimal price) throws SQLException{
        ProductService.updatePriceById(id, price);
    }









}
