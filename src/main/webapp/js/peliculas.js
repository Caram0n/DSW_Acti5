
$(document).ready(function(){
	
	$(".eliminar").click(function(){
	console.log("id " + $(this).attr("data"));
		
	
		let token = $("meta[name='_csrf']").attr("content");
		let header = $("meta[name='_csrf_header']").attr("content");
		
		var idPeli=$(this).attr("data");
		
		$.ajax({
			type: "POST",
			url:"./eliminarPeli",
			data: "eliminar="+idPeli,
			dataType:"json",
			beforeSend: request => request.setRequestHeader(header, token),

		})
		setTimeout(() => {
			$("#seccion01").load("./peliculas");			
		}, "1000")
	})
	
})


