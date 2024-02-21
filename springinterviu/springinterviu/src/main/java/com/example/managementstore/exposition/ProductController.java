package com.example.managementstore.exposition;

import com.example.managementstore.domain.Product;
import com.example.managementstore.dto.ProductDto;
import com.example.managementstore.service.ConsultAllProducts;
import com.example.managementstore.service.ConsultProductService;
import com.example.managementstore.service.CreateProductService;
import com.example.managementstore.service.DeleteProductService;
import com.example.managementstore.service.UpdateProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private CreateProductService createProductService;

    @Autowired
    private ConsultAllProducts consultAllProducts;

    @Autowired
    private ConsultProductService consultProductService;

    @Autowired
    private ProductMapperService productMapperService;

    @Autowired
    private UpdateProductService updateProductService;

    @Autowired
    private DeleteProductService deleteProductService;

    @GetMapping("/ping")
    public String ping() {
        return "Hello world!";
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody ProductDto dto) {
        Product product = productMapperService.mapToDomainForCreate(dto);
        createProductService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> consultProductById(@PathVariable("id") String productId) {
        Product product = consultProductService.consult(productId);
        ProductDto dto = productMapperService.mapFromDomain(product);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> consultAllProducts(@RequestParam(required = false) String name) {
        List<Product> products = consultAllProducts.consultAll(name);
        List<ProductDto> dto = products.stream().map(product -> productMapperService.mapFromDomain(product)).collect(
                Collectors.toList());
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<Void> updateProduct(@RequestBody ProductDto productDto, @RequestParam String productId) {
        Product product = productMapperService.mapToDomainForUpdate(productDto, productId);
        updateProductService.updateProduct(product);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam String productId) {
        deleteProductService.deleteProductById(productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
