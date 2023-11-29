package com.example.Tilasto.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pelaaja {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long pelaajaid;
	private String firstName;
	private String lastName;
	private String joukkue;
	// private int pelinumero;
	private String maalit;
	private String syotot;
	private String pelatutottelut;

	public Pelaaja() {}
	@ManyToOne (cascade = CascadeType.MERGE)
	@JoinColumn(name="pelinumeroid")
	private  Pelinumero pelinumero;
	
	public Pelaaja(String firstName, String lastName, String joukkue, Pelinumero pelinumero, String maalit,
			String syotot, String pelatutottelut) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.joukkue = joukkue;
		this.pelinumero = pelinumero;
		this.maalit = maalit;
		this.syotot = syotot;
		this.pelatutottelut = pelatutottelut;
	}
	public Long getPelaajaid() {
		return pelaajaid;
	}
	public void setPelaajaid(Long pelaajaid) {
		this.pelaajaid=pelaajaid;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getJoukkue() {
		return joukkue;
	}
	public void setJoukkue(String joukkue) {
		this.joukkue = joukkue;
	}
	
	public Pelinumero getPelinumero() {
		return pelinumero;
	}
	public void setPelinumero(Pelinumero pelinumero) {
		this.pelinumero = pelinumero;
	}

	public String getMaalit() {
		return maalit;
	}
	public void setMaalit(String maalit) {
		this.maalit = maalit;
	}
	public String getSyotot() {
		return syotot;
	}
	public void setSyotot(String syotot) {
		this.syotot = syotot;
	}
	public String getPelatutottelut() {
		return pelatutottelut;
	}
	public void setPelatutottelut(String pelatutottelut) {
		this.pelatutottelut = pelatutottelut;
	}
	


	

	
}
