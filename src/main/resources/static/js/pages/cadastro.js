var table;
var tableEdit;
var descTempt;

$(document).ready(function() 
{
	$("#cadastro-form").submit(function (event)
	 {
		event.preventDefault();
		cadastroFormSave(); 
	 })
	 
	 openTable()
	 
	 $('#cpf').mask('000.000.000-00', {reverse: true});
	
	 $('#uf').mask('AA', {
		    translation: {
		      'A': {
		        pattern: /[A-Za-z]/, optional: true
		      }
		    }
	});
});

function cadastroFormSave()
{
	 if ($("#cadastro-form").valid())
	 {
		 $("#cpf").val( $("#cpf").val().replace(/[^0-9]+/g, "") );
		 
		 $.ajax({
			 type: "POST",
			 data:  $("#cadastro-form").serializeObject(),
			 url: "/cadastro",
			 success: function(cadastro)
			 {
				 console.log(cadastro)
				 $('#cadastro-form-modal').closeModal(); 
				 
				 if ($("#editing").val() == "false")
			 	 { 
					 table.row.add( {
						 "id": cadastro.id,
						 "nome" : cadastro.nome,
						 "cpf": cadastro.cpf ,
						 "email": cadastro.email,
						 "rua": cadastro.enderecos[0].rua,
						 "numero": cadastro.enderecos[0].numero,
						 "bairro": cadastro.enderecos[0].bairro,
						 "complemento": cadastro.enderecos[0].complemento,
						 "cidade": cadastro.enderecos[0].cidade,
						 "uf": cadastro.enderecos[0].uf,
						 "login": cadastro.login,
						 "senha": cadastro.senha
					   } ).draw();
					 
					 $("#editing").val("false");
				 }
				else
				{
					 table.row({ selected:true }).data( {
						 "id": cadastro.id,
						 "nome" : cadastro.nome,
						 "cpf": cadastro.cpf ,
						 "email": cadastro.email,
						 "rua": cadastro.enderecos[0].rua,
						 "numero": cadastro.enderecos[0].numero,
						 "bairro": cadastro.enderecos[0].bairro,
						 "complemento": cadastro.enderecos[0].complemento,
						 "cidade": cadastro.enderecos[0].cidade,
						 "uf": cadastro.enderecos[0].uf,
						 "login": cadastro.login,
						 "senha": cadastro.senha
	                  });
					 
					 $("#editing").val("false");
				}
			 }
		 })
	 }
}

function openTable()
{
	$.ajax({
		url: "getcadastro",
		success: function (cadastros)
		{
			console.log(cadastros)
			table = $('#cadastro').DataTable({
		    "sPaginationType": "full_numbers",
		    data: cadastros,
			"language": {
			    "url": "/resources/js/plugins/data-tables/json/Portuguese-Brasil.json"
			},
			deferRender: true,
		    scrollY:     300,
		    scroller:    true,
		    columns: [ 	
		    			{ data: "id" },
		    			{ data: "nome" },
		    			{ data: "cpf" },
		    			{ data: "email" },
		    			{ data: "rua",
		    				"mRender": function(data, type, full)
		    				{
		    					if (data != undefined)
									return data;
		    					else	
		    					return full.enderecos[0].rua;
		    				}
		    			},
		    			{ data: "numero",
		    				"mRender": function(data, type, full)
		    				{
		    					if (data != undefined)
									return data;
		    					else	
		    					return full.enderecos[0].numero;
		    				}
		    			},
		    			{ data: "bairro",
		    				"mRender": function(data, type, full)
		    				{
		    					if (data != undefined)
									return data;
		    					else	
		    					return full.enderecos[0].bairro;
		    				}
		    			},
		    			{ data: "complemento",
		    				"mRender": function(data, type, full)
		    				{
		    					if (data != undefined)
									return data;
		    					return full.enderecos[0].complemento;
		    				}
		    			},
		    			{ data: "cidade",
		    				"mRender": function(data, type, full)
		    				{
		    					if (data != undefined)
									return data;
		    					return full.enderecos[0].cidade;
		    				}
		    			},
		    			{ data: "uf" ,
		    				"mRender": function(data, type, full)
		    				{
		    					if (data != undefined)
									return data;
		    					return full.enderecos[0].uf;
		    				}
		    			},
		    			{ data: "login"},
		    			{ data: "senha"}
		    		  ],
		    	  dom: 'Bfrtip',        // Needs button container
		          select: 'single',
		          responsive: true,
		          altEditor: true,     // Enable altEditor
		          buttons: [{
		            text: 'Adicionar',
		            name: 'add'        // do not change name
		          },
		          {
		            extend: 'selected', // Bind to Selected row
		            text: 'Editar',
		            name: 'edit'        // do not change name
		          },
		          {
		            extend: 'selected', // Bind to Selected row
		            text: 'Remover',
		            name: 'delete'      // do not change name
		         }],
		         "columnDefs": [
		        	    {"targets": [ 0 ], "visible": false},
		        	  ]
				})
			}
		})
}

function cadastroFormRemover()
{
	 $.ajax({
		 type: "POST",
		 data:  {"id": $('#remove').val()},
		 url: "removercadastro",
		 success: function(reuniao)
		 {
			 table.row({
                 selected : true
               }).remove();
			 table.draw();
		 }})
}

$("#cadastro-form").validate({
	rules : {
		senha : "required",
		passwordConfirm : {
			equalTo : "#senha"
		},
		cpf : {
			required : true,
			remote : {
				url : "public/iscpfcnpjvalido",
				type : "POST",
				data : {
					"entrada" : function() {
						return $("#cpf").val()
					}
				},
				dataFilter : function(response)
				{
					var response = jQuery.parseJSON(response);
					currentMessage = response.Message;
					
					if (response) {
						return true;
					}
					
					return false;
				}
			}
		},
		login : {
			required : true,
			remote : {
				url : "public/isusuarioexiste",
				type : "POST",
				data : {
					"entrada" : function() {
						return $("#login").val()
					},
					"usuarioId" : function() {
						return $("#id").val()
					}
				},
				dataFilter : function(response)
				{
					var response = jQuery.parseJSON(response);
					currentMessage = response.Message;
					
					if (response) {
						return false;
					}
					return true;
				}
			}
		}
	},
	
	messages: {
		login: "Usuário já existente no sistema!", 
		cpf: "CPF inválido!"
    },
    
	errorElement : "div",
	errorPlacement : function(error, element) {
		var er = error.insertAfter(element.next());

		if (er == null)
			er.insertAfter(element.next());

	}
});

