var initialSize;

$(document).ready(function() 
{
	$('#ultimo-agendado-size').removeClass("notification-badge")
	$('#ultimo-agendado-size-new').removeClass("new badge")
	
	$.ajax({
		type : "POST",
		url : "admin/ultimoagendado",
		success : function(obj) 
		{
			if (obj == null || obj == undefined || obj.length == 0)
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
				
				var headerUrl = '<li>'+
								'  <h5>'+
								'     NOTIFICATIONS <span class="new badge" data-badge-caption="Novas" id="ultimo-agendado-size-new">'+obj.length+'</span>'+
								'</h5>'+
								'</li>'+
								'<li class="divider"></li>';
				
				$("#notifications-dropdown").append(headerUrl);
				
				$($("#notifications-dropdown").children()[1]).nextAll().remove()
				var agendados = '';
				$.each( obj, function( index, value )
				{
					var time = dateDiff(new Date(value.lancadoEm), new Date());
					
					agendados+=  '   <li>  '  + 
								 '   	<a href="servicoagendadoadmin">  '  + 
								 '   		<i class="mdi-action-add-shopping-cart"></i>   '  + 
								 '   			Um novo serviço foi agendado!  '  + 
								 '   	</a>   '  + 
								 '   		<time class="media-meta"> '+time+' minutos atrás'+ 
								 '   		</time> '+ 
								 '  </li>  ' ; 
				});
				
				$("#notifications-dropdown").append(agendados);
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
				if (obj == null || obj == undefined || obj.length == 0)
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
					
					var headerUrl = '<li>'+
									'  <h5>'+
									'     NOTIFICATIONS <span class="new badge" data-badge-caption="Novas" id="ultimo-agendado-size-new">'+obj.length+'</span>'+
									'</h5>'+
									'</li>'+
									'<li class="divider"></li>';
					
					$("#notifications-dropdown").append(headerUrl);
					
					$($("#notifications-dropdown").children()[1]).nextAll().remove()
					var agendados = '';
					$.each( obj, function( index, value )
					{
						
						var time = dateDiff(new Date(value.lancadoEm), new Date());
						
						agendados+=  '   <li>  '  + 
									 '   	<a href="#!">  '  + 
									 '   		<i class="mdi-action-add-shopping-cart"></i>   '  + 
									 '   			Um novo serviço foi agendado!  '  + 
									 '   	</a>   '  + 
									 '   		<time class="media-meta"> '+time+' minutos atrás'+ 
									 '   		</time> '+ 
									 '  </li>  ' ; 
						
					});
					
					$("#notifications-dropdown").append(agendados);
				}
			}
		});
	}, 10000);
})

function dateDiff(startTime, endTime) 
{
	var endDate = new Date();
	var minutes = parseInt(Math.abs(endDate.getTime() - startTime.getTime()) / (1000 * 60) % 60);
	return minutes;
}

function getTimeDifference(earlierDate, laterDate) 
{
    var oDiff = new Object();

    //  Calculate Differences
    //  -------------------------------------------------------------------  //
    var nTotalDiff = laterDate.getTime() - earlierDate.getTime();

    oDiff.days = Math.floor(nTotalDiff / 1000 / 60 / 60 / 24);
    nTotalDiff -= oDiff.days * 1000 * 60 * 60 * 24;

    oDiff.hours = Math.floor(nTotalDiff / 1000 / 60 / 60);
    nTotalDiff -= oDiff.hours * 1000 * 60 * 60;

    oDiff.minutes = Math.floor(nTotalDiff / 1000 / 60);
    nTotalDiff -= oDiff.minutes * 1000 * 60;

    oDiff.seconds = Math.floor(nTotalDiff / 1000);
    //  -------------------------------------------------------------------  //

    //  Format Duration
    //  -------------------------------------------------------------------  //
    //  Format Hours
    var hourtext = '00';
    if (oDiff.days > 0){ hourtext = String(oDiff.days);}
    if (hourtext.length == 1){hourtext = '0' + hourtext};

    //  Format Minutes
    var mintext = '00';
    if (oDiff.minutes > 0){ mintext = String(oDiff.minutes);}
    if (mintext.length == 1) { mintext = '0' + mintext };

    //  Format Seconds
    var sectext = '00';
    if (oDiff.seconds > 0) { sectext = String(oDiff.seconds); }
    if (sectext.length == 1) { sectext = '0' + sectext };

    //  Set Duration
    var sDuration = hourtext + ':' + mintext + ':' + sectext;
    oDiff.duration = sDuration;
    //  -------------------------------------------------------------------  //

    return oDiff;
}