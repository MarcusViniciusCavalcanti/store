package br.com.mundial.store.storefront.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/storefront")
public class StoreFrontEndpoint {

    @GetMapping
    public ResponseEntity<?> getPromotions() {
        return new ResponseEntity<>("access storefront endpoint", HttpStatus.OK);
    }
}
