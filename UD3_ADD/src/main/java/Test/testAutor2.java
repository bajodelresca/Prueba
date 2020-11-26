package Test;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Autor;
import Model.Contacto;

public class testAutor2 {

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
		
		manager.getTransaction().begin();
		manager.persist(a1);
		manager.getTransaction().commit();
		//list();
		
		manager.getTransaction().begin();
		Contacto cx=manager.find(Contacto.class,1L);
		System.out.println(cx);
		////////////////////////
		Autor ax=manager.find(Autor.class,1L);
		System.out.println(ax);
		manager.getTransaction().commit();
		
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
