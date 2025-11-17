package CEMZ.Centro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import CEMZ.Centro.entity.recurso;


public interface recursoRepository extends JpaRepository<recurso, Long>{
	List<recurso> findBySecretariaId(Long id);
}
