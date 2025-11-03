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

import CEMZ.Centro.Iservice.IestudianteService;
import CEMZ.Centro.entity.estudiante;



@RestController
@RequestMapping("/estudiantes")
@CrossOrigin(origins = "*")
public class estudianteController {
	
	@Autowired
	private IestudianteService eService;
	
	@GetMapping
	public List<estudiante> getAllCharacters(){
		return eService.findAllCharacters();
	}
	@GetMapping("/estudiantes/{id}")
	public Optional<estudiante> getCharacterById(@PathVariable long id){
		return eService.findCharacterById(id);
	}
	@PostMapping
	public estudiante createCharacter(@RequestBody estudiante estudiante) {
		return eService.saveCharacter(estudiante);
	}

}