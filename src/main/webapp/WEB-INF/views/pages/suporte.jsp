<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../tiles/templates/css.jsp"></jsp:include>
<jsp:include page="../tiles/templates/header.jsp"></jsp:include>

<link href="http://cdn.datatables.net/1.10.6/css/jquery.dataTables.min.css" type="text/css" rel="stylesheet" media="screen,projection">

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
				<!--breadcrumbs start-->
				<div id="breadcrumbs-wrapper" class=" grey lighten-3">
					<div class="container">
						<div class="row">
							<div class="col s12 m12 l12">
								<h5 class="breadcrumbs-title">${mainTitle}</h5>
								<ol class="breadcrumb">
									<li><a href="index.html">Dashboard</a></li>
									<li class="active">${secondTitle}</li>
								</ol>
							</div>
						</div>
					</div>
				</div>

				<!--breadcrumbs end-->
				<!--start container-->
				<div class="container">
					<div class="section">
						<p class="caption">${caption}</p>
						<div id="contact-page" class="card">

							<div class="card-content">
								<div class="row">
									<div class="col s12 m12">
										<form class="contact-form" id="${formId}">
											<div class="row">
												<div class="input-field col s12">
													<input id="titulo" type="text" class="required" name="titulo"> <label for="first_name">Título</label>
												</div>
											</div>

											<div class="row">
												<div class="input-field col s12">
													<textarea id="mensagem" class="materialize-textarea" name="mensagem" class="required"></textarea>
													<label for="mensagem">Mensagem</label>
												</div>
												<div class="row">
													<div class="input-field col s12">
														<button class="btn cyan waves-effect waves-light right" type="submit" name="action">
															Enviar <i class="mdi-content-send right"></i>
														</button>
													</div>
												</div>
											</div>
										</form>
									</div>
									<style>
									#mensagem {
										min-height: 250px;
									}
									</style>
								</div>
							</div>
						</div>
					</div>
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
	<script type="text/javascript" src="/resources/js/pages/${js}"></script>
</body>
</html>