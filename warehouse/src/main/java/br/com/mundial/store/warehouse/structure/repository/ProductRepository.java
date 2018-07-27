package br.com.mundial.store.warehouse.structure.repository;

import br.com.mundial.store.warehouse.domain.entities.Category;
import br.com.mundial.store.warehouse.domain.entities.Product;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAllByCategories(Category category);

    List<Product> findAll();
}