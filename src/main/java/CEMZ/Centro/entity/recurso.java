package CEMZ.Centro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class recurso {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String Nombre_del_Recurso; 
	private int Cantidad; 
 
    @ManyToOne
	@JoinColumn(name = "secretaria_id")
	private secretaria secretaria;

	public recurso() {
		super();
	}

	
	

	public recurso(String nombre_del_Recurso, int cantidad) {
		super();
		Nombre_del_Recurso = nombre_del_Recurso;
		Cantidad = cantidad;
	}




	public recurso(String nombre_del_Recurso, int cantidad, CEMZ.Centro.entity.secretaria secretaria) {
		super();
		Nombre_del_Recurso = nombre_del_Recurso;
		Cantidad = cantidad;
		this.secretaria = secretaria;
	}




	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre_del_Recurso() {
		return Nombre_del_Recurso;
	}

	public void setNombre_del_Recurso(String nombre_del_Recurso) {
		Nombre_del_Recurso = nombre_del_Recurso;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	public secretaria getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(secretaria secretaria) {
		this.secretaria = secretaria;
	}
	
	
	
    

	
    
}
