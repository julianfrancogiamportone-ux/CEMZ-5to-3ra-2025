package CEMZ.Centro.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity

public class miembro {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String cargo; 
	private LocalDate fecha_de_union;
 
    @ManyToOne
	@JoinColumn(name = "secretaria_id")
	private secretaria secretaria;
    
    @ManyToOne
	@JoinColumn(name = "estudiante_id")
	private estudiante estudiante;

	public miembro() {
		super();
	}

	public miembro(String cargo, LocalDate fecha_de_union, CEMZ.Centro.entity.secretaria secretaria,
			CEMZ.Centro.entity.estudiante estudiante) {
		super();
		this.cargo = cargo;
		this.fecha_de_union = fecha_de_union;
		this.secretaria = secretaria;
		this.estudiante = estudiante;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public LocalDate getFecha_de_union() {
		return fecha_de_union;
	}

	public void setFecha_de_union(LocalDate fecha_de_union) {
		this.fecha_de_union = fecha_de_union;
	}

	public secretaria getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(secretaria secretaria) {
		this.secretaria = secretaria;
	}

	public estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
    
}
