package CEMZ.Centro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity

public class secretaria {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre; 
	private String descripcion;
 

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public miembro getMiembro() {
		return miembro;
	}


	public void setMiembro(miembro miembro) {
		this.miembro = miembro;
	}


	public secretaria(String nombre, String descripcion, CEMZ.Centro.entity.miembro miembro) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.miembro = miembro;
	}


	public secretaria() {
		super();
	}


	@ManyToOne(mappedBy = "secretaria")
	private miembro miembro;
	
	@ManyToOne(mappedBy = "secretaria")
	private evento evento;
}
