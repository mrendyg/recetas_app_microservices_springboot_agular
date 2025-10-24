package com.agarcia.microservices_ingredients.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agarcia.microservices_ingredients.persistence.models.IngredientsEntity;
import com.agarcia.microservices_ingredients.services.IngredientsService;


@RestController
public class IngredientsController {

    @Autowired
    private IngredientsService ingredientsService;

    @GetMapping
    public ResponseEntity<?> list(){
        return ResponseEntity.ok().body(ingredientsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id){
        Optional<IngredientsEntity> o = ingredientsService.findById(id);  
        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(o.get());
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody IngredientsEntity ingredientsEntity){
        IngredientsEntity ingredientsDB = ingredientsService.save(ingredientsEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(ingredientsDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody IngredientsEntity ingredientsEntity, 
    @PathVariable Long id){
        Optional<IngredientsEntity> o = ingredientsService.findById(id);

        if (o.isEmpty()) {
            ResponseEntity.notFound().build();
        }

        IngredientsEntity ingredientesDB = o.get();
        ingredientesDB.setName(ingredientsEntity.getName());
        ingredientesDB.setQuantity(ingredientsEntity.getQuantity());
        ingredientesDB.setCost(ingredientesDB.getCost());
        ingredientesDB.setStock(ingredientesDB.getStock());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(ingredientsService.save(ingredientesDB));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        ingredientsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
