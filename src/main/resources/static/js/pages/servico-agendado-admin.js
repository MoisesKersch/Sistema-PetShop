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
				type: "POST",
				url : "servicoagendadoadmin",
				success : function(obj) {
					console.log(obj)
					table = $('#servico-agendado-admin-table')
							.DataTable(
									{
										"sPaginationType" : "full_numbers",
										data : obj,
										"language" : {
											"url" : "/resources/js/plugins/data-tables/json/Portuguese-Brasil.json"
										},
										deferRender: true,
									    scrollY:     300,
									    scroller:    true,
										columns : [ 
										{data : "id"}, 
										{data : "dataReservada"}, 
										{data : "status"}, 
										{data : "observacao"}, 
										{ 
							    				data: null,
							    				"mRender": function(data, type, full)
							    				{
							    					return "<a class=\"waves-effect waves-light\" title=\"Clique para ver os detalhes\" onclick=\"openAnimalDetails('"+data.animal.nome+"','"+data.animal.especie+"','"+data.animal.raca+"','"+data.animal.tipo+"')\">  <i class=\"mdi-content-add-circle-outline\"></i>  <\a>";                                      
							    				}
										}, 
										{ 
						    				data: null,
						    				"mRender": function(data, type, full)
						    				{
						    					var nome = data.servico.nome;
						    					var valor = data.servico.valor;
						    					return "<a class=\"waves-effect waves-light\" title=\"Clique para ver os detalhes\" onclick=\"openServicoDetails('"+nome+"','"+valor+"')\"> <i class=\"mdi-content-add-circle-outline\"></i> <\a>";                                      
						    				}
										},
										{ 
						    				data: null,
						    				"mRender": function(data, type, full)
						    				{
						    					var nome = data.usuario.nome;
						    					var cpf = data.usuario.cpf;
						    					var email = data.usuario.email;
						    					return "<a class=\"waves-effect waves-light\" title=\"Clique para ver os detalhes\" onclick=\"openUsuarioDetails('"+nome+"','"+cpf+"','"+email+"')\">  <i class=\"mdi-content-add-circle-outline get-bigger-button\"></i>  <\a>";                                      
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
				'			CPF: '+cpf+''+
				'		<span class="task-cat teal"></span>'+
				'		</li>'+
				'		<li class="collection-item dismissable" style="touch-action: pan-y; -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">'+
				'			Email: '+email+''+
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
				'			Raca: '+raca+''+
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
