package com.gui.controllers;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import com.ejb.servisi.*;
import com.jpa.entiteti.*;

@ManagedBean
public class SudController {

	// dodavanje inputi
	private int IdSuda;
	private String Naziv = "";
	private String Grad = "";
	private String Adresa= "";
	private String Nivo = "";
	private String WebSajt="";
	
	private int IdTuzbe;
	private int IdSudije;
	
	private Sud Azrsud;
	private List<Tuzba> tuzbe;
	private List<Sudija> Sudije;
	private List<Sud> SviSudovi;
	
	@EJB
	private SudServis servis;
	
	public void UbaciSud()
	{
		servis.DodajSud(Naziv,Grad,Adresa,Nivo,WebSajt);
	}
	
	public void BrisiSud()
	{
		servis.ObrisiSud(IdSuda);
	}
	
	public void UpdateSuda()
	{
		servis.AzurirajSud(Azrsud.getId(), Azrsud.getNaziv(), Azrsud.getGrad(), Azrsud.getAdresa(), Azrsud.getNivo(), Azrsud.getWebsajt());
	}
	
	public List<Sud> VratiSveSudove()
	{
		
		setSviSudovi(servis.VratiSveSudove());
		return SviSudovi;
	}
	
	public void VratiSudijeSuda()
	{
		setSudije(servis.VratiSveSudijeSuda(IdSuda));
	}
	
	public void dajTuzbuSudiji()
	{
		servis.PredajTuzbuSudiji(IdSudije, IdTuzbe);
	}
	
	public void VratiPreuzeteTuzbe()
	{
		setTuzbe(servis.VratiSvePredateTuzbeSuda(IdSuda));
	}
	public Sud vratiSudijuZaAzr()
	{
		Azrsud = servis.VratiSud(IdSuda);
		
		return Azrsud;
	}
	
	
	
	//getSet
	
	public int getIdSuda()
	{
		return IdSuda;
	}
	
	public void setIdSuda(int idSuda)
	{
		this.IdSuda = idSuda;
	}
	
	public String getNaziv()
	{
		return Naziv;
	}
	
	public void setNaziv(String Naziv)
	{
		this.Naziv = Naziv;
	}
	public String getAdresa()
	{
		return Adresa;
	}
	
	public void setAdresa(String Adresa)
	{
		this.Adresa = Adresa;
	}
	public String getGrad()
	{
		return Grad;
	}
	
	public void setGrad(String Grad)
	{
		this.Grad = Grad;
	}
	
	public String getNivo()
	{
		return Nivo;
	}
	
	public void setNivo(String Nivo)
	{
		this.Nivo = Nivo;
	}
	
	public String getWebSajt()
	{
		return WebSajt;
	}
	
	public void setWebSajt(String WebSajt)
	{
		this.WebSajt = WebSajt;
	}

	public List<Tuzba> getTuzbe() {
		return tuzbe;
		
	}

	public void setTuzbe(List<Tuzba> tuzbe) {
		this.tuzbe = tuzbe;
		
	}

	public List<Sud> getSviSudovi() {
		return SviSudovi;
		
	}

	public void setSviSudovi(List<Sud> sviSudovi) {
		SviSudovi = sviSudovi;
		
	}

	public List<Sudija> getSudije() {
		return Sudije;
		
	}

	public void setSudije(List<Sudija> sudije) {
		Sudije = sudije;
		
	}
	
	public int getIdTuzbe()
	{
		return IdTuzbe;
	}
	
	public void setIdTuzbe(int IdTuzbe)
	{
		this.IdTuzbe = IdTuzbe;
	}
	
	public int getIdSudije()
	{
		return IdSudije;
	}
	
	public void setIdSudije(int IdSudije)
	{
		this.IdSudije = IdSudije;
	}

	public Sud getAzrsud() {
		return Azrsud;
		
	}

	public void setAzrsud(Sud azrsud) {
		Azrsud = azrsud;
		
	}

	
	
	
}
