package com.gui.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.ejb.servisi.*;
import com.jpa.entiteti.*;

@ManagedBean
public class StrankaController {

	private String BrLicne;
	private String Ime;
	private String Prezime;
	private String Adresa;
	
	private int idSuda;
	private String Sadrzaj;
	
	private List<Stranka> SveStranke;
	private List<Tuzba> TuzbeStranke;
	private List<Tuzba> TuzbeProtivStranke;
	
	private String BrLicneOpt;
	
	@EJB
	private StrankaServis servis;

	public void UbaciStranku()
	{
		servis.DodajStranku(BrLicne, Ime, Prezime, Adresa);
	}
	public void BrisiStranku()
	{
		servis.ObrisiStranku(BrLicne);
		
	}
	public List<Stranka> VratiStranke()
	{
		SveStranke = servis.VratiSveStranke();
		return SveStranke;
	}
	public void PodnosenjeTuzbe()
	{
		servis.PodnesiTuzbu(idSuda, BrLicne, BrLicneOpt,Sadrzaj);
	}
	public void VratiSveTuzbe()
	{
		TuzbeStranke = servis.VratiPodneteTuzbe(BrLicne);
		TuzbeProtivStranke = servis.VratiDobijeneTuzbe(BrLicne);
	}
	
	
	//getteri i setteri
	
	public String getBrLicne() {
		return BrLicne;
		
	}

	public void setBrLicne(String brLicne) {
		BrLicne = brLicne;
		
	}

	public String getIme() {
		return Ime;
		
	}

	public void setIme(String ime) {
		Ime = ime;
		
	}

	public String getPrezime() {
		return Prezime;
		
	}

	public void setPrezime(String prezime) {
		Prezime = prezime;
		
	}

	public int getIdSuda() {
		return idSuda;
		
	}

	public void setIdSuda(int idSuda) {
		this.idSuda = idSuda;
		
	}

	public List<Tuzba> getTuzbeStranke() {
		return TuzbeStranke;
		
	}

	public void setTuzbeStranke(List<Tuzba> tuzbeStranke) {
		TuzbeStranke = tuzbeStranke;
		
	}

	public List<Tuzba> getTuzbeProtivStranke() {
		return TuzbeProtivStranke;
		
	}

	public void setTuzbeProtivStranke(List<Tuzba> tuzbeProtivStranke) {
		TuzbeProtivStranke = tuzbeProtivStranke;
		
	}

	public String getBrLicneOpt() {
		return BrLicneOpt;
		
	}

	public void setBrLicneOpt(String brLicneOpt) {
		BrLicneOpt = brLicneOpt;
		
	}


	public String getAdresa() {
		return Adresa;
		
	}


	public void setAdresa(String adresa) {
		Adresa = adresa;
		
	}
	public List<Stranka> getSveStranke() {
		return SveStranke;
	}
	public void setSveStranke(List<Stranka> sveStranke) {
		SveStranke = sveStranke;
	}
	public String getSadrzaj() {
		return Sadrzaj;
		
	}
	public void setSadrzaj(String sadrzaj) {
		Sadrzaj = sadrzaj;
		
	}
	
	
}
