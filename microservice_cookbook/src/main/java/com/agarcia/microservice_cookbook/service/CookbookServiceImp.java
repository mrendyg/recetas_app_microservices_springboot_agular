package com.agarcia.microservice_cookbook.service;

import org.springframework.stereotype.Service;

import com.agarcia.commons_microservices.services.CommonServiceImp;
import com.agarcia.microservice_cookbook.persistence.models.CookbookEntity;
import com.agarcia.microservice_cookbook.persistence.repository.CookbookRepository;

@Service
public class CookbookServiceImp extends CommonServiceImp<CookbookEntity, CookbookRepository> implements CookbookService {

    
}
