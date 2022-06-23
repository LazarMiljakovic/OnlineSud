package com.ejb.servisi.Impl;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.ejb.servisi.StrankaServis;
import com.ejb.servisi.SudijaServis;
import com.jpa.entiteti.Stranka;
import com.jpa.entiteti.Sudija;
import com.jpa.entiteti.Tuzba;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.PersistenceContext;

@Remote(StrankaServis.class)
@Stateless
public class StrankaServisImpl implements StrankaServis {

	@PersistenceContext(name = "OnlineSud")
	private EntityManager em;

	public StrankaServisImpl() {
		
		em = Persistence.createEntityManagerFactory("OnlineSud").createEntityManager();
	}
	
	
	
	@Override
	public void DodajStranku(String brojLicne, String ime, String prezime, String adresa) {

		if(Stranka.brLicneValidan(brojLicne))
		{
			Stranka s = new Stranka(brojLicne,ime,prezime,adresa);
			em.getTransaction().begin();
			em.persist(s);
			em.getTransaction().commit();
			
		}
		else
		{
			System.err.println("Nije validna licna karta");
		}
	}

	@Override
	public void ObrisiStranku(String brojLicne) {
		
		Stranka s = em.find(Stranka.class, brojLicne);
		if(s != null)
		{
			em.getTransaction().begin();
			em.remove(s);
			em.getTransaction().commit();
		}
		else
		{
			System.err.println("Ne postoji stranka");
		}

	}

	@Override
	public void PodnesiTuzbu(int idSud, String idTuzilac, String idOptuzeni, String sadrzaj) {

		Tuzba t = new Tuzba(idSud,idTuzilac,idOptuzeni,sadrzaj,"Preuzeta od suda");
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}

	@Override
	public List<Stranka> VratiSveStranke() {
		
		TypedQuery<Stranka> q = em.createQuery("SELECT e FROM Stranka e", Stranka.class);
		List<Stranka> sl = q.getResultList();
		
		return sl;
	}

	@Override
	public List<Tuzba> VratiPodneteTuzbe(String idTuzilac) {
		
		TypedQuery<Tuzba> q = em.createQuery("SELECT e FROM Tuzba e WHERE e.idTuzioc = '"+idTuzilac+"'", Tuzba.class);
		List<Tuzba> sl = q.getResultList();
		
		
		
		return sl;
	}

	@Override
	public List<Tuzba> VratiDobijeneTuzbe(String idOptuzeni) {
		
		TypedQuery<Tuzba> q = em.createQuery("SELECT e FROM Tuzba e WHERE e.idOptuzen = '"+idOptuzeni+"'", Tuzba.class);
		List<Tuzba> sl = q.getResultList();
		
		
		return sl;
	}


	@Override
	public Stranka VratiStranku(String brlicne) {
		Stranka s = em.find(Stranka.class, brlicne);
		return s;
	}

	

}
