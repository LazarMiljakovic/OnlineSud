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
@Table(name = "tuzba")
public class Tuzba {

	
	@TableGenerator(name = "tuzba_gen", table = "id_gen", pkColumnName = "tab_gen", valueColumnName = "id_p", allocationSize = 1, pkColumnValue = "tuzba_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tuzba_gen")
	private int idtuzba;
	
	@Column(name = "idsuda")
	private int idSuda;
	
	
	@Column(name = "idsudije")
	private Integer idSudije;
	
	@Column(name = "idtuzioc")
	private String idTuzioc;
	
	@Column(name = "idoptuzen")
	private String idOptuzen;
	
	@Column(name = "sadrzaj")
	private String sadrzaj;
	
	@Column(name = "status")
	private String status;
	
	public Tuzba() {
		
	}

	public Tuzba(int idSuda, String idTuzioc, String idOptuzen,String sadrzaj, String status) {
		this.idSuda = idSuda;
		this.idTuzioc = idTuzioc;
		this.idOptuzen = idOptuzen;
		this.sadrzaj = sadrzaj;
		this.status = status;
	}

	public int getId() {
		return idtuzba;
	}
	
	public int getIdSuda() {
		return idSuda;
	}

	public void setIdSuda(int idSuda) {
		this.idSuda = idSuda;
	}
	
	public Integer getIdSudije() {
		return idSudije;
	}

	public void setIdSudije(Integer idSudije) {
		this.idSudije = idSudije;
	}

	public String getIdTuzioc() {
		return idTuzioc;
	}

	public void setIdTuzioc(String idTuzioc) {
		this.idTuzioc = idTuzioc;
	}

	public String getidOptuzen() {
		return idOptuzen;
	}

	public void setidOptuzen(String idOptuzen) {
		this.idOptuzen = idOptuzen;
	}
	
	public String getSadrzaj() {
		return sadrzaj;
	}

	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	} 

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
