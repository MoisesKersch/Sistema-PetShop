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

<link href="resources/css/materialize.css" type="text/css"
	rel="stylesheet" media="screen,projection">
<link href="resources/css/style.css" type="text/css" rel="stylesheet"
	media="screen,projection">
<link href="resources/css/page-center.css" type="text/css"
	rel="stylesheet" media="screen,projection">

<!-- INCLUDED PLUGIN CSS ON THIS PAGE -->
<link href="resources/css/prism.css" type="text/css" rel="stylesheet"
	media="screen,projection">
<link
	href="resources/js/plugins/perfect-scrollbar/perfect-scrollbar.css"
	type="text/css" rel="stylesheet" media="screen,projection">
	
	   <style type="text/css">
  .input-field div.error{
    position: relative;
    top: -1rem;
    left: 0rem;
    font-size: 0.8rem;
    color:#FF4081;
    -webkit-transform: translateY(0%);
    -ms-transform: translateY(0%);
    -o-transform: translateY(0%);
    transform: translateY(0%);
  }
  .input-field label.active{
      width:100%;
  }
  .left-alert input[type=text] + label:after, 
  .left-alert input[type=password] + label:after, 
  .left-alert input[type=email] + label:after, 
  .left-alert input[type=url] + label:after, 
  .left-alert input[type=time] + label:after,
  .left-alert input[type=date] + label:after, 
  .left-alert input[type=datetime-local] + label:after, 
  .left-alert input[type=tel] + label:after, 
  .left-alert input[type=number] + label:after, 
  .left-alert input[type=search] + label:after, 
  .left-alert textarea.materialize-textarea + label:after{
      left:0px;
  }
  .right-alert input[type=text] + label:after, 
  .right-alert input[type=password] + label:after, 
  .right-alert input[type=email] + label:after, 
  .right-alert input[type=url] + label:after, 
  .right-alert input[type=time] + label:after,
  .right-alert input[type=date] + label:after, 
  .right-alert input[type=datetime-local] + label:after, 
  .right-alert input[type=tel] + label:after, 
  .right-alert input[type=number] + label:after, 
  .right-alert input[type=search] + label:after, 
  .right-alert textarea.materialize-textarea + label:after{
      right:70px;
  }
  </style>
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
				<form:form method="post" modelAttribute="usuario" class="form-signin login-form">
					<div class="row">
						<div class="input-field col s12 center">
							<h4>Register</h4>
							<p class="center">Join to our community now !</p>
						</div>
					</div>
					
					<div class="row margin">
						<div class="input-field col s12">
							<i class="mdi-social-person-outline prefix"></i> 
							<spring:bind path="login">
							  <form:input type="text" path="login" placeholder="Username" class="validate ${status.error ? 'invalid' : ''}"
                        		 autofocus="true"></form:input>
                        		 <div class="errorTxt2">
                        		 	<div class="input-field col s2">
                        		 	</div>
                        		 		<div id="cemail-error" class="error"><form:errors path="login"></form:errors></div>
                        		 </div>
                            </spring:bind>
							<label for="username">Usuario</label>
						</div>
					</div>
					
					<div class="row margin">
						<div class="input-field col s12">
							<i class="mdi-action-lock-outline prefix"></i> 
							  <spring:bind path="password">
							  	<form:input type="password" path="password" placeholder="Password"></form:input>
							  </spring:bind>
							<label for="password">Password</label>
						</div>
					</div>
					
					<div class="row margin">
						<div class="input-field col s12">
							<i class="mdi-action-lock-outline prefix"></i> 
							 <spring:bind path="passwordConfirm">
								<form:input type="password" path="passwordConfirm" placeholder="Confirm your password"></form:input>
							  </spring:bind>
							 <label for="password-again">Password again</label>
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
</body>

</html>