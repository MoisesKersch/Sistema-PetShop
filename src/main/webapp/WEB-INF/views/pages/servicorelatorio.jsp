<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
						<div class="divider"></div>
						<!--DataTables example-->
						<div id="table-datatables">
							<h4 class="header">Tabela ${mainTitle}</h4>
							<div class="row">
								<div class="col s12 ">
									<table id="${tableId}" class=" hoverable centered striped ">
										<thead>
											<tr>
												<th>ID</th>
												<th>Data Reservada</th>
												<th>Status</th>
												<th>Observação</th>
												<th>Animal</th>
												<th>Serviço</th>
												<th>Usuario</th>
												<th>Data Finalizada</th>
												<th>Valor</th>
											</tr>
										</thead>
											<tfoot>
											<tr>
												<th>Total a pagar</th>
												<th colspan="6"></th>	
												<th class="center"><span class="task-cat green" style="font-size: 15px">Total Pagos</span></th>
												<th  class="center"> <span class="task-cat green" id="valor-total-pago" style="font-size: 15px">333 </span></th>
											</tr>
											<tr>
												<th>Total a pagar</th>
												<th colspan="6"></th>	
												<th class="center"><span class="task-cat blue" style="font-size: 15px">Total Aberto</span></th>
												<th  class="center"> <span class="task-cat blue" id="valor-total-aberto" style="font-size: 15px"></span></th>
											</tr>
											<tr>
												<th>Total a pagar</th>
												<th colspan="6"></th>	
												<th class="center"><span class="task-cat red" style="font-size: 15px">Total em Cancelado</span></th>
												<th  class="center"> <span class="task-cat red" id="valor-total-cancelado" style="font-size: 15px">33 </span></th>
											</tr>
											
										</tfoot>
										<tbody>
										</tbody>
									</table>
								</div>
							</div>
						</div>

<!-- 						<div class="modal" id="animal-remove-modal"> -->
<!-- 							<div class="modal-content teal white-text"> -->
<!-- 								<p>Tem certeza que deseja remover esse cadastro-animal?</p> -->
<!-- 							</div> -->
<!-- 							<input type="hidden" id="animal-remove-id" name="id"> -->
<!-- 							<div class="modal-footer  teal lighten-4"> -->
<!-- 								<a href="#" class="waves-effect waves-red btn-flat modal-action modal-close">Cancelar</a> <a href="#" class="waves-effect waves-green btn-flat modal-action modal-close" -->
<!-- 									onclick="animalRemove()">Remover</a> -->
<!-- 							</div> -->
<!-- 						</div> -->

<!-- 						<input id="editing" class="hide" name="editing" type="text" value="false"> -->

<!-- 						<div id="animal-form-modal" class="modal"> -->
<!-- 							<div class="modal-content"> -->
<!-- 								<h4>Cadastro</h4> -->
<!-- 								<div class="row"> -->
<%-- 									<form class="col s12" id="animal-form"> --%>
<!-- 										<input type="hidden" name="id" id="animal-id"> -->
										
<!-- 										<div class="row modal-form-row"> -->
<!-- 											<div class="input-field col s12"> -->
<!-- 												<input id="nome" type="text" class="required" name="nome"> <label for="especie">Nome</label> -->
<!-- 											</div> -->
<!-- 										</div> -->
										
<!-- 										<div class="row modal-form-row"> -->
<!-- 											<div class="input-field col s12"> -->
<!-- 												<input id="especie" type="text" class="required" name="especie"> <label for="especie">Especie</label> -->
<!-- 											</div> -->
<!-- 										</div> -->

<!-- 										<div class="row"> -->
<!-- 											<div class="input-field col s12"> -->
<!-- 												<input id="peso" type="text" name="peso"> <label for="peso">Peso</label> -->
<!-- 											</div> -->
<!-- 										</div> -->

<!-- 										<div class="row"> -->
<!-- 											<div class="col s12"> -->
<!-- 												<label for="genter_select">Gênero</label> -->
<!-- 												<p> -->
<!-- 													<input name="sexo" type="radio" id="gender_male" value="M" data-error=".errorTxt8"> <label for="gender_male">Masculino</label> -->
<!-- 												</p> -->
<!-- 												<p> -->
<!-- 													<input name="sexo" type="radio" id="gender_female" value="F"> <label for="gender_female">Feminino</label> -->
<!-- 												</p> -->
<!-- 												<div class="input-field"> -->
<!-- 												<div class="errorTxt8"></div> -->
<!-- 											</div> -->
<!-- 											</div> -->
<!-- 										</div> -->

<!-- 										<div class="row"> -->
<!-- 											<div class="input-field col s12"> -->
<!-- 												<input id="tipo" type="text" class="required" name="tipo"> <label for="tipo">Tipo</label> -->
<!-- 											</div> -->
<!-- 										</div> -->

<!-- 										<div class="row"> -->
<!-- 											<div class="input-field col s12"> -->
<!-- 												<input id="dataNascimento" type="text" name="dataNascimento" minlength=10> <label for="dataNascimento">Data Nascimento</label> -->
<!-- 											</div> -->
<!-- 										</div> -->

<!-- 										<div class="row"> -->
<!-- 											<div class="col s12"> -->
<!-- 												<input type="checkbox" class="checkbox" id="pedigree" name="pedigree"> <label for="pedigree">Pedigree</label> -->
<!-- 											</div> -->
<!-- 										</div> -->

<!-- 										<div class="row"> -->
<!-- 											<div class="input-field col s12"> -->
<!-- 												<input id="raca" type="text" name="raca"> <label for="raca">Raça</label> -->
<!-- 											</div> -->
<!-- 										</div> -->

<!-- 										<div class="row"> -->
<!-- 											<div class="input-field col s12"> -->
<!-- 												<input id="cor" type="text" name="cor"> <label for="cor">Cor</label> -->
<!-- 											</div> -->
<!-- 										</div> -->

<!-- 										<div class="row"> -->
<!-- 											<div class="input-field col s12"> -->
<!-- 												<input id="observacao" type="text" name="observacao"> <label for="observacao">Observação</label> -->
<!-- 											</div> -->
<!-- 										</div> -->

<!-- 										<div class="row"> -->
<!-- 											<div class="input-field col s12"> -->
<!-- 												<button class="modal-action modal-close btn  waves-effect waves-light left" type="button"> -->
<!-- 													Fechar <i class="mdi-content-undo left"></i> -->
<!-- 												</button> -->
<!-- 												<button class="btn cyan waves-effect waves-light right" type="submit"> -->
<!-- 													Salvar <i class="mdi-content-send right"></i> -->
<!-- 												</button> -->
<!-- 											</div> -->
<!-- 										</div> -->
<%-- 									</form> --%>
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
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