function send()
{
	if ($("#registrationForm").valid()) 
	{
		$('#registrationForm').submit();
	}
}

$("#registrationForm").validate({
	rules : {
		senha : "required",
		passwordConfirm : {
			equalTo : "#senha"
		}
	},
	// For custom messages
	errorElement : "div",
	errorPlacement : function(error, element) {
		var er = error.insertAfter(element.next());

		if (er == null)
			er.insertAfter(element.next());

	}
});
