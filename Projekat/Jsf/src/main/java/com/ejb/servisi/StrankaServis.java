package com.ejb.servisi;

import com.jpa.entiteti.*;
import java.util.List;

public interface StrankaServis {

	public Stranka VratiStranku(String brlicne);
	public void DodajStranku(String brojLicne,String ime,String prezime,String adresa);
	public void ObrisiStranku(String brojLicne);
	public void PodnesiTuzbu(int idSud,String idTuzilac,String idOptuzeni,String sadrzaj);
	public List<Stranka> VratiSveStranke();
	public List<Tuzba> VratiPodneteTuzbe(String idTuzilac);
	public List<Tuzba> VratiDobijeneTuzbe(String idOptuzeni);
	
}
