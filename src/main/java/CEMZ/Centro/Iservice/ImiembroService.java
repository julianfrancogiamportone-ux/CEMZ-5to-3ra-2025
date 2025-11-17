package CEMZ.Centro.Iservice;

import java.util.List;
import java.util.Optional;

import CEMZ.Centro.entity.miembro;


public interface ImiembroService {
	
	public List<miembro> findAllCharacters();
	public miembro saveCharacter(miembro miembro);
	public Optional<miembro> findCharacterById(long id);
	List<miembro> findBySecretariaId(long idSecretaria);
}
