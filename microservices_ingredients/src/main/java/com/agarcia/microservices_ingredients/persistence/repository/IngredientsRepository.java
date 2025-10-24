package com.agarcia.microservices_ingredients.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agarcia.microservices_ingredients.persistence.models.IngredientsEntity;

public interface IngredientsRepository extends JpaRepository<IngredientsEntity, Long>{
    
}
