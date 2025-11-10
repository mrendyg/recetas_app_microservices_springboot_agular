package com.agarcia.microservice_cookbook.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agarcia.commons_microservices.services.controller.CommonController;
import com.agarcia.microservice_cookbook.persistence.models.CookbookEntity;
import com.agarcia.microservice_cookbook.service.CookbookService;

@RestController
public class CookbookController extends CommonController<CookbookEntity, CookbookService> {
    
    @PutMapping("/id")
    public ResponseEntity<?> editar(@RequestBody CookbookEntity cookbook, @PathVariable Long id) {
        Optional<CookbookEntity> o = this.service.findById(id);
        if (o.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        CookbookEntity cookbookDb = o.get();
        cookbookDb.setName(cookbook.getName());
        cookbookDb.setImage(cookbook.getImage());
        cookbookDb.setInstructions(cookbook.getInstructions());
        cookbookDb.setDescription(cookbook.getDescription());
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cookbookDb));
    }
}
