<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../tiles/templates/css.jsp"></jsp:include>
<jsp:include page="../tiles/templates/header.jsp"></jsp:include>


<%-- <link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/agendacontato.css" />"> --%>

<link
	href="http://cdn.datatables.net/1.10.6/css/jquery.dataTables.min.css"
	type="text/css" rel="stylesheet" media="screen,projection">


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
								<h5 class="breadcrumbs-title">Serviço</h5>
								<ol class="breadcrumb">
									<li><a href="index.html">Dashboard</a></li>
									<li class="active">Serviço</li>
								</ol>
							</div>
						</div>
					</div>
				</div>
				<!--breadcrumbs end-->
				<!--start container-->
				<div class="container">
					<div class="section">
						<p class="caption">Cadastre, remova e altere serviços
							cadastrados no seu sistema.</p>
						<div class="divider"></div>
						<!--DataTables example-->
						<div id="table-datatables">
							<h4 class="header">Cadastrar Serviços</h4>
							<div class="row">
								<div class="col s12 ">
									<table id="servico" class=" hoverable centered responsive-table striped"> 
										<thead>
											<tr>
												<th>Valor</th>
												<th>Nome</th>
												<th>Descrição</th>
												<th>Tipo</th>
												<th>Id</th>
											</tr>
										</thead>
										<tbody>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<input id="editing" class="hide" name="editing" type="text"
							value="false">
					</div>
					
					<div class="section">
						<div class="divider"></div>
						<!--DataTables example-->
						<div id="table-datatables">
							<h4 class="header">Cadastro de Categoria de Serviços</h4>
							<div class="row">
								<div class="col s12 ">
									<table id="categoriaservico" class="responsive-table hoverable">
										<thead>
											<tr>
												<th>Valor</th>
												<th>Nome</th>
												<th>Descrição</th>
												<th>Tipo</th>
												<th>Id</th>
											</tr>
										</thead>
										<tbody>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--end container-->
			</section>

			<div id="cadastroServicoFormModal" class="modal">
				<div class="modal-content">
					<h4>Cadastro Serviço</h4>
					<div class="row">
						<form class="col s12" id="cadastroServicoForm">

							<div class="row modal-form-row">
								<div class="input-field col s12">
									<input id="valor" type="text" class="required" name="valor">
									<label for="valor">Valor</label>
								</div>
							</div>

							<div class="row">
								<div class="input-field col s12">
									<input id="nome" type="text" class="required" name="nome">
									<label for="nome">Nome</label>
								</div>
							</div>

							<div class="row">
								<div class="input-field col s12">
									<input id="tipo" type="text" class="required" name="tipo">
									<label for="tipo">Tipo</label>
								</div>
							</div>

							<div class="row">
								<div class="input-field col s12">
									<input id="descricao" type="text" class="required"
										name="descricao"> <label for="descricao">Descrição</label>
								</div>
							</div>

							<input id="id" class="hide" name="id" type="text">

							<div class="row">
								<div class="input-field col s12">
									<button
										class="modal-action modal-close btn  waves-effect waves-light left"
										type="button">
										Fechar <i class="mdi-content-undo left"></i>
									</button>
									<button class="btn cyan waves-effect waves-light right"
										id="cadastroServicoController" type="button">
										Salvar <i class="mdi-content-send right"></i>
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>

			<div class="modal" id="removeModal">
				<div class="modal-content teal white-text">
					<p>Tem certeza que deseja remover esse serviço?</p>
				</div>
				<input type="hidden" id="remove" name="id">
				<div class="modal-footer  teal lighten-4">
					<a href="#"
						class="waves-effect waves-red btn-flat modal-action modal-close">Cancelar</a>
					<a href="#"
						class="waves-effect waves-green btn-flat modal-action modal-close"
						onclick="remover()">Remover</a>
				</div>
			</div>


		</div>
		<!-- END WRAPPER -->
	</div>
	<!-- END MAIN -->
	<!-- FOOTER -->
	<jsp:include page="../tiles/templates/footer.jsp"></jsp:include>
	<!-- SCRIPTS -->
	<jsp:include page="../tiles/templates/js.jsp"></jsp:include>
	<script type="text/javascript"
		src="/resources/js/pages/cadastro-servico.js"></script>
	<script type="text/javascript"
		src="/resources/js/pages/cadastro-servico-editor.js"></script>

</body>
</html>