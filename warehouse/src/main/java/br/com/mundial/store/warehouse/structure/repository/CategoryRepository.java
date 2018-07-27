package br.com.mundial.store.warehouse.structure.repository;

import br.com.mundial.store.warehouse.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
