package com.crud.crud.repository;

import java.util.List;
import java.util.Optional;

import com.crud.crud.model.Bank;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long>{
    
    List<Bank> findAll();

    Optional<Bank> findById(Long id);

    List<Bank> findByName(String name);

}
