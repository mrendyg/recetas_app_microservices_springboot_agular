package com.agarcia.microservice_cookbook.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.agarcia.microservice_cookbook.persistence.models.CookbookEntity;

public interface CookbookRepository extends CrudRepository<CookbookEntity, Long> {
    
}
