package com.crud.crud.controller;

import java.util.List;
import java.util.Optional;

import com.crud.crud.model.Bank;
import com.crud.crud.repository.BankRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banks")
public class BankController {

    private BankRepository repository;

    BankController(BankRepository bankRepository) {
        this.repository = bankRepository;
    }

    @GetMapping
    public ResponseEntity<List<Bank>> findAll() {
        return ResponseEntity.ok( repository.findAll());
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = {"/name/{name}"})
    public ResponseEntity<List<Bank>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(repository.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Bank> save(@RequestBody Bank bank) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(bank));
    }

    @PutMapping(path = {"/{id}"})
	public ResponseEntity<Bank> put(@RequestBody Bank bank, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(bank));
	}

    @DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
