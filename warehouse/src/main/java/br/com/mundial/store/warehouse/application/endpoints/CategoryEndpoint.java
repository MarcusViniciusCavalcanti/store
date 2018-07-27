package br.com.mundial.store.warehouse.application.endpoints;

import br.com.mundial.store.warehouse.domain.entities.Category;
import br.com.mundial.store.warehouse.domain.resources.CategoryResource;
import br.com.mundial.store.warehouse.domain.service.CategoryService;
import br.com.mundial.store.warehouse.structure.erros.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/categories")
public class CategoryEndpoint {

    private final CategoryService service;

    @Autowired
    public CategoryEndpoint(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CategoryResource>> getAllCategory() {
        return new ResponseEntity<>(service.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getCategoryById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CategoryResource> createNewCategory(Category category) {
        return new ResponseEntity<>(service.create(category), HttpStatus.CREATED);
    }

    @PatchMapping
    @Transactional(rollbackFor = ResourceNotFoundException.class)
    public ResponseEntity<CategoryResource> update(@RequestBody Category category) {
        return new ResponseEntity<>(service.update(category), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
