package br.com.mundial.store.warehouse.domain.service;

import br.com.mundial.store.warehouse.domain.entities.Category;
import br.com.mundial.store.warehouse.domain.resources.CategoryResource;
import br.com.mundial.store.warehouse.structure.erros.exceptions.DeletingOperationIllegalException;
import br.com.mundial.store.warehouse.structure.erros.exceptions.ResourceNotFoundException;
import br.com.mundial.store.warehouse.structure.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CategoryService {

    private final CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<CategoryResource> getAllCategories() {
        List<Category> categories = repository.findAll();
        return categories.stream().map(CategoryResource::new).collect(Collectors.toList());
    }

    public CategoryResource getCategoryById(Integer id) {
        Category category = getEntityOrThrowNotFound(id);
        return new CategoryResource(category);
    }

    public CategoryResource create(Category category) {
        return new CategoryResource(repository.save(category));
    }

    public CategoryResource update(Category category) {
        getEntityOrThrowNotFound(category.getId());
        return new CategoryResource(repository.save(category));
    }

    public void delete(Integer id) {
        Category entityOrThrowNotFound = getEntityOrThrowNotFound(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException ex) {
            throw new DeletingOperationIllegalException(Category.class, id);
        }
    }

    private Category getEntityOrThrowNotFound(Integer id) {
        Optional<Category> optionalCategory = repository.findById(id);
        return optionalCategory.orElseThrow(() -> new ResourceNotFoundException(Category.class, id));
    }

}
