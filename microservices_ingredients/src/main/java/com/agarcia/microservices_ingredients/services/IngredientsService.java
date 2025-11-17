package com.agarcia.microservices_ingredients.services;

import java.util.List;

import com.agarcia.commons_ingredients.persistence.models.IngredientsEntity;
import com.agarcia.commons_microservices.services.CommonService;

public interface IngredientsService extends CommonService<IngredientsEntity> {

    public List<IngredientsEntity> findByName(String term);
    
}
