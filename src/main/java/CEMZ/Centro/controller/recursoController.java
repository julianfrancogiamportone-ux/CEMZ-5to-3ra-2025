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

import CEMZ.Centro.Iservice.IrecursoService;
import CEMZ.Centro.entity.recurso;



@RestController
@RequestMapping("/recursos")
@CrossOrigin(origins = "*")
public class recursoController {
	
	@Autowired
	private IrecursoService eService;
	
	@GetMapping
	public List<recurso> getAllCharacters(){
		return eService.findAllCharacters();
	}
	@GetMapping("/{id}")
	public Optional<recurso> getCharacterById(@PathVariable long id){
		return eService.findCharacterById(id);
	}
	@PostMapping
	public recurso createCharacter(@RequestBody recurso recurso) {
		return eService.saveCharacter(recurso);
	}
	@GetMapping("/filtrar/{idSecretaria}")
	public List<recurso> getEventosPorSecretaria(@PathVariable long idSecretaria){
	    return eService.findBySecretariaId(idSecretaria);
	}
}