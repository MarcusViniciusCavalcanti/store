package br.com.mundial.store.warehouse.domain.resources;

import br.com.mundial.store.warehouse.application.endpoints.CategoryEndpoint;
import br.com.mundial.store.warehouse.application.endpoints.ProductsEndpoint;
import br.com.mundial.store.warehouse.domain.entities.Product;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class ProductResource extends ResourceSupport {

    private final Product product;

    public ProductResource(Product product) {
        this.product = product;

        add(linkTo(ProductsEndpoint.class).withRel("products"));

        product.getCategories().forEach(category -> {
            add(linkTo(methodOn(CategoryEndpoint.class).getCategoryById(category.getId())).withRel("categories"));;
        });

        add(linkTo(methodOn(ProductsEndpoint.class).getProductById(product.getId())).withSelfRel());
    }

    public Product getProduct() {
        return product;
    }
}
