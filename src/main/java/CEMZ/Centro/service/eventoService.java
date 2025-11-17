package CEMZ.Centro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CEMZ.Centro.Iservice.IeventoService;
import CEMZ.Centro.entity.evento;
import CEMZ.Centro.repository.eventoRepository;



@Service
public class eventoService implements IeventoService{

	@Autowired
	private eventoRepository pRepository;
	
	@Override
	public List<evento> findAllCharacters(){
		return pRepository.findAll();
}

	@Override
	public evento saveCharacter(evento evento) {
		return pRepository.save(evento);
	}
	@Override
	public Optional<evento> findCharacterById(long id){
		return pRepository.findById(id);
	}
	@Override
    public List<evento> findBySecretariaId(long idSecretaria) {
        return pRepository.findBySecretariaId(idSecretaria);
    }
}

