
$("#registrationForm").validate({
	 rules: {
		 	password: "required",
		 	passwordConfirm: {
		      equalTo: "#password"
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