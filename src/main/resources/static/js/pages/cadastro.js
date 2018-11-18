var table;
var tableEdit;
var descTempt;

$(document).ready(function() 
{

	$("#cadastroController").click(function ()
	 {
		 save();
	 })
	 
	 openTable()
	 
});

function save()
{
	 if ($("#cadastroForm").valid())
	 {
		 $.ajax({
			 type: "POST",
			 data:  $("#cadastroForm").serializeObject(),
			 url: "/cadastro",
			 success: function(cadastro)
			 {
				 console.log(cadastro)
				 
				$('.modal-close').click(); 
				 
				 if ($("#editing").val() == "false")
			 	 { 
					 table.row.add( {
					  "nome" : cadastro.nome,
                      "cpf": cadastro.cpf ,
                      "email": cadastro.email  ,
                      "bairro": cadastro.enderecos[0].bairro,
                      "cidade": cadastro.enderecos[0].cidade,
                      "complemento": cadastro.enderecos[0].complemento,
                      "uf": cadastro.enderecos[0].uf,
                      "id": cadastro.id
					   } ).draw();
				 }
				else
				{
					 table.row({ selected:true }).data( {
						  "nome" : cadastro.nome,
	                      "cpf": cadastro.cpf ,
	                      "email": cadastro.email  ,
	                      "bairro": cadastro.enderecos[0].bairro,
	                      "cidade": cadastro.enderecos[0].cidade,
	                      "complemento": cadastro.enderecos[0].complemento,
	                      "uf": cadastro.enderecos[0].uf,
	                      "id": cadastro.id
	                  });
				}
				
				$("#editing").val("false");
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
			    "url": "/resources/json/Portuguese-Brasil.json"
			},
			
		    columns: [ 	{ data: "nome" },
		    			{ data: "cpf" },
		    			{ data: "email" },
		    			{ data: "bairro",
		    				"mRender": function(data, type, full)
		    				{
		    					if (data != undefined)
									return data;
		    					else	
		    					return full.enderecos[0].bairro;
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
		    			{ data: "uf" 
		    				,
		    				"mRender": function(data, type, full)
		    				{
		    					if (data != undefined)
									return data;
		    					return full.enderecos[0].uf;
		    				}},
		    			{ data: "complemento",
		    				"mRender": function(data, type, full)
		    				{
		    					if (data != undefined)
									return data;
		    					return full.enderecos[0].complemento;
		    				} },
		    			{ data: "id" }
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
		        	    {"targets": [ 7 ], "visible": false},
			         
		        	  ]
				})
			}
		})
}


function removerCadastro()
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


$("#cadastroForm").validate({
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





