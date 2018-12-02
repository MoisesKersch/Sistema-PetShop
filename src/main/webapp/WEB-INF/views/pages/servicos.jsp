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
						<div class="divider"></div>
						<div id="card-widgets">
							<div class="row">
								<c:forEach items="${servicos}" var="servico">
									<!-- product-card -->
									<div class="col s12 m12 l4">
										<h4 class="header">${servico.nome}</h4>
										<div class="product-card">
											<div class="card">
												<div class="card-image waves-effect waves-block waves-light paid">
													<span id="${servico.servicoId}"> <c:choose>
															<c:when test="${servico.agendado == true}">
																<a href="#" class="btn-floating btn-large btn-price waves-effect waves-light pink accent-2" style="background-color: #00c853 !important;"> <i class="mdi-action-done-all"
																	style="line-height: 66.5px; font-size: 3.6rem;"></i>
																</a>
															</c:when>
															<c:otherwise>
																<a href="#" class="btn-floating btn-large btn-price waves-effect waves-light pink accent-2"> <c:set var="valor" /> <fmt:setLocale value="pt-BR" /> <fmt:formatNumber
																		value="${servico.valor}" type="currency" currencySymbol="R$ " maxFractionDigits="0"/>
																</a>
															</c:otherwise>
														</c:choose>
													</span> <img src="${servico.url}" style="min-height: 310px !important; max-height: 310px !important;" alt="product-img">
												</div>
												<ul class="card-action-buttons" id="${servico.servicoId}-bottom-buttom">
													<c:choose>
														<c:when test="${servico.agendado == true}">
															<li><a class="btn-floating waves-effect waves-light red accent-4 cancel-order" href="#" title="Cancelar serviço" onclick="servicoRemove('${servico.id}')"><i
																	class="mdi-content-clear"></i></a></li>
														</c:when>
														<c:otherwise>
															<li><a class="btn-floating waves-effect waves-light green accent-4 modal-trigger " href="#servico-form-modal" title="Agendar serviço" onclick="setServicoId('${servico.servicoId}')"><i
																	class="mdi-editor-attach-money"></i></a></li>
														</c:otherwise>
													</c:choose>
													<li><a class="btn-floating waves-effect waves-light light-blue" title="Ler descrição do produto"><i class="mdi-action-visibility activator"></i></a></li>
												</ul>
												<div class="card-content">

													<div class="row">
														<div class="col s8">
															<p class="card-title grey-text text-darken-4">
																<a href="#" class="grey-text text-darken-4">${servico.servicoCategoria.nome}</a>
															</p>
														</div>
														<div class="col s4 no-padding">
															<a href=""></a><img src="resources/images/petshop-company.jpg" alt="amazon" class="responsive-img">
														</div>
													</div>
												</div>
												<div class="card-reveal">
													<span class="card-title grey-text text-darken-4"><i class="mdi-navigation-close right"></i> ${servico.nome}</span>
													<p>${servico.descricao}</p>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
						<div class="modal" id="servico-remove-modal">
							<div class="modal-content teal white-text">
								<p>Tem certeza que deseja remover esse cadastro-servico?</p>
							</div>
							<input type="hidden" id="servico-remove-id" name="id">
							<div class="modal-footer  teal lighten-4">
								<a href="#" class="waves-effect waves-red btn-flat modal-action modal-close">Cancelar</a> <a href="#" class="waves-effect waves-green btn-flat modal-action modal-close"
									onclick="servicoRemove()">Remover</a>
							</div>
						</div>
						<input id="editing" class="hide" name="editing" type="text" value="false">

						<div id="servico-form-modal" class="modal">
							<div class="modal-content">
								<h4>Cadastro</h4>
								<div class="row">
									<form class="col s12" id="servico-form">
										<input type="hidden" name="servicoId" id="servico-id"> <input type="hidden" name="status" value="aberto">

										<div class="row">
											<div class="input-field col s12">
												<input type="text" name="date" id="date" class="datepicker" class="required"> <label for="date">Data</label>
											</div>
										</div>

										<div class="row">
											<div class="input-field col s12">
												<input type="text" name="hora" id="timepicker" class="required"> <label for="hora">Hora</label>
											</div>
										</div>

										<!-- Mais tarde implementar com um multiplo select -->
										<div class="row">
											<div class="input-field col s12">
												<label></label> <select id="servico-animal-select" name="animalId" class="required">
												</select>
											</div>
										</div>

										<div class="row">
											<div class="input-field col s12">
												<input type="text" name="observacao" id="observacao"> <label for="observacao">Observação</label>
											</div>
										</div>

										<div class="row">
											<div class="input-field col s12">
												<button class="modal-action modal-close btn  waves-effect waves-light left" type="button">
													Fechar <i class="mdi-content-undo left"></i>
												</button>
												<button class="btn cyan waves-effect waves-light right" type="submit">
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
	<script type="text/javascript" src="/resources/js/pages/${js}"></script>
</body>
</html>