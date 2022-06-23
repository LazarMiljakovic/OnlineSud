package Testovi;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.ejb.servisi.*;
import com.ejb.servisi.Impl.*;
import com.jpa.entiteti.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPodnosenjaTuzbe {

	private static StrankaServis strServis; 
		
		@BeforeClass
		public static void initTest()
		{
			strServis = new StrankaServisImpl();
			System.out.println("BeforeClass:Inicijalizacija");
		}
		
		// 
		@Before// Proveravamo da li postoje dve stranke pod licnim kartama da bi mogla da se podnese tuzba
		public void testPre()
		{
			Stranka s1 = strServis.VratiStranku("231325190");
			Stranka s2 = strServis.VratiStranku("859403124");
			assertNotNull(s1);
			assertNotNull(s2);
			System.out.println("Before: Postoje");

		}
		
		// Testiramo podnosenje tuzbe
		@Test
		public void test()
		{
			strServis.PodnesiTuzbu(1, "231325190", "859403124", "Parnica");
			System.out.println("Test:Testiramo premestanje");
		}
		
		// 
		@After
		public void testPosle()
		{
			
			
			EntityManager em = Persistence.createEntityManagerFactory("OnlineSud").createEntityManager();
			TypedQuery<Tuzba> q = em.createQuery("SELECT e FROM Tuzba e WHERE e.idSuda = :idSud AND e.idTuzioc = :idTuz AND e.idOptuzen = :idOpt AND e.sadrzaj = :idStat", Tuzba.class);
			q.setParameter("idSud", 1);
			q.setParameter("idTuz", "231325190");
			q.setParameter("idOpt", "859403124");
			q.setParameter("idStat", "Parnica");

			List<Tuzba> tl = q.getResultList();
			assertNotNull(tl.get(0));
			System.out.println("After:Uspesno dodata");
			System.out.println(tl.get(0).getId());
			int id = tl.get(0).getId();
			Tuzba s = em.find(Tuzba.class,id);
			em.getTransaction().begin();
			em.remove(s);
			em.getTransaction().commit();
			
		}
		
		@AfterClass
		public static void KrajTesta()
		{
			System.out.println("AfterClass:Kraj testa");
		}
}
