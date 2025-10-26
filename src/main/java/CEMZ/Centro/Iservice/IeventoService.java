package CEMZ.Centro.Iservice;

import java.util.List;
import java.util.Optional;

import CEMZ.Centro.entity.evento;

public interface IeventoService {
	
	public List<evento> findAllCharacters();
	public evento saveCharacter(evento evento);
	public Optional<evento> findCharacterById(long id);

}
