package CEMZ.Centro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity

public class evento {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre; 
	private String fecha;
	private String lugar; 
 
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public secretaria getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(secretaria secretaria) {
		this.secretaria = secretaria;
	}

	public evento(String nombre, String fecha, String lugar, CEMZ.Centro.entity.secretaria secretaria) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.lugar = lugar;
		this.secretaria = secretaria;
	}

	public evento() {
		super();
	}

	@ManyToOne
	@JoinColumn(name = "secretaria_id")
	private secretaria secretaria;
}
	