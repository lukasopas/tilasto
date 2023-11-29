package com.example.Tilasto.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Tilasto.domain.Pelaaja;
import com.example.Tilasto.domain.PelaajaRepository;
import com.example.Tilasto.domain.Pelinumero;
import com.example.Tilasto.domain.PelinumeroRepository;


@Controller
public class PelaajaController {
	@Autowired
	public PelaajaRepository repository;
	@Autowired
	public PelinumeroRepository prepository;
	
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	// NÄYTTÄÄ PELAAJAT
	  @RequestMapping(value={"/tilasto"})
	    public String Tilasto(Model model) {
	        model.addAttribute("pelaajat", repository.findAll());
	        return "tilasto";
	  }
	  //LIÄÄ UUDEN PELAAJAN
	        @RequestMapping(value = "/add")
	        public String addPelaaja(Model model){
	        	model.addAttribute("pelaaja", new Pelaaja());
	        	//model.addAttribute("pelinumero",new Pelinumero());
	           model.addAttribute("pelinumero", prepository.findAll());
	            return "addpelaaja";
	        }     
	        //TALLENTAA PELAAJAN
	        @RequestMapping(value = "/savePelaaja", method = RequestMethod.POST)
	        public String save(Pelaaja pelaaja) {
	        //	prepository.save(pelinumero);
	            repository.save(pelaaja);
	          
	            return "redirect:tilasto";
	        }

	            // POISTAA PELAAJAN VAIN ADMIN NÄKEE POISTO NAPIN
	        @PreAuthorize("hasAuthority('ADMIN')")
	            @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	            public String deletePelaaja(@PathVariable("id")Long pelaajaId, Model model) {
	            	repository.deleteById(pelaajaId);
	                return "redirect:../tilasto";
	            }     

                    //MUOKKAA PELAAJAA
	            @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	            public String editPelaaja(@PathVariable("id") Long pelaajaId, Model model) {
	            	model.addAttribute("pelaaja", repository.findById(pelaajaId));
	            	//model.addAttribute("pelinumero", prepository.findByNumero(0));
	             //  prepository.save(pelaaja.getPelinumero());
	            	repository.deleteById(pelaajaId);
	                return "edittilasto";
	            }
	            
	            @RequestMapping(value = "/saveEdit", method = RequestMethod.POST)
		        public String saveEdit(Pelaaja pelaaja) {
		          prepository.save(pelaaja.getPelinumero());
		          repository.save(pelaaja);
		          
		          return "redirect:tilasto";
	            }
	            //PELAAJA REST
		      	@CrossOrigin
		        @RequestMapping(value="/pelaajaREST", method = RequestMethod.GET)
		        public @ResponseBody List <Pelaaja> pelaajaRest(){
		            return(List<Pelaaja>) repository.findAll();
		        }
		      	//PELINUMERO REST
		      	@CrossOrigin
		    	@RequestMapping(value="/pelinumeroREST", method = RequestMethod.GET)
		        public @ResponseBody List <Pelinumero> PelinumeroRest(){
		            return(List<Pelinumero>) prepository.findAll();
		          
		        }
}
	  

