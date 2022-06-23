package com.jpa.entiteti;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Entity
@Table(name="sud")
public class Sud  {
	
	

	@TableGenerator(name = "sud_gen", table = "id_gen", pkColumnName = "tab_gen", valueColumnName = "id_p", allocationSize = 1, pkColumnValue = "sud_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "sud_gen")
	private int idsud;
	
	@Column(name = "naziv")
	private String naziv;
	
	@Column(name = "grad")
	private String grad;
	
	@Column(name = "adresa")
	private String adresa;
	
	@Column(name = "nivo")
	private String nivo;
	
	@Column(name = "websajt")
	private String websajt;

	public Sud() {
		
	}
	
	public Sud(String naziv, String grad, String adresa, String nivo, String websajt) {
		this.naziv = naziv;
		this.grad = grad;
		this.adresa = adresa;
		this.nivo = nivo;
		this.websajt = websajt;
	}
	
	public int getId() {
		return idsud;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNivo(String nivo) {
		this.nivo = nivo;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getNivo() {
		return nivo;
	}

	public String getWebsajt() {
		return websajt;
	}

	public void setWebsajt(String websajt) {
		this.websajt = websajt;
	}
	
	@Override
	public String toString() {
		return "ID: " + getId()+", "+"Naziv: " + getNaziv() +"Grad: " + getGrad() +"Adresa: " + getAdresa() +", Nivo: " + getNivo()+", Vebsajt: "+ getWebsajt();
	}

	
}
