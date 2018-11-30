
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

function servicoRemove(id)
{
	swal({
		title: "Você tem certeza que deseja cancelar?",
		text: "Não será possível recuperar esse serviço após o cancelamento!",
		type: "warning",
		showCancelButton: true,
		confirmButtonColor: '#DD6B55',
		confirmButtonText: 'Sim!',
		cancelButtonText: "Não!",
		closeOnConfirm: false,
		closeOnCancel: false
	},
	function(isConfirm)
	{
		 $.ajax({
			 type: "POST",
			 data:  {"ordemServicoId": id},
			 url: "cancelarordemservico",
			 success: function(obj)
			 {
				if (obj)
				{
				  swal("Removido!", "O serviço foi cancelado!", "success");
				} 
				else 
				{
				  swal("Cancelado", "O serviço não foi removido", "error");
				} 
			 }})
	});
}

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
			$(next_id).append($("<option></option>").attr("value", "o").text("Escolha o seu bichinho"));
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
				 var uppperButton = '<a href="#" class="btn-floating btn-large btn-price waves-effect waves-light pink accent-2" style="background-color: #00c853 !important;">'+
				 			 		'<i class="mdi-action-done-all"'+
				 			 		' style="line-height: 66.5px; font-size: 3.6rem;"></i>'+
				 			 		'</a>';
				 
				 var bottomButton = '<li>'+
				 					'<a class="btn-floating waves-effect waves-light red accent-4 cancel-order" href="#" title="Cancelar serviço" onclick="servicoRemove(\''+obj.id+'\')"><i class="mdi-content-clear"></i></a>'+
				 					'</li> <li><a class="btn-floating waves-effect waves-light light-blue" title="Ler descrição do produto"><i class="mdi-action-visibility activator"></i></a></li>';
				 	
				 $("#"+obj.servico.id+"").html(uppperButton)
				 $("#"+obj.servico.id+"-bottom-buttom").html(bottomButton)
				 $('#servico-form-modal').closeModal(); 
				 cancelOrderSweet()
			 }
		 })
	 }
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







