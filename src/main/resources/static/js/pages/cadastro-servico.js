var table;
var tableEdit;
var descTempt;

$(document).ready(function() 
{
	$("#cadastroServicoController").click(function ()
	 {
		 save();
	 })
	 
	 openTable()
});

function save()
{
	 if ($("#cadastroServicoForm").valid())
	 {
		 $.ajax({
			 type: "POST",
			 data:  $("#cadastroServicoForm").serializeObject(),
			 url: "/cadastroservico",
			 success: function(obj)
			 {
				 console.log(obj)
				 $('#cadastroServicoFormModal').closeModal(); 
				 
				 if ($("#editing").val() == "false")
			 	 { 
					 table.row.add( {
					  "valor" : obj.valor,
                      "nome": obj.nome,
                      "descricao": obj.descricao,
                      "tipo": obj.tipo,
                      "id": obj.id
					   } ).draw();
					 
					 $("#editing").val("false");
				 }
				else
				{
					 table.row({ selected:true }).data( {
						  "valor" : obj.valor,
	                      "nome": obj.nome,
	                      "descricao": obj.descricao,
	                      "tipo": obj.tipo,
	                      "id": obj.id
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
		url: "getservicos",
		success: function (obj)
		{
			console.log(obj)
			table = $('#servico').DataTable({
		    "sPaginationType": "full_numbers",
		    data: obj,
			"language": {
			    "url": "/resources/js/plugins/data-tables/json/Portuguese-Brasil.json"
			},
			
		    columns: [ 	{ data: "valor" },
		    			{ data: "nome" },
		    			{ data: "descricao" },
		    			{ data: "tipo" },
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
		        	    {"targets": [ 4 ], "visible": false},
		        	  ]
				})
			}
		})
}

function remover()
{
	 $.ajax({
		 type: "POST",
		 data:  {"id": $('#remove').val()},
		 url: "removerservico",
		 success: function(reuniao)
		 {
			 table.row({
                 selected : true
               }).remove();
			 table.draw();
		 }})
}

$("#cadastroServicoForm").validate({
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





