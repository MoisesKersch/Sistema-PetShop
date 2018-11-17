<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="../tiles/templates/css.jsp"></jsp:include>
	<jsp:include page="../tiles/templates/header.jsp"></jsp:include>
	
<!--     chartist -->
    <script type="text/javascript" src="resources/js/plugins/chartist-js/chartist.min.js"></script>   

<!--     chartjs -->
    <script type="text/javascript" src="resources/js/plugins/chartjs/chart.min.js"></script>
    
</head>
<body>
<!-- body >> main >> wrapper >> content -->
<!-- START MAIN -->
<div id="main">
	<!-- START WRAPPER -->
	<div class="wrapper">
		<!-- START LEFT SIDEBAR NAV  MENU-->
			<jsp:include page="../tiles/templates/menu.jsp"></jsp:include>
		<!-- END LEFT SIDEBAR 	NAV MENU-->
		<!-- //////////////////////////////////////////////////////////////////////////// -->
		<!-- START CONTENT -->
		<section id="content">
			<!--start container-->
			<div class="container">
				<!--chart dashboard start-->
	

			</div>
			<!--end container-->
		</section>
	</div>
	<!-- END WRAPPER -->
</div>
<!-- END MAIN -->
	<!-- FOOTER -->
	<jsp:include page="../tiles/templates/footer.jsp"></jsp:include>
	<!-- SCRIPTS -->
	<jsp:include page="../tiles/templates/js.jsp"></jsp:include>
</body>
</html>