$(document).ready(function() 
{
	$.ajax({
		type : "POST",
		url : "admin/ultimoagendado",
		success : function(obj) 
		{
			if (obj == null || obj == undefined)
			{
				$('#ultimo-agendado-size').removeClass("notification-badge")
				$('#ultimo-agendado-size-new').removeClass("new badge")
			}
				
			if (obj.length >= 1)
			{
				$('#ultimo-agendado-size').addClass("notification-badge")
				$('#ultimo-agendado-size-new').addClass("new badge")
				$('#ultimo-agendado-size').html(obj.length)
				$('#ultimo-agendado-size-new').html(obj.length)
			}
		}
	});
	
	setInterval(function() 
	{
		$.ajax({
			type : "POST",
			url : "admin/ultimoagendado",
			success : function(obj) 
			{
				if (obj == null || obj == undefined)
				{
					$('#ultimo-agendado-size').removeClass("notification-badge")
					$('#ultimo-agendado-size-new').removeClass("new badge")
				}
					
				if (obj.length >= 1)
				{
					$('#ultimo-agendado-size').addClass("notification-badge")
					$('#ultimo-agendado-size-new').addClass("new badge")
					$('#ultimo-agendado-size').html(obj.length)
					$('#ultimo-agendado-size-new').html(obj.length)
				}
			}
		});
	}, 10000);
})