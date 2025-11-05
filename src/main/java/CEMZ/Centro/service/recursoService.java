package CEMZ.Centro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CEMZ.Centro.Iservice.IeventoService;
import CEMZ.Centro.Iservice.IrecursoService;
import CEMZ.Centro.entity.evento;
import CEMZ.Centro.repository.eventoRepository;
import CEMZ.Centro.repository.recursoRepository;



@Service
public class recursoService implements IrecursoService{

	@Autowired
	private recursoRepository pRepository;
	
	@Override
	public List<recurso> findAllCharacters(){
		return pRepository.findAll();
}

	@Override
	public  saveCharacter(recurso recurso) {
		return pRepository.save(recurso);
	}
	@Override
	public Optional<recurso> findCharacterById(long id){
		return pRepository.findById(id);
	}
	
}

