package com.products.products.resources;
import java.util.List;

import javax.validation.Valid;

import com.products.products.models.Product;
import com.products.products.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
@Api(value="API REST Products")
public class ProductResource {

    @Autowired
    ProductRepository productRepository;

    @ApiOperation(value="Returns a list of products")
    @GetMapping("/products")
    public List<Product> productList(){
        return productRepository.findAll();
    }

    @ApiOperation(value="Returns a single product")
    @GetMapping("/product/{id}")
    public Product singleProductList(@PathVariable(value="id") long id){
        return productRepository.findById(id);
    }

    @ApiOperation(value="Save a product")
    @PostMapping("/product")
    public Product saveProduct(@RequestBody @Valid Product product){
        return productRepository.save(product);
    }

    @ApiOperation(value="Delete a product")
    @DeleteMapping("/product")
    public void deleteProduct(@RequestBody @Valid Product product){
        productRepository.delete(product);
    }

    @ApiOperation(value="updates a product")
    @PutMapping("/product")
    public Product updateProducts(@RequestBody @Valid Product product){
        return productRepository.save(product);
    }
}
