package com.agarcia.commons_microservices.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommonServiceImp<E, R extends CrudRepository<E, Long>> implements CommonService {
    
    @Autowired
    private R repository;

    @Transactional(readOnly = true)
    public Iterable<E> findAll(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public E save (E entity) {
        return repository.save(entity);
    }

    @Transactional
    public void deleteById (Long id) {
        repository.deleteById(id);
    }
}
