var table;
var descTempt;

$(document).ready(function() {
	$("#servico-agendado-form").submit(function(event) {
		event.preventDefault();
		saveAnimal();
	})

	openTable() 
	animalMask()
});

function animalMask() {
	$('#peso').mask("#0,000", {
		reverse : true
	});
	$('#dataNascimento').mask('00/00/0000');
}

function openTable() 
{
	$
			.ajax({
				url : "getordemservico",
				success : function(obj) {
					console.log(obj)
					table = $('#servico-agendado-table')
							.DataTable(
									{
										"sPaginationType" : "full_numbers",
										data : obj,
										"language" : {
											"url" : "/resources/js/plugins/data-tables/json/Portuguese-Brasil.json"
										},
										columns : [ 
										{data : "id"}, 
										{data : "dataReservada"}, 
										{data : "status"}, 
										{data : "observacao"}, 
										{ 
							    				data: null,
							    				"mRender": function(data, type, full)
							    				{
							    					return "<a class=\"btn-floating waves-effect waves-light blue-grey\" title=\"Clique para ver os detalhes\" onclick=\"openAnimalDetails('"+data.animal.nome+"','"+data.animal.especie+"','"+data.animal.raca+"','"+data.animal.tipo+"')\">  <i class=\"mdi-action-visibility\"></i>  <\a>";                                      
							    				}
										}, 
										{ 
						    				data: null,
						    				"mRender": function(data, type, full)
						    				{
						    					var nome = data.servico.nome;
						    					var valor = data.servico.valor;
						    					return "<a class=\"btn-floating waves-effect waves-light blue-grey\" title=\"Clique para ver os detalhes\" onclick=\"openServicoDetails('"+nome+"','"+valor+"')\"> <i class=\"mdi-action-visibility\"></i> <\a>";                                      
						    				}
										},
										{ 
						    				data: null,
						    				"mRender": function(data, type, full)
						    				{
						    					var nome = data.usuario.nome;
						    					var cpf = data.usuario.cpf;
						    					var email = data.usuario.email;
						    					return "<a class=\"btn-floating waves-effect waves-light blue-grey\" title=\"Clique para ver os detalhes\" onclick=\"openUsuarioDetails('"+nome+"','"+cpf+"','"+email+"')\">  <i class=\"mdi-action-visibility\"></i>  <\a>";                                      
						    				}
										},
										{data : "dataFinalizada"}],
										dom : 'Bfrtip', // Needs button
										// container
										select : 'single',
										responsive : true,
										altEditor : true, // Enable altEditor
										buttons : [ {
											text : 'Editar',
											name : 'add' // do not change
										// name
										}],
										"columnDefs" : [ {
											"targets" : [ 0 ],
											"visible" : false
										}, ]
									})
				}
			})
}

function openServicoDetails(nome, valor)
{
	swal
	({ 
	    html:true, 
	    title:'Informações', 
	    text:'NOME: '+nome+' <br> VALOR: '+valor+' '
	});
}


function openUsuarioDetails(nome, cpf, email)
{
	swal
	({ 
	    html:true, 
	    title:'Informações', 
	    text:'NOME: '+nome+' <br> CPF: '+cpf+' <br> EMAIL: '+email+''
	});
}

function openAnimalDetails(nome, especie, raca, tipo)
{
	swal
	({ 
	    html:true, 
	    title:'Informações', 
	    text:'NOME: '+nome+' <br> ESPÉCIE: '+especie+' <br> RAÇA: '+raca+' <br> TIPO: '+tipo+' '
	});
}

//function saveAnimal() {
//	if ($("#servico-agendado-form").valid()) {
//		$('#pedigree').val(Boolean($('#pedigree').prop("checked")));
//		$('#peso').val($('#peso').val().replace(',', ''));
//
//		if ($('#pedigree').val())
//			$('#pedigree').val("Sim")
//		else
//			$('#pedigree').val("Não")
//		$
//				.ajax({
//					type : "POST",
//					data : $("#servico-agendado-form").serializeObject(),
//					url : "/cadastroanimal",
//					success : function(obj) {
//						console.log(obj)
//						if (obj != null && obj != undefined) {
//							$('#servico-agendado-form-modal').closeModal();
//							if ($("#editing").val() == "false") {
//								table.row.add({
//									"id" : obj.id,
//									"nome" : obj.nome,
//									"especie" : obj.especie,
//									"peso" : obj.peso,
//									"tipo" : obj.tipo,
//									"sexo" : obj.sexo,
//									"dataNascimento" : obj.dataNascimento,
//									"pedigree" : obj.pedigree,
//									"raca" : obj.raca,
//									"cor" : obj.cor,
//									"observacao" : obj.observacao
//								}).draw();
//								swal("Sucesso!", "O registro foi salvo!",
//										"success");
//								$("#editing").val("false");
//							} else {
//								table.row({
//									selected : true
//								}).data({
//									"id" : obj.id,
//									"nome" : obj.nome,
//									"especie" : obj.especie,
//									"peso" : obj.peso,
//									"tipo" : obj.tipo,
//									"sexo" : obj.sexo,
//									"dataNascimento" : obj.dataNascimento,
//									"pedigree" : obj.pedigree,
//									"raca" : obj.raca,
//									"cor" : obj.cor,
//									"observacao" : obj.observacao
//								});
//								$("#editing").val("false");
//								swal("Sucesso!", "O registro foi atualizado!",
//										"success");
//							}
//						} else {
//							swal("Cancelado",
//									"O serviço não pode ser salvo no sistema",
//									"error");
//						}
//					}
//				})
//	}
//}

//function animalRemove(id)
//{
//	swal({
//		title: "Você tem certeza que deseja cancelar?",
//		text: "Não será possível recuperar esse serviço após o cancelamento!",
//		type: "warning",
//		showCancelButton: true,
//		confirmButtonColor: '#DD6B55',
//		confirmButtonText: 'Sim!',
//		cancelButtonText: "Não!",
//		closeOnConfirm: false,
//		closeOnCancel: false
//	},
//	function(isConfirm)
//	{
//		if (isConfirm)
//		{
//			$.ajax({
//				type: "POST",
//				data:  {"id": id},
//				url: "animalremove",
//				success: function(obj)
//				{
//					if (obj)
//					{
//						swal("Removido!", "O registro foi cancelado!", "success");
//					} 
//					else 
//					{
//						swal("Cancelado", "O registro não pode ser removido!", "error");
//					} 
//				}})
//		}
//		else
//			swal("Cancelado", "O registro não foi removido!", "error");
//	});
//}
//
//$("#servico-agendado-form").validate({
//	rules : {
//		sexo : "required"
//	},
//	errorElement : 'div',
//	errorPlacement : function(error, element) {
//		var placement = $(element).data('error');
//		if (placement) {
//			$(placement).append(error)
//		} else {
//			error.insertAfter(element);
//		}
//	}
//});