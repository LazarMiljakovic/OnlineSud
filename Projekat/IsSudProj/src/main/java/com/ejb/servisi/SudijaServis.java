package com.ejb.servisi;

import com.jpa.entiteti.*;
import java.util.List;

public interface SudijaServis {
	
	public Sudija VratiSudiju(int id);
	public void DodajSudiju(String ime, String prezime, int idSuda);
	public void ObrisiSudiju(int idSudija);
	public void AzurirajSudiju(int idSudija,String ime, String prezime);
	public void PremestiUDrugiSud(int idSudija,int idSuda);
	public List<Sudija> VratiSveSudije();
	public List<Tuzba> VratiSveTuzbeSudije(int idSudija);
	public void PromeniStatusTuzbe(int idSudija,int idTuzba,String status);

}
