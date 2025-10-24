package com.andyg.microservice.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andyg.microservice.persistence.models.IngredientsEntity;
import com.andyg.microservice.persistence.repository.IngredientsRepository;



@Service
public class IngredientsServiceImpl implements IngredientsService {
    
    @Autowired
    private IngredientsRepository ingredientsRepository;

    @Transactional(readOnly = true)
    public Iterable<IngredientsEntity> findAll(){
        return ingredientsRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<IngredientsEntity> findById(Long id) {
        return ingredientsRepository.findById(id);
    }

    @Transactional
    public IngredientsEntity save (IngredientsEntity ingredientsEntity){
        return ingredientsRepository.save(ingredientsEntity);
    }

    @Transactional
    public void deleteById (Long id) {
        ingredientsRepository.deleteById(id);
    }
}
