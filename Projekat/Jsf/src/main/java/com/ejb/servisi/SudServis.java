package com.ejb.servisi;

import com.jpa.entiteti.*;
import java.util.List;

public interface SudServis {
	
	public Sud VratiSud(int idSud);
	public void DodajSud(String naziv,String Grad,String Adresa,String Nivo,String Websajt);
	public void ObrisiSud(int idSud);
	public void AzurirajSud(int id,String naziv,String Grad,String Adresa,String Nivo,String Websajt);
	public void PrikaziSudIzGrada(String Grad);
	public void PrikaziSudNivoa(String nivo);
	public Sud VratiSudPoNazivu(String naziv);
	public List<Sud> VratiSveSudove();
	public List<Sudija> VratiSveSudijeSuda(int idSud);
	public List<Tuzba> VratiSvePredateTuzbeSuda(int idSud);
	public void PredajTuzbuSudiji(int idSudija,int idTuzba);
	

}
