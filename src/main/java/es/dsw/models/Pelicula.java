package es.dsw.models;

import java.sql.Date;

public class Pelicula {
	
	private int idfilm_rf;
	private String title_rf;
	private String synopsis_rf;
	private int idgenre_rf;
	private String genero;
	private String director_rf;
	private String reparto_rf;
	private int anio_rf;
	private Date datepremiere_rf;
	private int idproducer_rf;
	private String distribuidor;
	private int idcountry_rf;
	private String pais;
	private Date s_insertdate_rf;
	private Date s_updatedate_rf;
	private int s_iduser_cf;
	
	
	public Pelicula() {
		
	}
	
	
	

	public Pelicula(int idfilm_rf, String title_rf, String synopsis_rf, int idgenre_rf, String director_rf,
			String reparto_rf, int anio_rf, Date datepremiere_rf, int idproducer_rf, int idcountry_rf,
			int s_iduser_cf) {
		super();
		this.idfilm_rf = idfilm_rf;
		this.title_rf = title_rf;
		this.synopsis_rf = synopsis_rf;
		this.idgenre_rf = idgenre_rf;
		this.director_rf = director_rf;
		this.reparto_rf = reparto_rf;
		this.anio_rf = anio_rf;
		this.datepremiere_rf = datepremiere_rf;
		this.idproducer_rf = idproducer_rf;
		this.idcountry_rf = idcountry_rf;
		this.s_iduser_cf = s_iduser_cf;
	}




	public Pelicula(int idfilm_rf, String title_rf, String synopsis_rf, int idgenre_rf, String genero,
			String director_rf, String reparto_rf, int anio_rf, Date datepremiere_rf, int idproducer_rf,
			String distribuidor, int idcountry_rf, String pais, Date s_insertdate_rf, Date s_updatedate_rf,
			int s_iduser_cf) {
		this.idfilm_rf = idfilm_rf;
		this.title_rf = title_rf;
		this.synopsis_rf = synopsis_rf;
		this.idgenre_rf = idgenre_rf;
		this.genero = genero;
		this.director_rf = director_rf;
		this.reparto_rf = reparto_rf;
		this.anio_rf = anio_rf;
		this.datepremiere_rf = datepremiere_rf;
		this.idproducer_rf = idproducer_rf;
		this.distribuidor = distribuidor;
		this.idcountry_rf = idcountry_rf;
		this.pais = pais;
		this.s_insertdate_rf = s_insertdate_rf;
		this.s_updatedate_rf = s_updatedate_rf;
		this.s_iduser_cf = s_iduser_cf;
	}






	public int getIdfilm_rf() {
		return idfilm_rf;
	}


	public void setIdfilm_rf(int idfilm_rf) {
		this.idfilm_rf = idfilm_rf;
	}


	public String getTitle_rf() {
		return title_rf;
	}


	public void setTitle_rf(String title_rf) {
		this.title_rf = title_rf;
	}


	public String getSynopsis_rf() {
		return synopsis_rf;
	}


	public void setSynopsis_rf(String synopsis_rf) {
		this.synopsis_rf = synopsis_rf;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getDirector_rf() {
		return director_rf;
	}


	public void setDirector_rf(String director_rf) {
		this.director_rf = director_rf;
	}


	public String getReparto_rf() {
		return reparto_rf;
	}


	public void setReparto_rf(String reparto_rf) {
		this.reparto_rf = reparto_rf;
	}


	public int getAnio_rf() {
		return anio_rf;
	}


	public void setAnio_rf(int anio_rf) {
		this.anio_rf = anio_rf;
	}


	public Date getDatepremiere_rf() {
		return datepremiere_rf;
	}


	public void setDatepremiere_rf(Date datepremiere_rf) {
		this.datepremiere_rf = datepremiere_rf;
	}


	public String getDistribuidor() {
		return distribuidor;
	}


	public void setDistribuidor(String distribuidor) {
		this.distribuidor = distribuidor;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}




	public int getIdgenre_rf() {
		return idgenre_rf;
	}




	public void setIdgenre_rf(int idgenre_rf) {
		this.idgenre_rf = idgenre_rf;
	}




	public int getIdproducer_rf() {
		return idproducer_rf;
	}




	public void setIdproducer_rf(int idproducer_rf) {
		this.idproducer_rf = idproducer_rf;
	}




	public int getIdcountry_rf() {
		return idcountry_rf;
	}




	public void setIdcountry_rf(int idcountry_rf) {
		this.idcountry_rf = idcountry_rf;
	}






	public Date getS_insertdate_rf() {
		return s_insertdate_rf;
	}






	public void setS_insertdate_rf(Date s_insertdate_rf) {
		this.s_insertdate_rf = s_insertdate_rf;
	}






	public Date getS_updatedate_rf() {
		return s_updatedate_rf;
	}






	public void setS_updatedate_rf(Date s_updatedate_rf) {
		this.s_updatedate_rf = s_updatedate_rf;
	}






	public int getS_iduser_cf() {
		return s_iduser_cf;
	}






	public void setS_iduser_cf(int s_iduser_cf) {
		this.s_iduser_cf = s_iduser_cf;
	}
	
	
	
	

}
