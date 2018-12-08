$(document).ready(function ()
{
	 Materialize.updateTextFields()
})

function send()
{
	if ($("#loginForm").valid()) 
	{
		$('#loginForm').submit();
	}
}

$("#loginForm").validate({
	rules : {
		
	},
	// For custom messages
	errorElement : "div",
	errorPlacement : function(error, element) {
		var er = error.insertAfter(element.next());

		if (er == null)
			er.insertAfter(element.next());
	}
});
