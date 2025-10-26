package CEMZ.Centro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CEMZ.Centro.Iservice.IsecretariaService;
import CEMZ.Centro.entity.secretaria;


@RestController
@RequestMapping("/secretarias")
@CrossOrigin(origins = "*")
public class secretariaController {
	
	@Autowired
	private IsecretariaService pService;
	
	@GetMapping
	public List<secretaria> getAllCharacters(){
		return pService.findAllCharacters();
	}
	@GetMapping("/secretarias/{id}")
	public Optional<secretaria> getCharacterById(@PathVariable long id){
		return pService.findCharacterById(id);
	}
	@PostMapping
	public secretaria createCharacter(@RequestBody secretaria secretaria) {
		return pService.saveCharacter(secretaria);
	}

}