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

import CEMZ.Centro.Iservice.IeventoService;
import CEMZ.Centro.entity.evento;



@RestController
@RequestMapping("/eventos")
@CrossOrigin(origins = "*")
public class eventoController {
	
	@Autowired
	private IeventoService pService;
	
	@GetMapping
	public List<evento> getAllCharacters(){
		return pService.findAllCharacters();
	}
	@GetMapping("/filtrar/{idSecretaria}")
	public List<evento> getEventosPorSecretaria(@PathVariable long idSecretaria){
	    return pService.findBySecretariaId(idSecretaria);
	}
	@GetMapping("/{id}")
	public Optional<evento> getCharacterById(@PathVariable long id){
		return pService.findCharacterById(id);
	}
	@PostMapping
	public evento createCharacter(@RequestBody evento evento) {
		return pService.saveCharacter(evento);
	}

}
