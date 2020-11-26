package Test;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Autor;

public class testAutor1 {

	private static EntityManager manager;
	private static EntityManagerFactory emf;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		emf=Persistence.createEntityManagerFactory("aplicacion");
		manager=emf.createEntityManager();
		list();
		Autor a1=new Autor(1L,"Carlos Serrano",LocalDate.parse("1980-06-01"),null);
		Autor a2=new Autor(10L,"Miguel de Cervantes",LocalDate.parse("1547-09-29"),null);
		manager.getTransaction().begin();
		manager.persist(a1);
		manager.persist(a2);
		a2.setName("D. Miguel de Cervantes");
		manager.getTransaction().commit();
		list();
		
		///Segunda parte
		manager.getTransaction().begin();
		Autor ax=manager.find(Autor.class, 10L);
		if(ax!=null) {
			System.out.println("Leído de la BBDD");
			System.out.println(ax);
			//manager.detach(ax);
			ax.setName("El manco de Lepanto");
		}else {
			System.out.println("NO ENCUENTRO NADA");
		}
		manager.getTransaction().commit();
		manager.close();
		
		
		ax.setName("Miguel de Cervantes");
		manager=emf.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(ax);  //update la bbdd
		ax.setName("NONONO");
		manager.getTransaction().commit();
		manager.close();
		list();
		
		manager=emf.createEntityManager();
		manager.getTransaction().begin();
		Autor az= manager.find(Autor.class, 1L);
		az.setName("Carlos Serrano se borra");
		manager.remove(az);
		manager.getTransaction().commit();
		list();
			
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
