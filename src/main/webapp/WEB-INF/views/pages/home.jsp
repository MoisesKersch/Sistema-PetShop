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
<script type="text/javascript" src="resources/js/plugins/chartjs/chart-script.js"></script>

</head>
<body>
	<!-- body >> main >> wrapper >> content -->
	<!-- START MAIN -->
	<div id="main">
		<!-- START WRAPPER -->
		<div class="wrapper">
			<!-- START LEFT SIDEBAR NAV  MENU-->
			<jsp:include page="../tiles/templates/menu.jsp"></jsp:include>
			<!-- END LEFT SIDEBAR NAV MENU-->
			<!-- //////////////////////////////////////////////////////////////////////////// -->
			<!-- START CONTENT -->
			<section id="content">
				<!--start container-->
				<div class="container">
					<!--card stats start-->
					<div id="card-stats">
						<div class="row">
							<div class="col s12 m6 l3">
								<div class="card">
									<div class="card-content  green white-text">
										<p class="card-stats-title">
											<i class="mdi-social-group-add"></i> Número de Clientes
										</p>
										<h4 class="card-stats-number">${nroClientes}</h4>
										<p class="card-stats-compare">
											<i class="mdi-hardware-keyboard-arrow-up"></i> 15% <span class="green-text text-lighten-5">Ontem</span>
										</p>
									</div>
									<div class="card-action  green darken-2">
										<div id="clients-bar"></div>
									</div>
								</div>
							</div>
							<div class="col s12 m6 l3">
								<div class="card">
									<div class="card-content purple white-text">
										<p class="card-stats-title">
											<i class="mdi-editor-attach-money"></i>Total Vendas
										</p>
										<h4 class="card-stats-number">${totalVendas}</h4>
										<p class="card-stats-compare">
											<i class="mdi-hardware-keyboard-arrow-up"></i> 70% <span class="purple-text text-lighten-5">último mês</span>
										</p>
									</div>
									<div class="card-action purple darken-2">
										<div id="sales-compositebar"></div>

									</div>
								</div>
							</div>
							<div class="col s12 m6 l3">
								<div class="card">
									<div class="card-content blue-grey white-text">
										<p class="card-stats-title">
											<i class="mdi-action-trending-up"></i> Receita Diária
										</p>
										<h4 class="card-stats-number">${lucro}</h4>
										<p class="card-stats-compare">
											<i class="mdi-hardware-keyboard-arrow-up"></i> 80% <span class="blue-grey-text text-lighten-5">from yesterday</span>
										</p>
									</div>
									<div class="card-action blue-grey darken-2">
										<div id="profit-tristate"></div>
									</div>
								</div>
							</div>
							<div class="col s12 m6 l3">
								<div class="card">
									<div class="card-content deep-purple white-text">
										<p class="card-stats-title">
											<i class="mdi-editor-insert-drive-file"></i> New Invoice
										</p>
										<h4 class="card-stats-number">1806</h4>
										<p class="card-stats-compare">
											<i class="mdi-hardware-keyboard-arrow-down"></i> 3% <span class="deep-purple-text text-lighten-5">from last month</span>
										</p>
									</div>
									<div class="card-action  deep-purple darken-2">
										<div id="invoice-line"></div>
									</div>
								</div>
							</div>

							<div class="col s12 m6 l12">
								<div class="slider">
									<ul class="slides">
										<c:forEach items="${dicas}" var="dica">
											<li><img src="${dica.url}" alt="img-1"> <!-- random image -->
												<div class="caption center-align ">
													<h3>${dica.titulo}</h3>
													<h5 class="light light-green-text text-accent-2 grey darken-4">${dica.descricao}</h5>
												</div></li>
										</c:forEach>
									</ul>
								</div>
							</div>

						</div>
					</div>
					<!--card stats end-->

					<!-- //////////////////////////////////////////////////////////////////////////// -->

					<!--card widgets start-->
					<div id="card-widgets">
						<div class="row">

							<div class="col s12 m12 l4">
								<ul id="task-card" class="collection with-header">
									<li class="collection-header cyan">
										<h4 class="task-card-title">My Task</h4>
										<p class="task-card-date">March 26, 2015</p>
									</li>
									<li class="collection-item dismissable"><input type="checkbox" id="task1" /> <label for="task1">Create Mobile App UI. <a href="#" class="secondary-content"><span
												class="ultra-small">Today</span></a>
									</label> <span class="task-cat teal">Mobile App</span></li>
									<li class="collection-item dismissable"><input type="checkbox" id="task2" /> <label for="task2">Check the new API standerds. <a href="#" class="secondary-content"><span
												class="ultra-small">Monday</span></a>
									</label> <span class="task-cat purple">Web API</span></li>
									<li class="collection-item dismissable"><input type="checkbox" id="task3" checked="checked" /> <label for="task3">Check the new Mockup of ABC. <a href="#"
											class="secondary-content"><span class="ultra-small">Wednesday</span></a>
									</label> <span class="task-cat pink">Mockup</span></li>
									<li class="collection-item dismissable"><input type="checkbox" id="task4" checked="checked" disabled="disabled" /> <label for="task4">I did it !</label> <span class="task-cat cyan">Mobile
											App</span></li>
								</ul>
							</div>

							<div class="col s12 m6 l4">
								<div id="flight-card" class="card">
									<div class="card-header amber darken-2">
										<div class="card-title">
											<h4 class="flight-card-title">Flight</h4>
											<p class="flight-card-date">June 18, Thu 04:50</p>
										</div>
									</div>
									<div class="card-content-bg white-text">
										<div class="card-content">
											<div class="row flight-state-wrapper">
												<div class="col s5 m5 l5 center-align">
													<div class="flight-state">
														<h4 class="margin">LDN</h4>
														<p class="ultra-small">London</p>
													</div>
												</div>
												<div class="col s2 m2 l2 center-align">
													<i class="mdi-device-airplanemode-on flight-icon"></i>
												</div>
												<div class="col s5 m5 l5 center-align">
													<div class="flight-state">
														<h4 class="margin">SFO</h4>
														<p class="ultra-small">San Francisco</p>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col s6 m6 l6 center-align">
													<div class="flight-info">
														<p class="small">
															<span class="grey-text text-lighten-4">Depart:</span> 04.50
														</p>
														<p class="small">
															<span class="grey-text text-lighten-4">Flight:</span> IB 5786
														</p>
														<p class="small">
															<span class="grey-text text-lighten-4">Terminal:</span> B
														</p>
													</div>
												</div>
												<div class="col s6 m6 l6 center-align flight-state-two">
													<div class="flight-info">
														<p class="small">
															<span class="grey-text text-lighten-4">Arrive:</span> 08.50
														</p>
														<p class="small">
															<span class="grey-text text-lighten-4">Flight:</span> IB 5786
														</p>
														<p class="small">
															<span class="grey-text text-lighten-4">Terminal:</span> C
														</p>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="col s12 m6 l4">
								<div id="profile-card" class="card">
									<div class="card-image waves-effect waves-block waves-light">
										<img class="activator" src="resources/images/user-bg.jpg" alt="user background">
									</div>
									<div class="card-content">
										<img src="resources/images/avatar.jpg" alt="" class="circle responsive-img activator card-profile-image"> <a
											class="btn-floating activator btn-move-up waves-effect waves-light darken-2 right"> <i class="mdi-editor-mode-edit"></i>
										</a> <span class="card-title activator grey-text text-darken-4">Roger Waters</span>
										<p>
											<i class="mdi-action-perm-identity cyan-text text-darken-2"></i> Project Manager
										</p>
										<p>
											<i class="mdi-action-perm-phone-msg cyan-text text-darken-2"></i> +1 (612) 222 8989
										</p>
										<p>
											<i class="mdi-communication-email cyan-text text-darken-2"></i> mail@domain.com
										</p>

									</div>
									<div class="card-reveal">
										<span class="card-title grey-text text-darken-4">Roger Waters <i class="mdi-navigation-close right"></i>
										</span>
										<p>Here is some more information about this card.</p>
										<p>
											<i class="mdi-action-perm-identity cyan-text text-darken-2"></i> Project Manager
										</p>
										<p>
											<i class="mdi-action-perm-phone-msg cyan-text text-darken-2"></i> +1 (612) 222 8989
										</p>
										<p>
											<i class="mdi-communication-email cyan-text text-darken-2"></i> mail@domain.com
										</p>
										<p>
											<i class="mdi-social-cake cyan-text text-darken-2"></i> 18th June 1990
										</p>
										<p>
											<i class="mdi-device-airplanemode-on cyan-text text-darken-2"></i> BAR - AUS
										</p>
									</div>
								</div>
							</div>

						</div>
					</div>
					<!--card widgets end-->

					<!-- //////////////////////////////////////////////////////////////////////////// -->

					<!--work collections start-->
					<div id="work-collections">
						<div class="row">
							<div class="col s12 m12 l6">
								<ul id="projects-collection" class="collection">
									<li class="collection-item avatar"><i class="mdi-file-folder circle light-blue darken-2"></i> <span class="collection-header">Projects</span>
										<p>Your Favorites</p> <a href="#" class="secondary-content"><i class="mdi-action-grade"></i></a></li>
									<li class="collection-item">
										<div class="row">
											<div class="col s6">
												<p class="collections-title">Web App</p>
												<p class="collections-content">AEC Company</p>
											</div>
											<div class="col s3">
												<span class="task-cat cyan">Development</span>
											</div>
											<div class="col s3">
												<div id="project-line-1"></div>
											</div>
										</div>
									</li>
									<li class="collection-item">
										<div class="row">
											<div class="col s6">
												<p class="collections-title">Mobile App for Social</p>
												<p class="collections-content">iSocial App</p>
											</div>
											<div class="col s3">
												<span class="task-cat grey darken-3">UI/UX</span>
											</div>
											<div class="col s3">
												<div id="project-line-2"></div>
											</div>
										</div>
									</li>
									<li class="collection-item">
										<div class="row">
											<div class="col s6">
												<p class="collections-title">Website</p>
												<p class="collections-content">MediTab</p>
											</div>
											<div class="col s3">
												<span class="task-cat teal">Marketing</span>
											</div>
											<div class="col s3">
												<div id="project-line-3"></div>
											</div>
										</div>
									</li>
									<li class="collection-item">
										<div class="row">
											<div class="col s6">
												<p class="collections-title">AdWord campaign</p>
												<p class="collections-content">True Line</p>
											</div>
											<div class="col s3">
												<span class="task-cat green">SEO</span>
											</div>
											<div class="col s3">
												<div id="project-line-4"></div>
											</div>
										</div>
									</li>
								</ul>
							</div>
							<div class="col s12 m12 l6">
								<ul id="issues-collection" class="collection">
									<li class="collection-item avatar"><i class="mdi-action-bug-report circle red darken-2"></i> <span class="collection-header">Issues</span>
										<p>Assigned to you</p> <a href="#" class="secondary-content"><i class="mdi-action-grade"></i></a></li>
									<li class="collection-item">
										<div class="row">
											<div class="col s7">
												<p class="collections-title">
													<strong>#102</strong> Home Page
												</p>
												<p class="collections-content">Web Project</p>
											</div>
											<div class="col s2">
												<span class="task-cat pink accent-2">P1</span>
											</div>
											<div class="col s3">
												<div class="progress">
													<div class="determinate" style="width: 70%"></div>
												</div>
											</div>
										</div>
									</li>
									<li class="collection-item">
										<div class="row">
											<div class="col s7">
												<p class="collections-title">
													<strong>#108</strong> API Fix
												</p>
												<p class="collections-content">API Project</p>
											</div>
											<div class="col s2">
												<span class="task-cat yellow darken-4">P2</span>
											</div>
											<div class="col s3">
												<div class="progress">
													<div class="determinate" style="width: 40%"></div>
												</div>
											</div>
										</div>
									</li>
									<li class="collection-item">
										<div class="row">
											<div class="col s7">
												<p class="collections-title">
													<strong>#205</strong> Profile page css
												</p>
												<p class="collections-content">New Project</p>
											</div>
											<div class="col s2">
												<span class="task-cat light-green darken-3">P3</span>
											</div>
											<div class="col s3">
												<div class="progress">
													<div class="determinate" style="width: 95%"></div>
												</div>
											</div>
										</div>
									</li>
									<li class="collection-item">
										<div class="row">
											<div class="col s7">
												<p class="collections-title">
													<strong>#188</strong> SAP Changes
												</p>
												<p class="collections-content">SAP Project</p>
											</div>
											<div class="col s2">
												<span class="task-cat pink accent-2">P1</span>
											</div>
											<div class="col s3">
												<div class="progress">
													<div class="determinate" style="width: 10%"></div>
												</div>
											</div>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<!--work collections end-->

				</div>
				<!--end container-->
			</section>
			<!-- END CONTENT -->

			<!-- //////////////////////////////////////////////////////////////////////////// -->
			<!-- START RIGHT SIDEBAR NAV-->
			<aside id="right-sidebar-nav">
				<ul id="chat-out" class="side-nav rightside-navigation">
					<li class="li-hover"><a href="#" data-activates="chat-out" class="chat-close-collapse right"><i class="mdi-navigation-close"></i></a>
						<div id="right-search" class="row">
							<form class="col s12">
								<div class="input-field">
									<i class="mdi-action-search prefix"></i> <input id="icon_prefix" type="text" class="validate"> <label for="icon_prefix">Search</label>
								</div>
							</form>
						</div></li>
					<li class="li-hover">
						<ul class="chat-collapsible" data-collapsible="expandable">
							<li>
								<div class="collapsible-header teal white-text active">
									<i class="mdi-social-whatshot"></i>Recent Activity
								</div>
								<div class="collapsible-body recent-activity">
									<div class="recent-activity-list chat-out-list row">
										<div class="col s3 recent-activity-list-icon">
											<i class="mdi-action-add-shopping-cart"></i>
										</div>
										<div class="col s9 recent-activity-list-text">
											<a href="#">just now</a>
											<p>Jim Doe Purchased new equipments for zonal office.</p>
										</div>
									</div>
									<div class="recent-activity-list chat-out-list row">
										<div class="col s3 recent-activity-list-icon">
											<i class="mdi-device-airplanemode-on"></i>
										</div>
										<div class="col s9 recent-activity-list-text">
											<a href="#">Yesterday</a>
											<p>Your Next flight for USA will be on 15th August 2015.</p>
										</div>
									</div>
									<div class="recent-activity-list chat-out-list row">
										<div class="col s3 recent-activity-list-icon">
											<i class="mdi-action-settings-voice"></i>
										</div>
										<div class="col s9 recent-activity-list-text">
											<a href="#">5 Days Ago</a>
											<p>Natalya Parker Send you a voice mail for next conference.</p>
										</div>
									</div>
									<div class="recent-activity-list chat-out-list row">
										<div class="col s3 recent-activity-list-icon">
											<i class="mdi-action-store"></i>
										</div>
										<div class="col s9 recent-activity-list-text">
											<a href="#">Last Week</a>
											<p>Jessy Jay open a new store at S.G Road.</p>
										</div>
									</div>
									<div class="recent-activity-list chat-out-list row">
										<div class="col s3 recent-activity-list-icon">
											<i class="mdi-action-settings-voice"></i>
										</div>
										<div class="col s9 recent-activity-list-text">
											<a href="#">5 Days Ago</a>
											<p>Natalya Parker Send you a voice mail for next conference.</p>
										</div>
									</div>
								</div>
							</li>
							<li>
								<div class="collapsible-header light-blue white-text active">
									<i class="mdi-editor-attach-money"></i>Sales Repoart
								</div>
								<div class="collapsible-body sales-repoart">
									<div class="sales-repoart-list  chat-out-list row">
										<div class="col s8">Target Salse</div>
										<div class="col s4">
											<span id="sales-line-1"></span>
										</div>
									</div>
									<div class="sales-repoart-list chat-out-list row">
										<div class="col s8">Payment Due</div>
										<div class="col s4">
											<span id="sales-bar-1"></span>
										</div>
									</div>
									<div class="sales-repoart-list chat-out-list row">
										<div class="col s8">Total Delivery</div>
										<div class="col s4">
											<span id="sales-line-2"></span>
										</div>
									</div>
									<div class="sales-repoart-list chat-out-list row">
										<div class="col s8">Total Progress</div>
										<div class="col s4">
											<span id="sales-bar-2"></span>
										</div>
									</div>
								</div>
							</li>
							<li>
								<div class="collapsible-header red white-text">
									<i class="mdi-action-stars"></i>Favorite Associates
								</div>
								<div class="collapsible-body favorite-associates">
									<div class="favorite-associate-list chat-out-list row">
										<div class="col s4">
											<img src="resources/images/avatar.jpg" alt="" class="circle responsive-img online-user valign profile-image">
										</div>
										<div class="col s8">
											<p>Eileen Sideways</p>
											<p class="place">Los Angeles, CA</p>
										</div>
									</div>
									<div class="favorite-associate-list chat-out-list row">
										<div class="col s4">
											<img src="resources/images/avatar.jpg" alt="" class="circle responsive-img online-user valign profile-image">
										</div>
										<div class="col s8">
											<p>Zaham Sindil</p>
											<p class="place">San Francisco, CA</p>
										</div>
									</div>
									<div class="favorite-associate-list chat-out-list row">
										<div class="col s4">
											<img src="resources/images/avatar.jpg" alt="" class="circle responsive-img offline-user valign profile-image">
										</div>
										<div class="col s8">
											<p>Renov Leongal</p>
											<p class="place">Cebu City, Philippines</p>
										</div>
									</div>
									<div class="favorite-associate-list chat-out-list row">
										<div class="col s4">
											<img src="resources/images/avatar.jpg" alt="" class="circle responsive-img online-user valign profile-image">
										</div>
										<div class="col s8">
											<p>Weno Carasbong</p>
											<p>Tokyo, Japan</p>
										</div>
									</div>
									<div class="favorite-associate-list chat-out-list row">
										<div class="col s4">
											<img src="resources/images/avatar.jpg" alt="" class="circle responsive-img offline-user valign profile-image">
										</div>
										<div class="col s8">
											<p>Nusja Nawancali</p>
											<p class="place">Bangkok, Thailand</p>
										</div>
									</div>
								</div>
							</li>
						</ul>
					</li>
				</ul>
			</aside>
			<!-- LEFT RIGHT SIDEBAR NAV-->
		</div>
		<!-- END WRAPPER -->
	</div>
	<!-- END MAIN -->
	<!-- FOOTER -->
	<jsp:include page="../tiles/templates/footer.jsp"></jsp:include>
	<!-- SCRIPTS -->
	<jsp:include page="../tiles/templates/js.jsp"></jsp:include>
	<script type="text/javascript" src="/resources/js/pages/home.js"></script>
</body>
</html>