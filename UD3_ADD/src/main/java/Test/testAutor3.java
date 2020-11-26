package Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Autor;
import Model.Contacto;
import Model.Libro;

public class testAutor3 {

	private static EntityManager manager;
	private static EntityManagerFactory emf;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		emf=Persistence.createEntityManagerFactory("aplicacion");
		manager=emf.createEntityManager();

		Autor a1=
        new Autor(1L,"Carlos Serrano",
		LocalDate.parse("1980-06-01"),
		new Contacto(1L,"pcserrano@ies.es","555"));
		
		Libro l1=new Libro("123","Bonno");
		Libro l2=new Libro("132","Sony");
		List<Libro> libros=new ArrayList();
		libros.add(l1);libros.add(l2);
		a1.setLibros(libros);
		manager.getTransaction().begin();
		manager.persist(a1);
		manager.getTransaction().commit();
		
		manager.getTransaction().begin();
		Autor ax=manager.find(Autor.class, 1L);
		System.out.println(ax);
		List<Libro> mislibros=ax.getLibros();
		for(Libro lx:mislibros) {
			System.out.println(lx);
		}
		manager.getTransaction().commit();
		//list();
		
		
	}
	public static void list() {
		EntityManager manager=emf.createEntityManager();
		List<Autor> autores=manager.createQuery("FROM Autor").getResultList();
		System.out.println("Autores: "+autores.size());
		for(Autor a:autores) {
			System.out.println(a);
		}
		manager.close();
	}

}
