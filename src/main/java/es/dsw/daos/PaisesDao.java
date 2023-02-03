package es.dsw.daos;

import java.sql.ResultSet;
import java.util.ArrayList;

import es.dsw.connections.MySqlConnection;
import es.dsw.models.Pais;

public class PaisesDao {

	
	private boolean flagError;
	private String msgError;
	
	
	public PaisesDao() {
		this.flagError = false;
		this.msgError = "";
	}
	
	
	public String getById(int idPais) {
		String Pais = "";
		
		MySqlConnection objConection = new MySqlConnection();
		
		try {
			objConection.open();
			if(!objConection.isError()){
				ResultSet Result = objConection.executeSelect("SELECT * FROM country_film WHERE idcountry_cf = "+ idPais);
				
				while(Result.next()) {
					Pais objPais = new Pais();
					objPais.setCountry_cf(Result.getString("COUNTRY_CF"));
					
					Pais = objPais.getCountry_cf();
				}
			}else {
				this.flagError = true;
				this.msgError = "Error en getOnce. El objeto MySqlConnection informa error al abrir conexión. +Info: " + objConection.msgError();
			}
			
		} catch (Exception ex) {
			this.flagError = true;
			this.msgError = "Error en getById. +Info: " + ex.getMessage();
		} finally {
			objConection.close();
		}
		
		return Pais;
	}
	
	
public ArrayList<Pais> getAll(){
		
		MySqlConnection objConection = new MySqlConnection();
		ArrayList<Pais> objTablaPais = new ArrayList<Pais>();
		
		
		try {
			objConection.open();
			if(!objConection.isError()) {
				ResultSet Result = objConection.executeSelect("SELECT * FROM country_film");
				while(Result.next()) {
					Pais objPais = new Pais();
					
					objPais.setIdcountry_cf(Result.getInt("IDCOUNTRY_CF"));
					objPais.setCountry_cf(Result.getString("COUNTRY_CF"));
					
					objTablaPais.add(objPais);
				}			
			}else {
				this.flagError = true;
				this.msgError = "Error en getAll. El objeto clsConectionMysql informa error al abrir conexión. +Info: " + objConection.msgError();
			}
		}catch (Exception ex) {
			this.flagError = true;
			this.msgError = "Error en getAll. +Info: " + ex.getMessage();
		}finally {
			objConection.close();
		}
		
		return objTablaPais;
	}
}
