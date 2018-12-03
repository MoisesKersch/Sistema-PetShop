var table;
var descTempt;

$(document).ready(function() {
	$("#animal-form").submit(function(event) {
		event.preventDefault();
		saveAnimal();
	})

	openTableAnimal()
	animalMask()
});

function animalMask() {
	$('#peso').mask("#0,000", {
		reverse : true
	});
	$('#dataNascimento').mask('00/00/0000');
}

function openTableAnimal() {
	$
			.ajax({
				url : "getanimais",
				success : function(obj) {
					console.log(obj)

					table = $('#animal-table')
							.DataTable(
									{
										"sPaginationType" : "full_numbers",
										data : obj,
										"language" : {
											"url" : "/resources/js/plugins/data-tables/json/Portuguese-Brasil.json"
										},
										columns : [ {
											data : "id"
										}, {
											data : "nome"
										}, {
											data : "especie"
										}, {
											data : "peso"
										}, {
											data : "tipo"
										}, {
											data : "sexo"
										}, {
											data : "dataNascimento"
										}, {
											data : "pedigree"
										}, {
											data : "raca"
										}, {
											data : "cor"
										}, {
											data : "observacao"
										} ],
										dom : 'Bfrtip', // Needs button
										// container
										select : 'single',
										responsive : true,
										altEditor : true, // Enable altEditor
										buttons : [ {
											text : 'Adicionar',
											name : 'add' // do not change
										// name
										}, {
											extend : 'selected', // Bind to
											// Selected
											// row
											text : 'Editar',
											name : 'edit' // do not change
										// name
										}, {
											extend : 'selected', // Bind to
											// Selected
											// row
											text : 'Remover',
											name : 'delete' // do not change
										// name
										} ],
										"columnDefs" : [ {
											"targets" : [ 0 ],
											"visible" : false
										}, ]
									})
				}
			})
}

function saveAnimal() {
	if ($("#animal-form").valid()) {
		$('#pedigree').val(Boolean($('#pedigree').prop("checked")));
		$('#peso').val($('#peso').val().replace(',', ''));

		if ($('#pedigree').val())
			$('#pedigree').val("Sim")
		else
			$('#pedigree').val("Não")
		$
				.ajax({
					type : "POST",
					data : $("#animal-form").serializeObject(),
					url : "/cadastroanimal",
					success : function(obj) {
						console.log(obj)
						if (obj != null && obj != undefined) {
							$('#animal-form-modal').closeModal();
							if ($("#editing").val() == "false") {
								table.row.add({
									"id" : obj.id,
									"nome" : obj.nome,
									"especie" : obj.especie,
									"peso" : obj.peso,
									"tipo" : obj.tipo,
									"sexo" : obj.sexo,
									"dataNascimento" : obj.dataNascimento,
									"pedigree" : obj.pedigree,
									"raca" : obj.raca,
									"cor" : obj.cor,
									"observacao" : obj.observacao
								}).draw();
								swal("Sucesso!", "O registro foi salvo!",
										"success");
								$("#editing").val("false");
							} else {
								table.row({
									selected : true
								}).data({
									"id" : obj.id,
									"nome" : obj.nome,
									"especie" : obj.especie,
									"peso" : obj.peso,
									"tipo" : obj.tipo,
									"sexo" : obj.sexo,
									"dataNascimento" : obj.dataNascimento,
									"pedigree" : obj.pedigree,
									"raca" : obj.raca,
									"cor" : obj.cor,
									"observacao" : obj.observacao
								});
								$("#editing").val("false");
								swal("Sucesso!", "O registro foi atualizado!",
										"success");
							}
						} else {
							swal("Cancelado",
									"O serviço não pode ser salvo no sistema",
									"error");
						}

					}
				})
	}
}

function animalRemove(id)
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
				data:  {"id": id},
				url: "animalremove",
				success: function(obj)
				{
					if (obj)
					{
						swal("Removido!", "O registro foi cancelado!", "success");
					} 
					else 
					{
						swal("Cancelado", "O registro não pode ser removido!", "error");
					} 
				}})
		}
		else
			swal("Cancelado", "O registro não foi removido!", "error");
	});
}

$("#animal-form").validate({
	rules : {
		sexo : "required"
	},
	errorElement : 'div',
	errorPlacement : function(error, element) {
		var placement = $(element).data('error');
		if (placement) {
			$(placement).append(error)
		} else {
			error.insertAfter(element);
		}
	}
});