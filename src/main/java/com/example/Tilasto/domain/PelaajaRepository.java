package com.example.Tilasto.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface  PelaajaRepository extends  CrudRepository<Pelaaja, Long>{

	List<Pelaaja>findById(long id);
}
