var table;
var tableCategoria;
var tableEdit;
var descTempt;

$(document).ready(function() 
{
	$("#cadastroServicoController").click(function ()
	 {
		 save();
	 })
	 
	 $("#cadastro-servico-categoria-controller").click(function ()
	 {
		 saveCategoria();
	 })
	 
	 openTable()
	 openTableCategoria()
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

function saveCategoria()
{
	 if ($("#servico-categoria-form").valid())
	 {
		 $.ajax({
			 type: "POST",
			 data:  $("#servico-categoria-form").serializeObject(),
			 url: "/cadastrocategoria",
			 success: function(obj)
			 {
				 console.log(obj)
				 $('#servico-categoria-form-modal').closeModal(); 
				 
				 if ($("#editing-servico-categoria").val() == "false")
			 	 { 
					 tableCategoria.row.add( {
					  "nome" : obj.nome,
                      "descricao": obj.descricao,
                      "id": obj.id
					   } ).draw();
					 
					 $("#editing-servico-categoria").val("false");
				 }
				else
				{
					tableCategoria.row({ selected:true }).data( {
					  "nome" : obj.nome,
                      "descricao": obj.descricao,
                      "id": obj.id
	                  });
					 
					 $("#editing-servico-categoria").val("false");
				}
			 }
		 })
	 }
}

function openTableCategoria()
{
	$.ajax({
		url: "getcategorias",
		success: function (obj)
		{
			console.log(obj)
			tableCategoria = $('#servico-categoria-table').DataTable({
		    "sPaginationType": "full_numbers",
		    data: obj,
			"language": {
			    "url": "/resources/js/plugins/data-tables/json/Portuguese-Brasil.json"
			},
			
		    columns: [ 	{ data: "nome" },
		    			{ data: "descricao" },
		    			{ data: "id" }],
		    	  dom: 'Bfrtip',        // Needs button container
		          select: 'single',
		          responsive: true,
		          altEditor: true,     // Enable altEditor
		          buttons: [{
		            text: 'Adicionar',
		            name: 'add-categoria'        // do not change name
		          },
		          {
		            extend: 'selected', // Bind to Selected row
		            text: 'Editar',
		            name: 'edit-categoria'        // do not change name
		          },
		          {
		            extend: 'selected', // Bind to Selected row
		            text: 'Remover',
		            name: 'delete-categoria'      // do not change name
		         }],
		         "columnDefs": [
		        	    {"targets": [ 2 ], "visible": false},
		        	  ]
				})
			}
		})
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
		 success: function(obj)
		 {
			 table.row({
                 selected : true
               }).remove();
			 table.draw();
		 }})
}

function removerCategoria()
{
	 $.ajax({
		 type: "POST",
		 data:  {"id": $('#servico-categoria-remove-id').val()},
		 url: "removercategoria",
		 success: function(obj)
		 {
			 tableCategoria.row({
                 selected : true
               }).remove();
			 tableCategoria.draw();
		 }})
}

$("#cadastroServicoForm").validate({
	errorElement : "div",
	errorPlacement : function(error, element) {
		var er = error.insertAfter(element.next());

		if (er == null)
			er.insertAfter(element.next());

	}
});

$("#servico-categoria-form").validate({
	errorElement : "div",
	errorPlacement : function(error, element) {
		var er = error.insertAfter(element.next());

		if (er == null)
			er.insertAfter(element.next());

	}
});





