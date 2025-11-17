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

import CEMZ.Centro.Iservice.ImiembroService;
import CEMZ.Centro.entity.miembro;


@RestController
@RequestMapping("/miembros")
@CrossOrigin(origins = "*")
public class miembroController {
	
	@Autowired
	private ImiembroService eService;
	
	@GetMapping
	public List<miembro> getAllCharacters(){
		return eService.findAllCharacters();
	}
	@GetMapping("/filtrar/{idSecretaria}")
	public List<miembro> getEventosPorSecretaria(@PathVariable long idSecretaria){
	    return eService.findBySecretariaId(idSecretaria);
	}
	@GetMapping("/{id}")
	public Optional<miembro> getCharacterById(@PathVariable long id){
		return eService.findCharacterById(id);
	}
	@PostMapping
	public miembro createCharacter(@RequestBody miembro miembro) {
		return eService.saveCharacter(miembro);
	}

}
