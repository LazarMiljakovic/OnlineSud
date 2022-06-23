package com.gui.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.ejb.servisi.*;
import com.jpa.entiteti.*;

@ManagedBean
public class SudijaController {

	
	private int id;
	private String Ime;
	private String Prezime;
	private int IdSuda;
	
	private Sudija sudija;
	private List<Sudija> sveSudije;
	private List<Tuzba> DodeljeneTuzbe;
	
	private int idTuzbe;
	private int idSudPremestanje;
	private String status;
	private List<String> statusi;
	

	@PostConstruct
	public void init()
	 {
		  statusi = new ArrayList<>();
		  statusi.add("Prihvacena");
		  statusi.add("Odbijena");
		  status = statusi.get(0);
	 }
	
	@EJB
	private SudijaServis servis;
	
	public void UbaciSudiju()
	{
		servis.DodajSudiju(Ime, Prezime, IdSuda);
	}
	public void BrisiSudiju()
	{
		servis.ObrisiSudiju(id);
	}
	public void IzmeniSudiju()
	{
		servis.AzurirajSudiju(id, Ime, Prezime);
	}
	public void PrekomandaSudije()
	{
		servis.PremestiUDrugiSud(id, idSudPremestanje);
	}
	public void VratiSudiju()
	{
		sudija = servis.VratiSudiju(id);
	}
	public List<Sudija> VratiSudije()
	{
		sveSudije = servis.VratiSveSudije();
		return sveSudije;
	}
	public List<Tuzba> VratiTuzbe()
	{
		DodeljeneTuzbe = servis.VratiSveTuzbeSudije(id);
		return DodeljeneTuzbe;
	}
	public void PromeniStatus()
	{
		servis.PromeniStatusTuzbe(id, idTuzbe, status);;
	}
	
	
	// Geteri i setteri

	public int getId() {
		return id;
		
	}

	public void setId(int id) {
		this.id = id;
		
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
		return IdSuda;
		
	}

	public void setIdSuda(int idSuda) {
		IdSuda = idSuda;
		
	}

	public List<Sudija> getSveSudije() {
		return sveSudije;
		
	}

	public void setSveSudije(List<Sudija> sveSudije) {
		this.sveSudije = sveSudije;
		
	}

	public List<Tuzba> getDodeljeneTuzbe() {
		return DodeljeneTuzbe;
		
	}

	public void setDodeljeneTuzbe(List<Tuzba> dodeljeneTuzbe) {
		DodeljeneTuzbe = dodeljeneTuzbe;
		
	}

	public String getStatus() {
		return status;
		
	}

	public void setStatus(String status) {
		this.status = status;
		
	}
	public int getIdSudPremestanje() {
		return idSudPremestanje;
		
	}
	public void setIdSudPremestanje(int idSudPremestanje) {
		this.idSudPremestanje = idSudPremestanje;
		
	}
	public Sudija getSudija() {
		return sudija;
		
	}
	public void setSudija(Sudija sudija) {
		this.sudija = sudija;
		
	}
	public int getIdTuzbe() {
		return idTuzbe;
	}
	public void setIdTuzbe(int idTuzbe) {
		this.idTuzbe = idTuzbe;
	}
	public List<String> getStatusi() {
		return statusi;
		
	}
	public void setStatusi(List<String> statusi) {
		this.statusi = statusi;
		
	}
}
