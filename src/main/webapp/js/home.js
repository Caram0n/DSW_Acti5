//Se sobrecarga el botón toggle
$(function() {
    // Sidebar toggle behavior
    $('#sidebarCollapse').on('click', function() {
      $('#sidebar, #content').toggleClass('active');
    });
    $("#btnMiPerfil").on("click", function(){
	$location.reload();
})

  });

  //Se sobrecarga botón de Guardar de ventana modal y carga de sección del menú
  $(document).ready(function(){
    $('body').on('click', '#GuardarPelicula', function(){
      //En esta zona debería ubicarse la llamada asíncrona al servidor enviando los datos de la nueva película
      	
      	var data_titulo = $("#formTitulo").val();
      	var data_sinopsis = $("#formSinopsis").val();
      	var data_genero = $("#formGenero").val();
      	var data_director = $("#formDirector").val();
      	var data_reparto = $("#formReparto").val();
      	var data_anyo = $("#formAnyo").val();
      	var data_estreno = $("#formEstreno").val();
      	var data_distribuidor = $("#formDistribuidor").val();
      	var data_pais = $("#formPais").val();
      	
      	$("#error").html("");
      	
      	let token = $("meta[name='_csrf']").attr("content");
		let header = $("meta[name='_csrf_header']").attr("content");
      	
      	$.ajax({
			url:"./nuevaPeli",
			method: "POST",
			data:{titulo: data_titulo, sinopsis: data_sinopsis, genero: data_genero, director: data_director, reparto:data_reparto, anyo: data_anyo, estreno: data_estreno, distribuidor: data_distribuidor, pais: data_pais},
			beforeSend: request => request.setRequestHeader(header, token),
			success: function(resultText){
					$("#error").html(resultText);
				if(data_titulo!="" && data_genero!="" && data_anyo!="" && data_pais!=""){
	    			setTimeout(() => {
	    			$("#cerrarForm").trigger("click");
	    			$("#newFilmForm").trigger("reset");
	    			//$("#NuevaPeliculaCenter").modal('hide');
	    			//$('body').removeClass('modal-open'); //eliminamos la clase del body para poder hacer scroll
	    			//$('.modal-backdrop').remove();//eliminamos el backdrop del modal
					$("#seccion01").load("./peliculas");	
					$("#error").html("");
					}, "1000")
				}
			},
			error: function(jqXHR, exception) {
			$('#error').html('<p>Ha ocurrido un error fatal.</p>');
		}
			
		})
  		
		
		
    })

    $('body').on('click', '#IdListarPeliculas', function(){

      $("#seccion01").load("./peliculas");
    })
  })
  
  

  
