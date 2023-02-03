package es.dsw.models;

import java.util.Date;

public class Pais {
	
	private int idcountry_cf;
	private String country_cf;
	private Date s_insertdate_cf;
	private Date s_updatedate_cf;
	private int s_iduser_cf;
	
	
	public Pais() {
	}


	public Pais(int idcountry_cf, String country_cf, Date s_insertdate_cf, Date s_updatedate_cf, int s_iduser_cf) {
		this.idcountry_cf = idcountry_cf;
		this.country_cf = country_cf;
		this.s_insertdate_cf = s_insertdate_cf;
		this.s_updatedate_cf = s_updatedate_cf;
		this.s_iduser_cf = s_iduser_cf;
	}


	public int getIdcountry_cf() {
		return idcountry_cf;
	}


	public void setIdcountry_cf(int idcountry_cf) {
		this.idcountry_cf = idcountry_cf;
	}


	public String getCountry_cf() {
		return country_cf;
	}


	public void setCountry_cf(String country_cf) {
		this.country_cf = country_cf;
	}


	public Date getS_insertdate_cf() {
		return s_insertdate_cf;
	}


	public void setS_insertdate_cf(Date s_insertdate_cf) {
		this.s_insertdate_cf = s_insertdate_cf;
	}


	public Date getS_updatedate_cf() {
		return s_updatedate_cf;
	}


	public void setS_updatedate_cf(Date s_updatedate_cf) {
		this.s_updatedate_cf = s_updatedate_cf;
	}


	public int getS_iduser_cf() {
		return s_iduser_cf;
	}


	public void setS_iduser_cf(int s_iduser_cf) {
		this.s_iduser_cf = s_iduser_cf;
	}
	
	
	

}
