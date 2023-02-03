package es.dsw.models;

import java.util.Date;

public class Distribuidor {
	
	private int idproducer_pf;
	private String producer_pf;
	private Date s_insertDate_pf;
	private Date s_updateDate_pf;
	private int s_idUser_pf;
	
	
	public Distribuidor() {
	}


	public Distribuidor(int idproducer_pf, String producer_pf, Date s_insertDate_pf, Date s_updateDate_pf,
			int s_idUser_pf) {
		this.idproducer_pf = idproducer_pf;
		this.producer_pf = producer_pf;
		this.s_insertDate_pf = s_insertDate_pf;
		this.s_updateDate_pf = s_updateDate_pf;
		this.s_idUser_pf = s_idUser_pf;
	}


	public int getIdproducer_pf() {
		return idproducer_pf;
	}


	public void setIdproducer_pf(int idproducer_pf) {
		this.idproducer_pf = idproducer_pf;
	}


	public String getProducer_pf() {
		return producer_pf;
	}


	public void setProducer_pf(String producer_pf) {
		this.producer_pf = producer_pf;
	}


	public Date getS_insertDate_pf() {
		return s_insertDate_pf;
	}


	public void setS_insertDate_pf(Date s_insertDate_pf) {
		this.s_insertDate_pf = s_insertDate_pf;
	}


	public Date getS_updateDate_pf() {
		return s_updateDate_pf;
	}


	public void setS_updateDate_pf(Date s_updateDate_pf) {
		this.s_updateDate_pf = s_updateDate_pf;
	}


	public int getS_idUser_pf() {
		return s_idUser_pf;
	}


	public void setS_idUser_pf(int s_idUser_pf) {
		this.s_idUser_pf = s_idUser_pf;
	}
	
	
	
	
	
}
