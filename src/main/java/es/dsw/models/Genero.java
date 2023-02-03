package es.dsw.models;

import java.util.Date;

public class Genero {
	
	private int idgenre_gf;
	private String genre_gf;
	private Date s_insertdate_gf;
	private Date s_updatedate_gf;
	private int s_iduser_gf;
	
	
	public Genero() {
	}


	public Genero(int idgenre_gf, String genre_gf, Date s_insertdate_gf, Date s_updatedate_gf, int s_iduser_gf) {
		this.idgenre_gf = idgenre_gf;
		this.genre_gf = genre_gf;
		this.s_insertdate_gf = s_insertdate_gf;
		this.s_updatedate_gf = s_updatedate_gf;
		this.s_iduser_gf = s_iduser_gf;
	}


	public int getIdgenre_gf() {
		return idgenre_gf;
	}


	public void setIdgenre_gf(int idgenre_gf) {
		this.idgenre_gf = idgenre_gf;
	}


	public String getGenre_gf() {
		return genre_gf;
	}


	public void setGenre_gf(String genre_gf) {
		this.genre_gf = genre_gf;
	}


	public Date getS_insertdate_gf() {
		return s_insertdate_gf;
	}


	public void setS_insertdate_gf(Date s_insertdate_gf) {
		this.s_insertdate_gf = s_insertdate_gf;
	}


	public Date getS_updatedate_gf() {
		return s_updatedate_gf;
	}


	public void setS_updatedate_gf(Date s_updatedate_gf) {
		this.s_updatedate_gf = s_updatedate_gf;
	}


	public int getS_iduser_gf() {
		return s_iduser_gf;
	}


	public void setS_iduser_gf(int s_iduser_gf) {
		this.s_iduser_gf = s_iduser_gf;
	}
	
	
	
	
	
	

}
