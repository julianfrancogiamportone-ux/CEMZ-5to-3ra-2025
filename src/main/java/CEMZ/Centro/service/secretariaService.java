package CEMZ.Centro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CEMZ.Centro.Iservice.IsecretariaService;
import CEMZ.Centro.entity.secretaria;
import CEMZ.Centro.repository.secretariaRepository;

@Service
public class secretariaService implements IsecretariaService{

	@Autowired
	private secretariaRepository pRepository;
	
	@Override
	public List<secretaria> findAllCharacters(){
		return pRepository.findAll();
}

	@Override
	public secretaria saveCharacter(secretaria secretaria) {
		return pRepository.save(secretaria);
	}
	@Override
	public Optional<secretaria> findCharacterById(long id){
		return pRepository.findById(id);
	}
	
}
