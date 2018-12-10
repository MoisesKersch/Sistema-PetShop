<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<aside id="left-sidebar-nav">
	<ul id="slide-out" class="side-nav fixed leftside-navigation">
		<li class="user-details cyan darken-2">
			<div class="row">
				<div class="col col s4 m4 l4">
					<img src="resources/images/avatar.jpg" alt="" class="circle responsive-img valign profile-image">
				</div>
				<div class="col col s8 m8 l8">
					<ul id="profile-dropdown" class="dropdown-content">
						<li><a href="/logout"><i class="mdi-hardware-keyboard-tab"></i> Sair</a></li>
					</ul>
					<a class="btn-flat dropdown-button waves-effect waves-light white-text profile-btn" href="#" data-activates="profile-dropdown">${nome}<i class="mdi-navigation-arrow-drop-down right"></i></a>
					<p class="user-roal">${papel}</p>
				</div>
			</div>
		</li>

		<li class="bold"><a href="home" class="waves-effect waves-cyan"><i class="mdi-action-dashboard"></i> Dashboard</a></li>

		<c:if test="${papel == 'Administrator'}">
			<li class="bold"><a href="cadastro" class="waves-effect waves-cyan"><i class="mdi-action-account-circle"></i> Cadastrar Cliente</a></li>
			<li class="bold"><a href="cadastroservico" class="waves-effect waves-cyan"><i class="mdi-action-autorenew"></i> Cadastrar Serviço</a></li>
			<li class="bold"><a href="dica" class="waves-effect waves-cyan"><i class="mdi-content-create"></i> Cadastrar de Dicas</a></li>
			<li class="bold"><a href="servicoagendadoadmin" class="waves-effect waves-cyan"><i class="mdi-action-add-shopping-cart"></i> Serviços Agendados </a></li>
			<li class="bold"><a href="servicorelatorio" class="waves-effect waves-cyan"><i class="mdi-action-book"></i> Relatório de Serviços </a></li>
		</c:if>

		<c:if test="${papel == 'Cliente'}">
			<li class="bold"><a href="cadastroanimal" class="waves-effect waves-cyan"><i class="mdi-action-favorite-outline"></i> Cadastrar Animais</a></li>
			<li class="bold"><a href="servicos" class="waves-effect waves-cyan"><i class="mdi-action-add-shopping-cart"></i> Serviços</a></li>
			<li class="bold"><a href="servicoagendadocliente" class="waves-effect waves-cyan"><i class="mdi-editor-attach-money"></i> Serviços Contratados </a></li>
			<li class="bold"><a href="#" class="waves-effect waves-cyan"><i class="mdi-av-repeat"></i> Solicitar Entrega de Animais </a></li>
			<li class="bold"><a href="#" class="waves-effect waves-cyan"><i class="mdi-action-credit-card"></i> Ver Débitos </a></li>
		</c:if>

		<li class="bold"><a href="#" class="waves-effect waves-cyan"><i class="mdi-action-help"></i> Suporte </a></li>
		<li class="bold"><a href="#" class="waves-effect waves-cyan"><i class="mdi-action-settings"></i> Configurações </a></li>

	</ul>
		<a href="#" data-activates="slide-out" class="sidebar-collapse btn-floating btn-medium waves-effect waves-light hide-on-large-only darken-2"><i class="mdi-navigation-menu"></i></a>
	
</aside>





