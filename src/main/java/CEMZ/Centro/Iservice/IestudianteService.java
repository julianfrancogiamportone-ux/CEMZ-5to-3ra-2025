package CEMZ.Centro.Iservice;

import java.util.List;
import java.util.Optional;

import CEMZ.Centro.entity.estudiante;

public interface IestudianteService {
	
	public List<estudiante> findAllCharacters();
	public estudiante saveCharacter(estudiante estudiante);
	public Optional<estudiante> findCharacterById(long id);

}
