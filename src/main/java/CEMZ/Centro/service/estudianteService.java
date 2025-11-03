package CEMZ.Centro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CEMZ.Centro.Iservice.IestudianteService;
import CEMZ.Centro.entity.estudiante;
import CEMZ.Centro.repository.estudianteRepository;


@Service
public class estudianteService implements IestudianteService{

	@Autowired
	private estudianteRepository eRepository;
	
	@Override
	public List<estudiante> findAllCharacters(){
		return eRepository.findAll();
}

	@Override
	public estudiante saveCharacter(estudiante estudiante) {
		return eRepository.save(estudiante);
	}
	@Override
	public Optional<estudiante> findCharacterById(long id){
		return eRepository.findById(id);
	}
	
}