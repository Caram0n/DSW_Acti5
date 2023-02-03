package es.dsw.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.dsw.daos.DistribuidoresDao;
import es.dsw.daos.GenerosDao;
import es.dsw.daos.PaisesDao;
import es.dsw.daos.PeliculasDao;
import es.dsw.daos.UsuariosDao;
import es.dsw.helpers.CookieHelper;
import es.dsw.models.Distribuidor;
import es.dsw.models.Genero;
import es.dsw.models.Pais;
import es.dsw.models.Pelicula;
import es.dsw.models.Usuario;

@Controller
public class MainController {
	
	@GetMapping(value = {"/","/home"})
	public String home(Model objModel, Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
				
		
		UsuariosDao objUsuario = new UsuariosDao();
		Usuario user = objUsuario.getUserbyUsername(authentication.getName());
		ArrayList<String> userRoles = user.getRol();
		String userRol="";
		
		for (int i = 0; i < userRoles.size(); i++) {
			userRol = userRol + userRoles.get(i) + ", ";
		}
		objModel.addAttribute("User", user);
		objModel.addAttribute("Rol", userRol);
		
		
		DistribuidoresDao objDistribuidor = new DistribuidoresDao();
		ArrayList<Distribuidor> objTablaDistribuidor = objDistribuidor.getAll();
		objModel.addAttribute("Distribuidores", objTablaDistribuidor);
		
		
		GenerosDao objGenero = new GenerosDao();
		ArrayList<Genero> objTablaGenero = objGenero.getAll();	
		objModel.addAttribute("Generos", objTablaGenero);
		
		PaisesDao objPais = new PaisesDao();
		ArrayList<Pais> objTablaPais = objPais.getAll();
		objModel.addAttribute("Paises", objTablaPais);
		
		CookieHelper.saveDateTimeCookie(request, response);
		
		
		return "home";
	}
	
	@GetMapping(value = {"/login"})
	public String login(Model objModel, HttpServletRequest request, HttpServletResponse response) {		
		
		
		
		
		String objCookieData = CookieHelper.getCookieValue("ultimoAcceso", request);
		if(objCookieData != null) {
			
			String DateTime = objCookieData.replace("_", " ");
			DateTime = "Fecha del último acceso: " + DateTime;
			objModel.addAttribute("DateTime", DateTime);
		}
		
		
		return "login";
		
		
	}
	
	
	@GetMapping(value= {"/peliculas"})
	public String peliculas(Model objModel) {
		PeliculasDao objPeliculas = new PeliculasDao();
		ArrayList<Pelicula> objListaPelicula = objPeliculas.getAll();
		
		
		objModel.addAttribute("ListaPeliculas", objListaPelicula);
		
		return "peliculas";
	}
	
	
	@RequestMapping(value= {"/","/eliminarPeli"},method = RequestMethod.POST, produces="application/json")
	private void procesarDatos(HttpServletRequest request, @RequestParam("eliminar") String eliminar) {
		
			
		
		int id = Integer.parseInt(eliminar);
		
		PeliculasDao objPeliculas = new PeliculasDao();
		objPeliculas.deleteById(id);
		
				
		}
	

	
	@RequestMapping(value= {"/","/nuevaPeli"},method = RequestMethod.POST)
	public String nuevaPeli(Authentication authentication, @RequestParam("titulo") String titulo, @RequestParam(name="sinopsis", required=false) String sinopsis, @RequestParam(name="genero", defaultValue="-1") int genero, @RequestParam(name="director", required=false) String director, @RequestParam(name="reparto", required=false) String reparto, @RequestParam(name="anyo", defaultValue="-1") int anyo, @RequestParam(name="estreno", required=false, defaultValue="0000-00-00") String estreno, @RequestParam(name="distribuidor", required=false, defaultValue="-1") int distribuidor, @RequestParam(name="pais", defaultValue="-1") int pais, Model objModel) throws ParseException {
		
				java.sql.Date sqlDate;
				if(estreno == "0000-00-00") {
					sqlDate = null;
				}else {
					java.util.Date utilDate =  new SimpleDateFormat("yyyy-MM-dd").parse(estreno);
					 sqlDate = new java.sql.Date(utilDate.getTime());
				}
		
		String mensaje = "";
		boolean error = false;
		
		UsuariosDao objUsuario = new UsuariosDao();
		Usuario user = objUsuario.getUserbyUsername(authentication.getName());
		int idUser = user.getIduser_usf();
		
		if(titulo !="" && genero!=-1 && anyo!=-1 && pais!=-1) {
			Pelicula pelicula = new Pelicula();
			pelicula.setTitle_rf(titulo);
			pelicula.setSynopsis_rf(sinopsis);
			pelicula.setIdgenre_rf(genero);
			pelicula.setDirector_rf(director);
			pelicula.setReparto_rf(reparto);
			pelicula.setAnio_rf(anyo);
			
			pelicula.setDatepremiere_rf(sqlDate);
			
			pelicula.setIdproducer_rf(distribuidor);
			pelicula.setIdcountry_rf(pais);
			pelicula.setS_iduser_cf(idUser);
			
			PeliculasDao objPeliculas = new PeliculasDao();
			objPeliculas.setPelicula(pelicula);
			
			
			
			
			mensaje= mensaje + "La película se ha creado correctamente";
			error = false;
		}
		if(titulo == "") {
			mensaje = mensaje + "Debe introducir el título de la película. ";
			error = true;
		}
		if(genero == -1) {
			mensaje = mensaje + "Debe introducir el género de la película. ";
			error = true;
		}
		if(anyo == -1) {
			mensaje = mensaje + "Debe introducir el año de la película. ";
			error = true;
		}
		if(pais == -1) {
			mensaje = mensaje + "Debe introducir el país de la película. ";
			error = true;
		}
		
		
		
		objModel.addAttribute("mensaje",mensaje);
		objModel.addAttribute("error",error);

		
		return "nuevaPeli";
	
	}
}


