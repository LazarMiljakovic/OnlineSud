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


public class TestSudDodavanje {

	private static SudServis sudServis;
	
	@BeforeClass
	public static void initTest()
	{
		sudServis = new SudServisImpl();
		System.out.println("BeforeClass:Inicijalizacija");
	}
	
	// Preduslov: Trazi se sud koji ne postoji
	@Before
	public void testPre()
	{
		Sud s = sudServis.VratiSudPoNazivu("Apelacioni sud Blace");
		assertNull(s);
		System.out.println("Before:Ne postoji sud Apelacioni sud Blace");
	}
	
	//Dodaje se sud Apelacioni sud Blace
	@Test
	public void test()
	{
		sudServis.DodajSud("Apelacioni sud Blace" , "Blace", "Marka Kraljevica 14", "Apelacioni", "www.apelacioni.bl");
		System.out.println("Test:Testiramo dodavanje");
	}
	
	// Proveravamo opet da li je dodat
	@After
	public void testPosle()
	{
		Sud s = sudServis.VratiSudPoNazivu("Apelacioni sud Blace");
		assertNotNull(s);
		System.out.println("After:Uspesno dodato");
		sudServis.ObrisiSud(s.getId());
		System.out.println("After:Sad ga brisemo");
	}
	
	@AfterClass
	public static void KrajTesta()
	{
		System.out.println("AfterClass:Kraj testa");
	}
}
