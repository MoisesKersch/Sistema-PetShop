
var table;
var tableEdit;
var descTempt;

$(document).ready(function() 
{
	 $("#servico-form").submit(function (event)
	 {
		event.preventDefault();
		saveservico();
	 })
	 
	 servicoDropDownFill()
	
	 $('#timepicker').mdtimepicker({format: 'hh:mm'}); //Initializes the time picker
});

function servicoMask()
{
    $('#peso').mask("#0,000", {reverse: true});
	$('#dataNascimento').mask('00/00/0000');
}

function servicoDropDownFill()
{
	$.ajax({
		url: "getanimaisservico",
		success: function (obj)
		{
			var next_id = $("#servico-animal-select");
			$(next_id).empty();
			$(next_id).append($("<option></option>").attr("value", "o").text("Escolha o servico"));
			$.each(obj, function(key, value) {
				$(next_id).append($("<option></option>").attr("value", value.id).text(value.nome));
			});
			$(next_id).material_select();
		}
	})
}

function setServicoId(id)
{
	$("#servico-id").val(id)
}

function saveservico()
{
	 if ($("#servico-form").valid())
	 {
		 var dataReservada = ""+$("#date").val()+" "+$("#timepicker").val(); 
		 $('#dataReservada').val(dataReservada);

		 $.ajax({
			 type: "POST",
			 data:  $("#servico-form").serializeObject(),
			 url: "/servicos",
			 success: function(obj)
			 {
				 console.log(obj)
				 $('#servico-form-modal').closeModal(); 
			 }
		 })
	 }
}

function servicoRemove()
{
	 $.ajax({
		 type: "POST",
		 data:  {"id": $('#servico-remove-id').val()},
		 url: "servicoremove",
		 success: function(obj)
		 {
			 table.row({
                 selected : true
               }).remove();
			 table.draw();
		 }})
}

$.validator.addMethod("valueNotEquals", function(value, element, arg){
	  return arg !== value;
}, "Este campo é obrigatório.");

$("#servico-form").validate({
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






