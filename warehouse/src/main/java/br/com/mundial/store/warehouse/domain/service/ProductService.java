package br.com.mundial.store.warehouse.domain.service;

import br.com.mundial.store.warehouse.domain.entities.Category;
import br.com.mundial.store.warehouse.domain.entities.Product;
import br.com.mundial.store.warehouse.domain.resources.ProductResource;
import br.com.mundial.store.warehouse.structure.erros.exceptions.ResourceNotFoundException;
import br.com.mundial.store.warehouse.structure.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductResource getProductById(Long id) {
        Product product = getProductOrThrowNotFound(id);
        return new ProductResource(product);
    }


    public List<ProductResource> getProductsByCategory(Integer id) {
      return repository.findAllByCategories(new Category(id, null))
              .stream()
              .map(ProductResource::new)
              .collect(Collectors.toList());
    }

    public List<ProductResource> getAllProducts() {
        List<Product> products = repository.findAll();
        return products.stream().map(ProductResource::new).collect(Collectors.toList());
    }

    public ProductResource update(Product product) {
        getProductOrThrowNotFound(product.getId());
        return new ProductResource(repository.save(product));
    }


    public void addCategory(Long id, Category category) {
        Product product = getProductOrThrowNotFound(id);
        product.getCategories().add(category);
        repository.save(product);
    }

    public void removeCategory(Long id, Category category) {
        Product product = getProductOrThrowNotFound(id);
        product.getCategories().remove(category);
        repository.save(product);
    }

    private Product getProductOrThrowNotFound(Long id) {
        Optional<Product> optionalCategory = repository.findById(id);

        return optionalCategory.orElseThrow(() -> new ResourceNotFoundException(Product.class, id));
    }
}
