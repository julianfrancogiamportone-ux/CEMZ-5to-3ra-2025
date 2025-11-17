package CEMZ.Centro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import CEMZ.Centro.entity.miembro;

public interface miembroRepository extends JpaRepository<miembro, Long>{
	
	List<miembro> findBySecretariaId(Long id);
}
