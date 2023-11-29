package com.example.Tilasto.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PelinumeroRepository extends JpaRepository<Pelinumero, Long> {

Pelinumero findByNumero(int numero);
  //  List<Pelinumero> findByNumero1(int numero);
}
