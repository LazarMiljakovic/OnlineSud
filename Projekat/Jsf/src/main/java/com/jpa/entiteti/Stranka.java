package com.jpa.entiteti;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "stranka")
public class Stranka implements Serializable {

	
	
	
	private static final long serialVersionUID = 4753698266419400381L;

	static final String GreskaMess= "Broj licne karte nije validan";

	@Id
	@Column(name = "brojlicne")
	private String brojLicne;

	@Column(name = "ime")
	private String ime;

	@Column(name = "prezime")
	private String prezime;
	
	@Column(name = "adresa")
	private String adresa;
	
	public Stranka() {

	}

	public Stranka(String brojLicne, String ime, String prezime,String adresa) {
		this.brojLicne = brojLicne;
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;
	}
	
	public static boolean brLicneValidan(String brojLicne)
	{
		if (brojLicne.length() != 9)
		{
			System.err.println(GreskaMess);
			return false;
		}
		else
		{
			for (int i = 0; i < brojLicne.length(); i++)
			{
				if (brojLicne.charAt(i) < '0' || brojLicne.charAt(i) > '9')
				{
					System.err.println(GreskaMess);
					return false;
				}
			}
			return true;
		}
		
	}

	public String getBrojLicne() {
		return brojLicne;
	}

	public void setBrojLicne(String brojLicne) {
		this.brojLicne = brojLicne;
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
	
	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String Adresa) {
		this.adresa = Adresa;
	}

}