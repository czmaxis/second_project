package org.second.project;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Collection;


@CrossOrigin
@RestController
public class ProductController {

    ProductService productService;

    public ProductController()throws SQLException {
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleError(Exception e){
        return new ErrorResponse(e.getMessage(), LocalDateTime.now());
    }

    @GetMapping("/product")
    public Collection<Product> getAllProducts() throws SQLException







}
