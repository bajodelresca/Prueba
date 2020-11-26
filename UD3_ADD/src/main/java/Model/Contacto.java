package Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CONTACTO")
public class Contacto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE")
	private String phone;
	
	@OneToOne(mappedBy = "contacto",fetch=FetchType.LAZY)
	//NANANANANANA
	private Autor autor;
	
	public Contacto() {}
	public Contacto(Long id, String email, String phone) {
		this.id = id;
		this.email = email;
		this.phone = phone;
	}
	
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Contacto [id=" + id + ", email=" 
	+ email + ", phone=" + phone + " autor="+this.getAutor().getId()+"]";
	}
}	

