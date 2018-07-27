package br.com.mundial.store.security.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/users")
public class UserEndpoint {

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>("access application users", HttpStatus.OK);
    }
}
