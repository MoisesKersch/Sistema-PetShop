Materialize.toast('I am a toast!', 9000, 'red') 

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
