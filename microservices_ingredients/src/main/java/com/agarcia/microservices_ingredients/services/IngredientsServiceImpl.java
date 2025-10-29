package com.agarcia.microservices_ingredients.services;

import org.springframework.stereotype.Service;
import com.agarcia.commons_microservices.services.CommonServiceImp;
import com.agarcia.microservices_ingredients.persistence.models.IngredientsEntity;
import com.agarcia.microservices_ingredients.persistence.repository.IngredientsRepository;
@Service
public class IngredientsServiceImpl extends CommonServiceImp<IngredientsEntity, IngredientsRepository> implements IngredientsService {

}
