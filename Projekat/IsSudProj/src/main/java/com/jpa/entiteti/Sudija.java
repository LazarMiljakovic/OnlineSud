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
@Table(name = "sudija")
public class Sudija {
	
	
	@TableGenerator(name = "sudija_gen", table = "id_gen", pkColumnName = "tab_gen", valueColumnName = "id_p", allocationSize = 1, pkColumnValue = "sudija_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "sudija_gen")
	private int idsudija;
	
	@Column(name = "ime")
	private String ime;
	
	@Column(name = "prezime")
	private String prezime;
	
	@Column(name = "idsuda")
	private int idSuda;
	
	public Sudija() {
		
	}
	
	public Sudija(String ime, String prezime, int idSuda) {
		this.ime = ime;
		this.prezime = prezime;
		this.idSuda = idSuda;
	}
	
	public int getId() {
		return idsudija;
	}
	
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public int getIdSuda() {
		return idSuda;
	}

	public void setIdSuda(int idSuda) {
		this.idSuda = idSuda;
	}
	
}