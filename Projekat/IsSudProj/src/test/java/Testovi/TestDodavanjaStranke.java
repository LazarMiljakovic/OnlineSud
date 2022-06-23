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

public class TestDodavanjaStranke {

private static StrankaServis strServis;
	
	@BeforeClass
	public static void initTest()
	{
		strServis = new StrankaServisImpl();
		System.out.println("BeforeClass:Inicijalizacija");
	}
	
	
	@Before
	public void testPre()
	{
		
	}
	
	//Dodaje se Stranka sa validnom i nevalidnom licnom
	@Test
	public void test()
	{
		strServis.DodajStranku("249123450", "Radovan", "Lomic", "Kasandre 14");
		strServis.DodajStranku("21234a231", "Milenko", "Bobic", "Jevrosime 10");
		System.out.println("Test:Testiramo dodavanje");
	}
	
	// Proveravamo da li je dodat
	@After
	public void testPosle()
	{
		Stranka s = strServis.VratiStranku("249123450");
		assertNotNull(s);
		Stranka s2 = strServis.VratiStranku("21234a231");
		assertNull(s2);
		System.out.println("After:Uspesno dodata prva stranka a druga ne");
		strServis.ObrisiStranku(s.getBrojLicne());
		System.out.println("After:Sad ga brisemo");
	}
	
	@AfterClass
	public static void KrajTesta()
	{
		System.out.println("AfterClass:Kraj testa");
	}
}
