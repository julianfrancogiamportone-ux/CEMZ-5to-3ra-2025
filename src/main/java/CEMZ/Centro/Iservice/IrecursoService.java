package CEMZ.Centro.Iservice;

import java.util.List;
import java.util.Optional;

import CEMZ.Centro.entity.recurso;




public interface IrecursoService {
	
	public List<recurso> findAllCharacters();
	public recurso saveCharacter(recurso recurso);
	public Optional<recurso> findCharacterById(long id);
	List<recurso> findBySecretariaId(long idSecretaria);
}
