package es.dsw.daos;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import es.dsw.connections.MySqlConnection;
import es.dsw.models.Pelicula;

import java.sql.Date;


public class PeliculasDao {
	
	private boolean flagError;
	private String msgError;
	
	public PeliculasDao() {
		this.flagError = false;
		this.msgError = "";
	}
	
	
	public ArrayList<Pelicula> getAll(){
		
		MySqlConnection objConection = new MySqlConnection();
		ArrayList<Pelicula> objTablaPelicula = new ArrayList<Pelicula>();
		
		try {
			objConection.open();
			
			if(!objConection.isError()) {
				ResultSet Result = objConection.executeSelect("SELECT * FROM repository_film");
				while(Result.next()) {
					Pelicula objPelicula = new Pelicula();
					
					objPelicula.setIdfilm_rf(Result.getInt("IDFILM_RF"));
					objPelicula.setTitle_rf(Result.getString("TITLE_RF"));
					objPelicula.setSynopsis_rf(Result.getString("SYNOPSIS_RF"));
					
					GenerosDao objGenerosDao = new GenerosDao();
					objPelicula.setGenero(objGenerosDao.getById(Result.getInt("IDGENRE_RF")));
					
					objPelicula.setDirector_rf(Result.getString("DIRECTOR_RF"));
					objPelicula.setReparto_rf(Result.getString("REPARTO_RF"));
					objPelicula.setAnio_rf(Result.getInt("ANIO_RF"));
					objPelicula.setDatepremiere_rf(Result.getDate("DATEPREMIERE_RF"));
					
					DistribuidoresDao objDistribuidoresDao = new DistribuidoresDao();					
					objPelicula.setDistribuidor(objDistribuidoresDao.getById(Result.getInt("IDPRODUCER_RF")));
					
					PaisesDao objPaisesDao = new PaisesDao();
					objPelicula.setPais(objPaisesDao.getById(Result.getInt("IDCOUNTRY_RF")));
					
					objTablaPelicula.add(objPelicula);
					
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
		
		return objTablaPelicula;
	}
	
	
	public void setPelicula(Pelicula objPelicula) throws ParseException {
		
		MySqlConnection objConection = new MySqlConnection();
		int idPelicula = -1;
		try {
			objConection.open();
			if(!objConection.isError()){
				String sql = "";
				if(objPelicula.getDatepremiere_rf() == null) {
					sql = "INSERT INTO repository_film "
							+ "(TITLE_RF,"
							+ "SYNOPSIS_RF,"
							+ "IDGENRE_RF,"
							+ "DIRECTOR_RF,"
							+ "REPARTO_RF,"
							+ "ANIO_RF,"
							+ "DATEPREMIERE_RF,"
							+ "IDPRODUCER_RF,"
							+ "IDCOUNTRY_RF,"
							+ "S_INSERTDATE_RF,"
							+ "S_UPDATEDATE_RF,"
							+ "S_IDUSER_CF)"
							+ "VALUES "
							+ "('"+objPelicula.getTitle_rf()+"',"
							+ " '"+objPelicula.getSynopsis_rf()+"',"
							+ " "+objPelicula.getIdgenre_rf()+","
							+ " '"+objPelicula.getDirector_rf()+"',"
							+ " '"+objPelicula.getReparto_rf()+"',"
							+ " "+objPelicula.getAnio_rf()+","
							+ " "+  objPelicula.getDatepremiere_rf()+","
							+ " "+objPelicula.getIdproducer_rf()+","
							+ " "+objPelicula.getIdcountry_rf()+","
							+ " CURRENT_TIMESTAMP,"
							+ " CURRENT_TIMESTAMP,"
							+ " "+objPelicula.getS_iduser_cf()+")";
				}else {
					
					sql = "INSERT INTO repository_film "
							+ "(TITLE_RF,"
							+ "SYNOPSIS_RF,"
							+ "IDGENRE_RF,"
							+ "DIRECTOR_RF,"
							+ "REPARTO_RF,"
							+ "ANIO_RF,"
							+ "DATEPREMIERE_RF,"
							+ "IDPRODUCER_RF,"
							+ "IDCOUNTRY_RF,"
							+ "S_INSERTDATE_RF,"
							+ "S_UPDATEDATE_RF,"
							+ "S_IDUSER_CF)"
							+ "VALUES "
							+ "('"+objPelicula.getTitle_rf()+"',"
							+ " '"+objPelicula.getSynopsis_rf()+"',"
							+ " "+objPelicula.getIdgenre_rf()+","
							+ " '"+objPelicula.getDirector_rf()+"',"
							+ " '"+objPelicula.getReparto_rf()+"',"
							+ " "+objPelicula.getAnio_rf()+","
							+ " '"+  objPelicula.getDatepremiere_rf() +"',"
							+ " "+objPelicula.getIdproducer_rf()+","
							+ " "+objPelicula.getIdcountry_rf()+","
							+ " CURRENT_TIMESTAMP,"
							+ " CURRENT_TIMESTAMP,"
							+ " "+objPelicula.getS_iduser_cf()+")";
				}
				
				//ResultSet Result = 
						objConection.executeInsert(sql);
				/*if((Result != null) && (Result.next())) {
					idPelicula = Result.getInt(1);			}*/
						
			}else {
				 this.flagError = true;
				 this.msgError = "Error en setArticulo. El objeto clsConectionMySql informa error al abrir conexión. +Info: " + objConection.msgError();
			}
			
		}catch (Exception ex) {
			this.flagError = true;
			this.msgError = "Error en setArticulo. +Info: " + ex.getMessage();
    	} finally {
			objConection.close();
    	}
	}
	
	public void deleteById(int idPelicula) {
		
		MySqlConnection objConection = new MySqlConnection();
		
		try {
			  objConection.open();
			  if (!objConection.isError()){
				  String SQL = "DELETE FROM session_film WHERE idfilm_ssf = " + idPelicula;
				  objConection.executeUpdateOrDelete(SQL);
				  SQL = "DELETE FROM repository_film WHERE idfilm_rf = " + idPelicula;
				  objConection.executeUpdateOrDelete(SQL);
			  } else {
				    this.flagError = true;
				    this.msgError = "Error en deleteAll. El objeto clsConectionMySql informa error al abrir conexión. +Info: " + objConection.msgError();
			   }
		    } catch (Exception ex) {
			       this.flagError = true;
			       this.msgError = "Error en deleteById. +Info: " + ex.getMessage();
  	    } finally {
			       objConection.close();
  	    }
		
		
	}
}

