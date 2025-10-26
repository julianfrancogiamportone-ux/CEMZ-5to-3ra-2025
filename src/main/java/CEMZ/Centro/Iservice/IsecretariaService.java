package CEMZ.Centro.Iservice;

import java.util.List;
import java.util.Optional;

import CEMZ.Centro.entity.secretaria;

public interface IsecretariaService {
	
	public List<secretaria> findAllCharacters();
	public secretaria saveCharacter(secretaria secretaria);
	public Optional<secretaria> findCharacterById(long id);

}
