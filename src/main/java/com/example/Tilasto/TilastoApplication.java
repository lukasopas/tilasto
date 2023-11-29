package com.example.Tilasto;

import java.io.Console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Tilasto.domain.AppUser;
import com.example.Tilasto.domain.AppUserRepository;
import com.example.Tilasto.domain.Pelaaja;
import com.example.Tilasto.domain.PelaajaRepository;
import com.example.Tilasto.domain.Pelinumero;
import com.example.Tilasto.domain.PelinumeroRepository;



@SpringBootApplication
public class TilastoApplication {
	private static final Logger log = LoggerFactory.getLogger(TilastoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TilastoApplication.class, args);
	}
	@Bean
	public CommandLineRunner tilastoDemo(PelaajaRepository repository, PelinumeroRepository prepository, AppUserRepository urepository) {
		return(args)->{
			log.info("lisätään pelaajia");
			for (int i = 1; i <= 99; i++) {
			    prepository.save(new Pelinumero(i));
			}

			//tallennetaan pelaaja
			repository.save(new Pelaaja("jonne", "Megamind", "lool", prepository.findByNumero(2),"2","2","1"));
			//tallennetaan käyttäjä
			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("ota pelaajat");
			//näyttää käyttäjä tunnuksen ja salasanan consolessa
			log.info("User details: {}", user1);

		
	
	};

}
}