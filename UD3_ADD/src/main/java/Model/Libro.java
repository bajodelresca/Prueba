package Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="LIBRO")
public class Libro implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ISBN")
	private String isbn;
	
	@Column(name="TITULO")
	private String titulo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_AUTOR")
	private Autor autor;

	public Libro(String isbn, String titulo) {
		this.isbn = isbn;
		this.titulo = titulo;
	}

	public Libro() {
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
		
		
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor.getId() + "]";
	}
	
	
	
}

