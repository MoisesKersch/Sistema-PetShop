<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
								<h5 class="breadcrumbs-title">Cadastro</h5>
								<ol class="breadcrumb">
									<li><a href="index.html">Dashboard</a></li>
									<li class="active">Cadastro</li>
								</ol>
							</div>
						</div>
					</div>
				</div>
				<!--breadcrumbs end-->
				<!--start container-->
				<div class="container">
					<div class="section">
						<p class="caption">Cadastre, remova e altere clientes
							cadastrados no seu sistema.</p>
						<div class="divider"></div>
						<!--DataTables example-->
						<div id="table-datatables">
							<h4 class="header">Tabela de Clientes</h4>
							<div class="row">
								<div class="col s12 ">
									<table id="cadastro" class="responsive display" cellspacing="0">
										<thead>
											<tr>
												<th>Nome</th>
												<th>CPF</th>
												<th>Email</th>
												<th>Bairro</th>
												<th>Cidade</th>
												<th>Estado</th>
												<th>Complemento</th>
												<th>ID</th>
											</tr>
										</thead>
										<tbody>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					
						<div class="modal" id="modalRemove">
							<div class="modal-content teal white-text">
								<p>Tem certeza que deseja remover esse cadastro?</p>
							</div>
							<input type="hidden" id="remove" name="id">
							<div class="modal-footer  teal lighten-4">
								<a href="#"
									class="waves-effect waves-red btn-flat modal-action modal-close">Cancelar</a>
								<a href="#"
									class="waves-effect waves-green btn-flat modal-action modal-close" onclick="removerCadastro()">Remover</a>
							</div>
						</div>

						<input id="editing" class="hide" name="editing" type="text" value="false"> 
						 
						<div id="cadastroFormModal" class="modal">
							<div class="modal-content">
								<h4>Cadastro</h4>
								<div class="row">
									<form class="col s12" id="cadastroForm">

										<div class="row modal-form-row">
											<div class="input-field col s12">
												<input id="nome" type="text" class="required" name="nome">
												<label for="nome">Nome</label>
											</div>
										</div>

										<div class="row">
											<div class="input-field col s12">
												<input id="cpf" type="number" class="required" name="cpf">
												<label for="cpf">CPF</label>
											</div>
										</div>

										<div class="row">
											<div class="input-field col s12">
												<input id="email" type="text" class="required" name="email">
												<label for="email">Email</label>
											</div>
										</div>

										<div class="row">
											<div class="input-field col s12">
												<input id="bairro" type="text" class="required"
													name="bairro"> <label for="bairro">Bairro</label>
											</div>
										</div>

										<div class="row">
											<div class="input-field col s12">
												<input id="cidade" type="text" class="required"
													name="cidade"> <label for="cidade">Cidade</label>
											</div>
										</div>

										<div class="row">
											<div class="input-field col s12">
												<input id="uf" type="text" class="required" name="uf">
												<label for="uf">UF</label>
											</div>
										</div>

										<div class="row">
											<div class="input-field col s12">
												<input id="complemento" type="text" name="complemento">
												<label for="complemento">Complemento</label>
											</div>
										</div>

										<div class="row">
											<div class="input-field col s12">
												<input id="login" name="login" type="text"> <label
													for="login">Login</label>
											</div>
										</div>

										<div class="row">
											<div class="input-field col s12">
												<input id="senha" type="text" name="senha"> <label
													for="senha">Senha</label>
											</div>
										</div>

										<div class="row">
											<div class="input-field col s12">
												<input id="passwordConfirm" name="passwordConfirm"
													type="text"> <label for="passwordConfirm">Senha
													novamente</label>
											</div>
										</div>

										<input id="id" class="hide" name="id" type="text">

										<div class="row">
											<div class="input-field col s12">
												<button
													class="modal-action modal-close btn cyan waves-effect waves-light left"
													type="button">
													Fechar <i class="mdi-content-send right"></i>
												</button>
												<button class="btn cyan waves-effect waves-light right"
													id="cadastroController" type="button">
													Salvar <i class="mdi-content-send right"></i>
												</button>
											</div>
										</div>
									</form>
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
	<script type="text/javascript" src="/resources/js/pages/cadastro.js"></script>
	<script type="text/javascript"
		src="/resources/js/pages/cadastro-editor.js"></script>

</body>
</html>