package com.example.Tilasto.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Pelinumero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pelinumeroid;

    private Integer numero;
public Pelinumero() {};
    
	public Pelinumero(Integer numero) {
		super();
		this.numero = numero;
	}

	public Long getPelinumeroid() {
		return pelinumeroid;
	}

	public void setPelinumeroid(Long pelinumeroid) {
		this.pelinumeroid = pelinumeroid;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

}
