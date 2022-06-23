package com.ejb.servisi.Impl;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.ejb.servisi.SudServis;
import com.ejb.servisi.SudijaServis;
import com.jpa.entiteti.Sud;
import com.jpa.entiteti.Sudija;
import com.jpa.entiteti.Tuzba;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.PersistenceContext;


@Remote(SudijaServis.class)
@Stateless
public class SudijaServisImpl implements SudijaServis {

	@PersistenceContext(name = "OnlineSud")
	private EntityManager em;

	
	
	
	@Override
	public void DodajSudiju(String ime, String prezime, int idSuda) {

		Sud s = em.find(Sud.class, idSuda);
		if (s != null)
		{
			Sudija sja = new Sudija(ime,prezime,idSuda);
			//em.getTransaction().begin();
			em.persist(sja);
			//em.getTransaction().commit();
			
		}
		else
		{
			System.err.println("Sud ne postoji");
		}
		
	}

	@Override
	public void ObrisiSudiju(int idSudija) {

		Sudija s = em.find(Sudija.class, idSudija);
		if(s != null)
		{
			//em.getTransaction().begin();
			em.remove(s);
			//em.getTransaction().commit();
		}
		else
		{
			System.err.println("Sudija ne postoji");
		}
	}

	@Override
	public void AzurirajSudiju(int idSudija, String ime, String prezime) {

		Sudija s = em.find(Sudija.class,idSudija);
		//em.getTransaction().begin();
		s.setIme(ime);
		s.setPrezime(prezime);
		//em.getTransaction().commit();
	}

	@Override
	public void PremestiUDrugiSud(int idSudija, int idSuda) {

		Sudija s = em.find(Sudija.class,idSudija);
		//em.getTransaction().begin();
		s.setIdSuda(idSuda);
		//em.getTransaction().commit();
	}

	@Override
	public List<Sudija> VratiSveSudije() {
		
		TypedQuery<Sudija> q = em.createQuery("SELECT e FROM Sudija e", Sudija.class);
		List<Sudija> sl = q.getResultList();
		
		return sl;
	}

	@Override
	public List<Tuzba> VratiSveTuzbeSudije(int idSudija) {
		TypedQuery<Tuzba> q = em.createQuery("SELECT e FROM Tuzba e WHERE e.idSudije = '"+idSudija+"'", Tuzba.class);
		List<Tuzba> tl = q.getResultList();
		
		return tl;
	}

	@Override
	public void PromeniStatusTuzbe(int idSudija, int idTuzba, String status) {
		
		Sudija s = em.find(Sudija.class, idSudija);
		Tuzba t = em.find(Tuzba.class, idTuzba);
		
		if(s !=null || t !=null)
		{
			if(t.getStatus() == "Preuzeta od suda")
			{
				System.err.println("Jos nije predata sudiji");
				return;
			}
			if(s.getIdSuda() == t.getIdSuda())
			{	
				if(status.equals("Prihvacena")||status.equals("Odbijena"))
				{
					//em.getTransaction().begin();
					t.setStatus(status);
					//em.getTransaction().commit();
				}
				else
				{
					System.err.println("Pogresno napisan status");
				}
				
			}
			else
			{
				System.err.println("Taj sudija nije zaduzen za taj predmet");
			}
		}
		else
		{
			System.err.println("Pogresni parametri");
		}

	}


	@Override
	public Sudija VratiSudiju(int id) {
		
		
		return em.find(Sudija.class, id);
	}

}
