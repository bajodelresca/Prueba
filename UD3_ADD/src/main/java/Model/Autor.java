package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="AUTOR")
public class Autor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	private Long id;
	@Column(name="NAME")
	private String name;
	@Column(name="BIRHDAY",columnDefinition = "DATE")
	private LocalDate birthDate;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="ID_CONTACTO")
	private Contacto contacto;
	
	@OneToMany(mappedBy = "autor",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	private List<Libro> libros=new ArrayList();
	
	public Autor() {}

	public Autor(Long id, String name, 
			LocalDate birthDate,Contacto contacto) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.setContacto(contacto);
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
		if(contacto!=null) {
			contacto.setAutor(this);
		}
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
		for(Libro l:this.libros) {
			l.setAutor(this);
		}
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", name=" + name 
				+ ", birthDate=" + birthDate + " contacto="+this.contacto+"]";
	}
	 
} 