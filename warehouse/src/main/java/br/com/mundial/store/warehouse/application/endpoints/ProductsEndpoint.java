package br.com.mundial.store.warehouse.application.endpoints;

import br.com.mundial.store.warehouse.domain.entities.Category;
import br.com.mundial.store.warehouse.domain.entities.Product;
import br.com.mundial.store.warehouse.domain.resources.ProductResource;
import br.com.mundial.store.warehouse.domain.service.ProductService;
import br.com.mundial.store.warehouse.structure.erros.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/products", produces = "application/json")
public class ProductsEndpoint {

    private final ProductService service;

    @Autowired
    public ProductsEndpoint(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProductResource>> findAll() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResource> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getProductById(id), HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<ProductResource>> getProductByCategory(@PathVariable Integer id) {
        return new ResponseEntity<>(service.getProductsByCategory(id), HttpStatus.OK);
    }

    @PatchMapping
    @Transactional(rollbackFor = ResourceNotFoundException.class)
    public ResponseEntity<ProductResource> update(@RequestBody Product product ) {
        return new ResponseEntity<>(service.update(product), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}/addCategory")
    @Transactional(rollbackFor = ResourceNotFoundException.class)
    public ResponseEntity<?> addCategory(@PathVariable Long id, @RequestBody Category category) {
        service.addCategory(id, category);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/removeCategory")
    public ResponseEntity<?> removeCategory(@PathVariable Long id, @RequestBody Category category) {
        service.removeCategory(id, category);
        return ResponseEntity.noContent().build();
    }
}
