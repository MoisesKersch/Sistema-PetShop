$(document).ready(function() 
{
	$("#suporte-form").submit(function (event)
	 {
		event.preventDefault();
		save(); 
	 })
});

function save()
{
	if ($("#suporte-form").valid())
	{
		 $.ajax({
			 type: "POST",
			 data:  $("#suporte-form").serializeObject(),
			 url: "/suporte",
			 success: function(obj)
			 {
				 if (obj != null && obj != undefined)
				 {
					 swal("Sucesso!", "Sua mensagem foi enviada!", "success");
				 }
				 else
				 {
					 swal("Cancelado", "Mensagem não pode ser enviada!", "error");
				 }
			 }
		 })
	}
}

$.validator.addMethod("valueNotEquals", function(value, element, arg){
	  return arg !== value;
}, "Este campo é obrigatório.");

$("#suporte-form").validate({
	rules: 
	{
		animalId: { valueNotEquals: "o" }
	},
	errorElement : "div",
	errorClass: "error",       
	errorElement : 'div',       
	errorPlacement: function(error, element) {
    error.appendTo( element.parent() );
  }
});







