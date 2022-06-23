package com.ejb.servisi.Impl;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.ejb.servisi.SudServis;
import com.jpa.entiteti.Sud;
import com.jpa.entiteti.Sudija;
import com.jpa.entiteti.Tuzba;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.PersistenceContext;

@Remote(SudServis.class)
@Stateless
public class SudServisImpl implements SudServis {
	
	@PersistenceContext(name = "OnlineSud")
	private EntityManager em;

	
	@Override
	public Sud VratiSud(int idSud) {
		
		Sud s = em.find(Sud.class, idSud);
		return s;
	}
	
	@Override
	public void DodajSud(String naziv, String Grad, String Adresa, String Nivo, String Websajt) {
		
		Sud s = new Sud(naziv,Grad,Adresa,Nivo,Websajt);
		//em.getTransaction().begin();
		em.persist(s);
		//em.getTransaction().commit();
	}

	@Override
	public void ObrisiSud(int idSud) {
		
		Sud s = em.find(Sud.class, idSud);
		//em.getTransaction().begin();
		em.remove(s);
		//em.getTransaction().commit();
	}

	@Override
	public void AzurirajSud(int id, String naziv, String Grad, String Adresa, String Nivo, String Websajt) {
		
		Sud s = em.find(Sud.class, id);
		//em.getTransaction().begin();
		s.setNaziv(naziv);
		s.setGrad(Grad);
		s.setAdresa(Adresa);
		s.setNivo(Nivo);
		s.setWebsajt(Websajt);
		//em.getTransaction().commit();
		
	}

	@Override
	public void PrikaziSudIzGrada(String Grad) {
		
		TypedQuery<Sud> q = em.createQuery("SELECT e FROM Sud e WHERE e.grad = '"+Grad+"'", Sud.class);
		List<Sud> sl = q.getResultList();
		System.out.println("U gradu:"+Grad+" ima:"+sl.size()+" Suda");
		
		for(Sud s : sl)
		{
			System.out.println("Id suda: "+s.getId()+" Naziv: "+s.getNaziv()+" Adresa: "+s.getAdresa()+" Nivo: "+s.getNivo()+ " Websajt suda: "+s.getWebsajt());
		}
		em.close();
	}

	@Override
	public void PrikaziSudNivoa(String nivo) {

		TypedQuery<Sud> q = em.createQuery("SELECT e FROM Sud e WHERE e.nivo = '"+nivo+"'", Sud.class);
		List<Sud> sl = q.getResultList();
		System.out.println("Sudovi nivoa: "+nivo);
		
		for(Sud s : sl)
		{
			System.out.println("Id suda: "+s.getId()+" Naziv: "+s.getNaziv()+" Grad: "+s.getGrad() +" Adresa: "+s.getAdresa()+ " Websajt suda: "+s.getWebsajt());
		}
		em.close();
		
	}

	@Override
	public Sud VratiSudPoNazivu(String naziv) {
		
		TypedQuery<Sud> q = em.createQuery("SELECT e FROM Sud e WHERE e.naziv = '"+naziv+"'", Sud.class);
		List<Sud> sl = q.getResultList();
		
		if(sl.size()!= 0)
		{
			return sl.get(0);
			
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<Sud> VratiSveSudove() {

		TypedQuery<Sud> q = em.createQuery("SELECT e FROM Sud e", Sud.class);
		List<Sud> sl = q.getResultList();
		
		return sl;
	}

	@Override
	public List<Sudija> VratiSveSudijeSuda(int idSud) {

		TypedQuery<Sudija> q = em.createQuery("SELECT e FROM Sudija e WHERE e.idSuda = '"+idSud+"'", Sudija.class);
		List<Sudija> s = q.getResultList();
		
		return s;
	}

	@Override
	public List<Tuzba> VratiSvePredateTuzbeSuda(int idSud) {

		TypedQuery<Tuzba> q = em.createQuery("SELECT e FROM Tuzba e WHERE e.idSuda = '"+idSud+"'", Tuzba.class);
		List<Tuzba> t = q.getResultList();
		
		return t;
	}

	@Override
	public void PredajTuzbuSudiji(int idSudija, int idTuzba) {

		Sudija s = em.find(Sudija.class, idSudija);
		Tuzba t = em.find(Tuzba.class, idTuzba);
		
		if(s !=null || t !=null)
		{
			if(s.getIdSuda() == t.getIdSuda())
			{	
				//em.getTransaction().begin();
				t.setIdSudije(idSudija);
				t.setStatus("Predata tuzba sudiji");
				//em.getTransaction().commit();
			}
			else
			{
				System.err.println("Sudija ne radi u tom sudu");
			}
		}
		else
		{
			System.err.println("Pogresni parametri");
		}
	}

	

}
