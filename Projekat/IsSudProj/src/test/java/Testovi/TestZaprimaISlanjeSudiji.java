package Testovi;

import com.ejb.servisi.*;
import com.ejb.servisi.Impl.*;
import com.jpa.entiteti.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class TestZaprimaISlanjeSudiji{

	private static SudServis Servis; 

	@BeforeClass
	public static void initTest()
	{
		Servis = new SudServisImpl();
		System.out.println("BeforeClass:Inicijalizacija");
	}
	
	// 
	@Before// Proveravamo da li postoje tuzbe koje su u obradi
	public void testPre()
	{
		Sud s = Servis.VratiSud(2);
		List<Tuzba> t = Servis.VratiSvePredateTuzbeSuda(s.getId());
		assertNotNull(t.get(0));
		assertNotNull(s);
		System.out.println("Before: Postoje");

	}
	
	// Testiramo obradu od suda i slanje sudiji 
	@Test
	public void test()
	{
		List<Tuzba> t = Servis.VratiSvePredateTuzbeSuda(2);
		for(Tuzba tl:t)
		{
			System.out.println(tl.getStatus());
			String s = tl.getStatus();
			if(s.equals("Preuzeta od suda"))
			{
				Servis.PredajTuzbuSudiji(1, tl.getId());
				System.out.println("Test:Testiramo slanje tuzbe");
			}
			
		}
		
		
	}
	
	// Provericemo da li je promenjen status
	@After
	public void testPosle()
	{
		List<Tuzba> tls = Servis.VratiSvePredateTuzbeSuda(2);
		for(Tuzba tl:tls)
		{
			if(tl.getId() == 18)
			{
				String s = tl.getStatus();
				assertTrue(s.equals("Predata tuzba sudiji"));
				System.out.println("After:Uspesno radi");
				
			}
			
		}
		EntityManager em = Persistence.createEntityManagerFactory("OnlineSud").createEntityManager();
		Tuzba s = em.find(Tuzba.class,18);
		em.getTransaction().begin();
		s.setIdSudije(null);
		s.setStatus("Preuzeta od suda");
		em.getTransaction().commit();

		
	}
	
	@AfterClass
	public static void KrajTesta()
	{
		System.out.println("AfterClass:Kraj testa");
	}
}
