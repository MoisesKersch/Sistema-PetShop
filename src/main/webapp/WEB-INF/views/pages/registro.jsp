<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="../tiles/templates/css.jsp"></jsp:include>
	<title>Página de Registro | 
	Template</title>

	<!-- Favicons-->
	<link rel="icon" href="resources/images/favicon/favicon-32x32.png" sizes="32x32">
	<!-- Favicons-->
	<link rel="apple-touch-icon-precomposed"
		href="resources/images/favicon/apple-touch-icon-152x152.png">
	<!-- For iPhone -->
	<meta name="msapplication-TileColor" content="#00bcd4">
	<meta name="msapplication-TileImage"
		content="resources/images/favicon/mstile-144x144.png">
	<!-- For Windows Phone -->


	<link href="resources/css/page-center.css" type="text/css" rel="stylesheet" media="screen,projection">
	
	<!-- INCLUDED PLUGIN CSS ON THIS PAGE -->
	<link href="resources/css/prism.css" type="text/css" rel="stylesheet" media="screen,projection">
	<link href="resources/js/plugins/perfect-scrollbar/perfect-scrollbar.css" type="text/css" rel="stylesheet" media="screen,projection">
</head>

<body class="cyan">
	<!-- Start Page Loading -->
	<div id="loader-wrapper">
		<div id="loader"></div>
		<div class="loader-section section-left"></div>
		<div class="loader-section section-right"></div>
	</div>
	<!-- End Page Loading -->
		<div id="login-page" class="row">
			<div class="col s12 z-depth-4 card-panel">
			
				<form:form method="post" modelAttribute="usuario" action="registro" class="form-signin login-form" id="registrationForm">
					<div class="row">
						<div class="input-field col s12 center">
							<h4>Registro</h4>
							<p class="center">Registre-se no sistema PetShop!  

							</p>
						</div>
					</div>
					
					<div class="row margin">
						<div class="input-field col s12">
							<i class="mdi-social-person-outline prefix"></i> 
							<spring:bind path="nome">
							  <form:input type="text" path="nome" placeholder="Nome" 
                         		 autofocus="true" class="required"></form:input> 
                        		 	<div class="input-field col s2"></div>
                             </spring:bind> 
							<label for="nome">Nome</label>
						</div>
					</div>
					
					  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					
					<div class="row margin">
						<div class="input-field col s12">
							<i class="mdi-social-person-outline prefix"></i> 
							<spring:bind path="cpf">
							  <form:input type="number" path="cpf" placeholder="cpf" class="required" id="cpf"
                        		 autofocus="true"></form:input> 
                        		 	<div class="input-field col s2"></div>
                             </spring:bind> 
							<label for="cpf">CPF</label>
						</div>
					</div>
					
					<div class="row margin">
						<div class="input-field col s12">
							<i class="mdi-social-person-outline prefix"></i> 
							<spring:bind path="enderecos[0].bairro">
							  <form:input type="text" path="enderecos[0].bairro" placeholder="Bairro" class="required"
                         		 autofocus="true"></form:input> 
                        		 	<div class="input-field col s2"></div>
                            </spring:bind>
							<label for="bairro">Bairro</label>
						</div>
					</div>
					
					<div class="row margin">
						<div class="input-field col s12">
							<i class="mdi-social-person-outline prefix"></i> 
							<spring:bind path="enderecos[0].cidade"> 
							  <form:input type="text" path="enderecos[0].cidade" placeholder="Cidade" class="required"
                         		 autofocus="true"></form:input> 
                        		 	<div class="input-field col s2"></div>
                             </spring:bind> 
							<label for="cidade">Cidade</label>
						</div>
					</div>
					
					<div class="row margin">
						<div class="input-field col s12">
							<i class="mdi-social-person-outline prefix"></i> 
							<spring:bind path="enderecos[0].uf">
							  <form:input type="text" path="enderecos[0].uf" placeholder="UF" class="required"
                        		 autofocus="true"></form:input> 
                        		 	<div class="input-field col s2"></div>
                             </spring:bind> 
							<label for="uf">UF</label>
						</div>
					</div>
					
					<div class="row margin">
						<div class="input-field col s12">
							<i class="mdi-social-person-outline prefix"></i> 
							<spring:bind path="enderecos[0].complemento">
							  <form:input type="text" path="enderecos[0].complemento" placeholder="Complemento" 
                        		 autofocus="true"></form:input> 
                        		 	<div class="input-field col s2"></div>
                             </spring:bind> 
							<label for="complemento">Complemento</label>
						</div>
					</div>
					
					<div class="row margin">
						<div class="input-field col s12">
							<i class="mdi-social-person-outline prefix"></i> 
							<spring:bind path="email">
							  <form:input type="text" path="email" placeholder="Email" class="required"
                        		 autofocus="true"></form:input> 
                        		 	<div class="input-field col s2"></div>
                             </spring:bind> 
							<label for="email">Email</label>
						</div>
					</div>
					
					<div class="row margin">
						<div class="input-field col s12">
							<i class="mdi-social-person-outline prefix"></i> 
							<spring:bind path="login">
							  <form:input type="text" path="login" placeholder="login" class="required" id="login"
                         		 autofocus="true"></form:input> 
                        		 	<div class="input-field col s2"></div>
                             </spring:bind> 
							<label for="login">Login</label>
						</div>
					</div>
					
					<div class="row margin">
						<div class="input-field col s12">
							<i class="mdi-action-lock-outline prefix"></i> 
							  <spring:bind path="senha">
							  	<form:input type="password" path="senha" placeholder="Senha" name="senha" id="senha" ></form:input>
							  	<div class="input-field col s2"></div>
							  </spring:bind>
							<label for="senha">Senha</label>
						</div>
					</div>
					
					<div class="row margin">
						<div class="input-field col s12">
							<i class="mdi-action-lock-outline prefix"></i> 
								<input type="password" placeholder="Senha Novamente" name="passwordConfirm" >
									<div class="input-field col s2"></div>
							 <label for="senha-again">Senha Novamente</label>
						</div>
					</div>
					<div class="row">
					
						<div class="input-field col s12">
							<button type="button" onclick="send()" class="btn waves-effect waves-light col s12">Registrar
								Agora</button>
						</div>
						
						<div class="input-field col s12">
							<p class="margin center medium-small sign-up">
								Já possui uma conta? <a href="login">Login </a>
							</p>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	<!-- ================================================
    Scripts
    ================================================ -->
	<jsp:include page="../tiles/templates/js.jsp"></jsp:include>
	<script type="text/javascript" src="resources/js/pages/registro.js"></script>
		<c:if test="${mensagemErro ne null}">
			<script>
			   		Materialize.toast('${mensagemErro}', 8000, 'red') 
			</script>
		</c:if>
</body>

</html>