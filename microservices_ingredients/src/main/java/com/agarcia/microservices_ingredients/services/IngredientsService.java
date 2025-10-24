package com.agarcia.microservices_ingredients.services;

import java.util.Optional;

import com.agarcia.microservices_ingredients.persistence.models.IngredientsEntity;


public interface IngredientsService {
    
    public Iterable<IngredientsEntity> findAll();

    public Optional<IngredientsEntity> findById(Long id);

    public IngredientsEntity save(IngredientsEntity ingredientsEntity);

    public void deleteById(Long id);

}
