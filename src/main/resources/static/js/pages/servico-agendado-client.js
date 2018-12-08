var table;;
var descTempt;
var valorTotal = 0;

$(document).ready(function() {
	$("#servico-agendado-form").submit(function(event) {
		event.preventDefault();
		saveAnimal();
	})

	openTable()
	
	$('.dt-button').click(function (){
		console.log('hi')
	})
	
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
				url : "getordemservicocliente",
				success : function(obj) {
					console.log(obj)
					$.each( obj, function( key, value ) {
							valorTotal+=value.servico.valor;
					});
					$("#valor-total").html("R$ "+valorTotal);
					table = $('#servico-agendado-client-table')
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
							    					return "<a class=\"waves-effect waves-light \" title=\"Clique para ver os detalhes\" onclick=\"openAnimalDetails('"+data.animal.nome+"','"+data.animal.especie+"','"+data.animal.raca+"','"+data.animal.tipo+"')\">  <i class=\"mdi-content-add-circle-outline\"></i>  <\a>";                                      
							    				}
										}, 
										{ 
						    				data: null,
						    				"mRender": function(data, type, full)
						    				{
						    					var nome = data.servico.nome;
						    					var valor = data.servico.valor;
						    					valorTotal += valor;
						    					return "<a class=\"waves-effect waves-light \" title=\"Clique para ver os detalhes\" onclick=\"openServicoDetails('"+nome+"','"+valor+"')\"> <i class=\"mdi-content-add-circle-outline\"></i> <\a>";                                      
						    				}
										},
										{ 
						    				data: null,
						    				"mRender": function(data, type, full)
						    				{
						    					return data.servico.valor;
						    				}
										},
										{ 
						    				data: null,
						    				"mRender": function(data, type, full)
						    				{
						    					return 	'<input type="checkbox" id='+data.id+' value='+data.servico.valor+' class="sum">'+
						    							'	<label for='+data.id+'><a href="#" class="secondary-content">'+
						    							'</label>';
						    				}
										}
										],
										  dom: 'Bfrtip',        // Needs button container
								          select: 'single',
								          responsive: true,
								          altEditor: true,     // Enable altEditor
								          buttons: [{
								            text: 'Pagar Selecionados',
								            name: 'add'        // do not change name
								          }
								        ],
										// container
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
	    title:'', 
	    text: 	'<div class="col s12 m12 l4">'+
		'	<ul id="task-card" class="collection with-header">'+
		'		<li class="collection-header cyan">'+
		'			<h4 class="task-card-title">Informações</h4>'+
		'		</li>'+
		'		<li class="collection-item dismissable" style="touch-action: pan-y; -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">'+
		'			Nome: '+nome+''+
		'		<span class="task-cat teal"></span>'+
		'		</li>'+
		'		<li class="collection-item dismissable" style="touch-action: pan-y; -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">'+
		'			Valor: R$ '+valor+''+
		'		<span class="task-cat teal"></span>'+
		'		</li>'+
		'	</ul>'+
		'</div>'
	});
}


function openUsuarioDetails(nome, cpf, email)
{
	swal
	({ 
	    html:true, 
	    title:'', 
	    text: 	'<div class="col s12 m12 l4">'+
		'	<ul id="task-card" class="collection with-header">'+
		'		<li class="collection-header cyan">'+
		'			<h4 class="task-card-title">Informações</h4>'+
		'		</li>'+
		'		<li class="collection-item dismissable" style="touch-action: pan-y; -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">'+
		'			Nome: '+nome+''+
		'		<span class="task-cat teal"></span>'+
		'		</li>'+
		'		<li class="collection-item dismissable" style="touch-action: pan-y; -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">'+
		'			Espécie: '+cpf+''+
		'		<span class="task-cat teal"></span>'+
		'		</li>'+
		'		<li class="collection-item dismissable" style="touch-action: pan-y; -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">'+
		'			Raça: '+email+''+
		'		<span class="task-cat teal"></span>'+
		'		</li>'+
		'	</ul>'+
		'</div>'
	    
	});
}

function openAnimalDetails(nome, especie, raca, tipo)
{
	swal
	({ 
	    html:true, 
	    title:'', 
	    text: 	'<div class="col s12 m12 l4">'+
				'	<ul id="task-card" class="collection with-header">'+
				'		<li class="collection-header cyan">'+
				'			<h4 class="task-card-title">Informações</h4>'+
				'		</li>'+
				'		<li class="collection-item dismissable" style="touch-action: pan-y; -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">'+
				'			Nome: '+nome+''+
				'		<span class="task-cat teal"></span>'+
				'		</li>'+
				'		<li class="collection-item dismissable" style="touch-action: pan-y; -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">'+
				'			Espécie: '+especie+''+
				'		<span class="task-cat teal"></span>'+
				'		</li>'+
				'		<li class="collection-item dismissable" style="touch-action: pan-y; -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">'+
				'			Raça: '+raca+''+
				'		<span class="task-cat teal"></span>'+
				'		</li>'+
				'		<li class="collection-item dismissable" style="touch-action: pan-y; -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">'+
				'			Tipo: '+tipo+''+
				'		<span class="task-cat teal"></span>'+
				'		</li>'+
				'	</ul>'+
				'</div>'
	    
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