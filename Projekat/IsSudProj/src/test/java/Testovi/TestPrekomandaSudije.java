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

public class TestPrekomandaSudije {

private static SudServis sudServis;
private static SudijaServis sudijaServis;  
	
	@BeforeClass
	public static void initTest()
	{
		sudServis = new SudServisImpl();
		sudijaServis = new SudijaServisImpl();
		System.out.println("BeforeClass:Inicijalizacija");
	}
	
	// Sudija sa id=1 postoji i postoji sud i sa id 2
	@Before
	public void testPre()
	{
		Sudija s = sudijaServis.VratiSudiju(1);
		assertNotNull(s);
		Sud sud = sudServis.VratiSud(1);
		assertNotNull(sud);
		System.out.println("Before: Postoje");

	}
	
	//Premesta se sudija iz suda 1 u sud 2
	@Test
	public void test()
	{
		sudijaServis.PremestiUDrugiSud(1, 1);
		System.out.println("Test:Testiramo premestanje");
	}
	
	// Proveravamo da li je uspesno premesten
	@After
	public void testPosle()
	{
		Sudija s = sudijaServis.VratiSudiju(1);
		assertTrue(s.getIdSuda() == 1);
		System.out.println("After:Uspesno premesten");
		sudijaServis.PremestiUDrugiSud(1, 2);
		System.out.println("After:Vracamo ga nazad");
	}
	
	@AfterClass
	public static void KrajTesta()
	{
		System.out.println("AfterClass:Kraj testa");
	}
}

