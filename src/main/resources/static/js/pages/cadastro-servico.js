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
						 "id": obj.id,
						 "valor" : obj.valor,
						 "nome": obj.nome,
						 "descricao": obj.descricao,
						 "categoria": obj.servicoCategoria[0].nome
					   } ).draw();
					 
					 $("#editing").val("false");
				 }
				else
				{
					 table.row({ selected:true }).data( {
						  "id": obj.id,
						  "valor" : obj.valor,
	                      "nome": obj.nome,
	                      "descricao": obj.descricao,
	                      "categoria": obj.servicoCategoria[0].nome
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
				 servicoCategoriaDropDownFill();
				 
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

function servicoCategoriaDropDownFill()
{
	$.ajax({
		url: "getcategorias",
		success: function (obj)
		{
			var next_id = $("#servico-categoria-select");
			$(next_id).empty();
			$(next_id).append($("<option></option>").attr("value", "o").text("Categoria"));
			$.each(obj, function(key, value) {
				$(next_id).append($("<option></option>").attr("value", value.id).text(value.nome));
			});
			$(next_id).material_select();
		}
	})
}

function openTableCategoria()
{
	$.ajax({
		url: "getcategorias",
		success: function (obj)
		{
			console.log(obj)
			// popular o drop fucking down 
			servicoCategoriaDropDownFill();
			
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
			
		    columns: [ 	
		    			{ data: "id" },
		    			{ data: "valor" },
		    			{ data: "nome" },
		    			{ data: "descricao" },
		    			{ data: "categoria",
		    				"mRender": function(data, type, full)
		    				{
		    					if (data != undefined)
									return data;
		    					else	
		    					return full.servicoCategoria.nome;
		    				}
		    			},
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
			 
			 servicoCategoriaDropDownFill()
		 }})
}

$.validator.setDefaults({
    ignore: []
});

$.validator.addMethod("valueNotEquals", function(value, element, arg){
	  return arg !== value;
}, "Este campo é obrigatório.");

$("#cadastroServicoForm").validate({
	rules: 
	{
		categoriaId: { valueNotEquals: "o" }
	},
	errorElement : "div",
    errorClass: "error",       
    errorElement : 'div',       
    errorPlacement: function(error, element) {
        error.appendTo( element.parent() );
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





