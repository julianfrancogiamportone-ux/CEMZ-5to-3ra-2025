package CEMZ.Centro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CEMZ.Centro.Iservice.ImiembroService;
import CEMZ.Centro.entity.miembro;
import CEMZ.Centro.repository.miembroRepository;



@Service
public class miembroService implements ImiembroService{

	@Autowired
	private miembroRepository eRepository;
	
	@Override
	public List<miembro> findAllCharacters(){
		return eRepository.findAll();
}

	@Override
	public miembro saveCharacter(miembro miembro) {
		return eRepository.save(miembro);
	}
	@Override
	public Optional<miembro> findCharacterById(long id){
		return eRepository.findById(id);
	}
	@Override
	public List<miembro> findBySecretariaId(long idSecretaria) {
        return eRepository.findBySecretariaId(idSecretaria);
    }
}

