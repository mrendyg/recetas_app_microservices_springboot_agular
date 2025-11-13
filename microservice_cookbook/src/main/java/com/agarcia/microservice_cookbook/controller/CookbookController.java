package com.agarcia.microservice_cookbook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agarcia.commons_ingredients.persistence.models.IngredientsEntity;
import com.agarcia.commons_microservices.services.controller.CommonController;
import com.agarcia.microservice_cookbook.persistence.models.CookbookEntity;
import com.agarcia.microservice_cookbook.service.CookbookService;

@RestController
public class CookbookController extends CommonController<CookbookEntity, CookbookService> {
    
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody CookbookEntity cookbookEntity, 
    @PathVariable Long id) {
        Optional<CookbookEntity> o = service.findById(id);

        if (o.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        CookbookEntity cookbookDb = o.get();
        cookbookDb.setName(cookbookEntity.getName());
        cookbookDb.setImage(cookbookEntity.getImage());
        cookbookDb.setInstructions(cookbookEntity.getInstructions());
        cookbookDb.setDescription(cookbookEntity.getDescription());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cookbookDb));
    }

    @PutMapping("/{id}/add-ingredient")
    public ResponseEntity<?> addIngredient(@RequestBody List<IngredientsEntity> ingredient, @PathVariable Long id) {
        Optional<CookbookEntity> o = service.findById(id);
        if (o.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        CookbookEntity cookbookDb = o.get();
        
        ingredient.forEach(a -> {
            cookbookDb.addIngredient(a);
        });

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cookbookDb));
    }

    @DeleteMapping("/{id}/delete-ingredient")
    public ResponseEntity<?> addIngredient(@RequestBody IngredientsEntity ingredient, @PathVariable Long id) {
        Optional<CookbookEntity> o = service.findById(id);
        if (o.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        CookbookEntity cookbookDb = o.get();
        
        cookbookDb.removeIngredient(ingredient);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cookbookDb));
    }
    
}
