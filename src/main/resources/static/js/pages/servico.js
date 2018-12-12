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
		
		if (isConfirm) 
		{
			$.ajax({
				type: "POST",
				data:  {"ordemServicoId": id},
				url: "cancelarordemservico",
				success: function(obj)
				{
					if (obj)
					{
						swal("Removido!", "O registro foi cancelado!", "success");
						var uppperButton =  '<a href="#" class="btn-floating btn-large btn-price waves-effect waves-light pink accent-2"> R$ '+obj.valor+' </a>';
						
						
						var bottomButton =  '<li>'+
											'	<a class="btn-floating waves-effect waves-light green accent-4 modal-trigger" title="Agendar serviço" onclick="setServicoId(\''+obj.id+'\')">'+
											'		<i class="mdi-editor-attach-money"></i>'+
											'	</a>'+
											'</li>'+
											'<li>'+
											'	<a class="btn-floating waves-effect waves-light light-blue" title="Ler descrição do produto">'+
											'		<i class="mdi-action-visibility activator"></i>'+
											'	</a>'+
											'</li>';
						
						$("#"+obj.id+"").html(uppperButton)
						$("#"+obj.id+"-bottom-buttom").html(bottomButton)
					} 
					else 
					{
						swal("Cancelado", "O registro não pode ser removido!", "error");
					} 
				}})
		}
		else
		{
			swal("Cancelado", "O registro não foi removido!", "error");
		}
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
	$('#servico-form-modal').openModal();
	$('#servico-form')[0].reset();
	$('#timepicker').val('');
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
				if (obj != null && obj != undefined)
				{
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
					 
					 swal("Successo!", "O serviço foi agendado com sucesso!", "success");
					 
//					 cancelOrderSweet()
				} 
				else 
				{
				  swal("Cancelado", "O serviço não foi agendado", "error");
				} 
				
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
