<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="msapplication-tap-highlight" content="no">
<meta name="description"
	content="Materialize is a Material Design Admin Template,It's modern, responsive and based on Material Design by Google. ">
<meta name="keywords"
	content="materialize, admin template, dashboard template, flat admin template, responsive admin template,">
<title>Register Page | Materialize - Material Design Admin
	Template</title>

<!-- Favicons-->
<link rel="icon" href="images/favicon/favicon-32x32.png" sizes="32x32">
<!-- Favicons-->
<link rel="apple-touch-icon-precomposed"
	href="images/favicon/apple-touch-icon-152x152.png">
<!-- For iPhone -->
<meta name="msapplication-TileColor" content="#00bcd4">
<meta name="msapplication-TileImage"
	content="images/favicon/mstile-144x144.png">
<!-- For Windows Phone -->

<!-- CORE CSS-->

<link href="resources/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection">
<link href="resources/css/style.css" type="text/css" rel="stylesheet" media="screen,projection">
<link href="resources/css/page-center.css" type="text/css" rel="stylesheet" media="screen,projection">

<!-- INCLUDED PLUGIN CSS ON THIS PAGE -->
<link href="resources/css/prism.css" type="text/css" rel="stylesheet" media="screen,projection">
<link href="resources/js/plugins/perfect-scrollbar/perfect-scrollbar.css" type="text/css" rel="stylesheet" media="screen,projection">
<link href="resources/css/validator.css" type="text/css" rel="stylesheet" media="screen,projection">
	
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
				<form:form method="post" modelAttribute="users" class="form-signin login-form" id="registrationForm">
					<div class="row">
						<div class="input-field col s12 center">
							<h4>Registro</h4>
							<p class="center">Registre-se no sistema PetShop!</p>
						</div>
					</div>
					
					<div class="row margin">
						<div class="input-field col s12">
							<i class="mdi-social-person-outline prefix"></i> 
							<spring:bind path="nome">
							  <form:input type="text" path="nome" placeholder="Nome" 
                        		 autofocus="true"></form:input>
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
							  <form:input type="text" path="cpf" placeholder="cpf" 
                        		 autofocus="true"></form:input>
                        		 	<div class="input-field col s2"></div>
                            </spring:bind>
							<label for="cpf">cpf</label>
						</div>
					</div>
					
					<div class="row margin">
						<div class="input-field col s12">
							<i class="mdi-social-person-outline prefix"></i> 
							<spring:bind path="endereco[0].bairro">
							  <form:input type="text" path="endereco[0].bairro" placeholder="Bairro" 
                        		 autofocus="true"></form:input>
                        		 	<div class="input-field col s2"></div>
                            </spring:bind>
							<label for="bairro">Bairro</label>
						</div>
					</div>
					
					<div class="row margin">
						<div class="input-field col s12">
							<i class="mdi-social-person-outline prefix"></i> 
							<spring:bind path="endereco[0].cidade">
							  <form:input type="text" path="endereco[0].cidade" placeholder="Cidade" 
                        		 autofocus="true"></form:input>
                        		 	<div class="input-field col s2"></div>
                            </spring:bind>
							<label for="cidade">Cidade</label>
						</div>
					</div>
					
					<div class="row margin">
						<div class="input-field col s12">
							<i class="mdi-social-person-outline prefix"></i> 
							<spring:bind path="endereco[0].uf">
							  <form:input type="text" path="endereco[0].uf" placeholder="UF" 
                        		 autofocus="true"></form:input>
                        		 	<div class="input-field col s2"></div>
                            </spring:bind>
							<label for="uf">UF</label>
						</div>
					</div>
					
					<div class="row margin">
						<div class="input-field col s12">
							<i class="mdi-social-person-outline prefix"></i> 
							<spring:bind path="login">
							  <form:input type="text" path="login" placeholder="login" 
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
							  	<form:input type="password" path="senha" placeholder="Senha" name="password" id="password" ></form:input>
							  	<div class="input-field col s2"></div>
							  </spring:bind>
							<label for="senha">Senha</label>
						</div>
					</div>
					
					<div class="row margin">
						<div class="input-field col s12">
							<i class="mdi-action-lock-outline prefix"></i> 
								<input type="password" placeholder="Senha Novamente"  name="passwordConfirm" >
									<div class="input-field col s2"></div>
							 <label for="senha-again">Senha Novamente</label>
						</div>
					</div>
					<div class="row">
					
						<div class="input-field col s12">
							<button type="submit" value="Submit" class="btn waves-effect waves-light col s12">Register
								Now</button>
						</div>
						
						<div class="input-field col s12">
							<p class="margin center medium-small sign-up">
								Already have an account? <a href="page-login.html">Login</a>
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
	<script type="text/javascript" src="resources/js/pages/registration.js"></script>
</body>

</html>