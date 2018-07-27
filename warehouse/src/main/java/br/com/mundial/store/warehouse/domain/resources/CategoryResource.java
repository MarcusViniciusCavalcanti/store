package br.com.mundial.store.warehouse.domain.resources;

import br.com.mundial.store.warehouse.application.endpoints.CategoryEndpoint;
import br.com.mundial.store.warehouse.application.endpoints.ProductsEndpoint;
import br.com.mundial.store.warehouse.domain.entities.Category;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryResource extends ResourceSupport {

    private final Category category;

    public CategoryResource(Category category) {
        this.category = category;
        createLinks();
    }

    public Category getCategory() {
        return category;
    }

    public Integer getAmountProductsInCategory() {
        return category.getProducts().size();
    }

    private void createLinks() {
        add(linkTo(CategoryEndpoint.class).withRel("categories"));

        if (!category.getProducts().isEmpty()) {
            add(linkTo(methodOn(ProductsEndpoint.class).getProductByCategory(category.getId())).withRel("products"));
        }

        add(linkTo(methodOn(CategoryEndpoint.class).getCategoryById(category.getId())).withSelfRel());
    }
}
