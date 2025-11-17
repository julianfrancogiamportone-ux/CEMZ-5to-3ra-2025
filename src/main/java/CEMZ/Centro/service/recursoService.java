package CEMZ.Centro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CEMZ.Centro.Iservice.IrecursoService;
import CEMZ.Centro.entity.recurso;
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
	public recurso saveCharacter(recurso recurso) {
		return pRepository.save(recurso);
	}
	@Override
	public Optional<recurso> findCharacterById(long id){
		return pRepository.findById(id);
	}
	@Override
    public List<recurso> findBySecretariaId(long idSecretaria) {
        return pRepository.findBySecretariaId(idSecretaria);
    }
}

