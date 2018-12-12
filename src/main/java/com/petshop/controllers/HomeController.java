package com.petshop.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.component.SessaoInfo;
import com.petshop.models.HomeAdm;
import com.petshop.models.HomeCli;
import com.petshop.services.HomeService;

@Controller
public class HomeController extends SessaoInfo
{
	@Autowired
	private HomeService homeService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView modelAndView = new ModelAndView("home");

		if (getUsuarioCorrente() == null)
			return new ModelAndView("/login");

		String role = getUsuarioCorrente().getRoles().iterator().next().getRole();

		try {
			modelAndView.addObject("dicas", homeService.getDicas(getUsuarioCorrente().getEmpresa()));
			if (role.equals("Cliente")) {
				HomeCli homeCli = homeService.getHomeCli(getUsuarioCorrente().getEmpresa(), getUsuarioCorrente());
				modelAndView.addObject("servicoAgendado", homeCli.getServicoAgendado());
				modelAndView.addObject("servicoConcluido", homeCli.getServicoConcluido());
			} else {
				HomeAdm homeAdm = homeService.getHomeAdm(getUsuarioCorrente().getEmpresa());
				modelAndView.addObject("nroClientes", homeAdm.getNroClientes());
				modelAndView.addObject("totalVendas", homeAdm.getTotalVendas());
				modelAndView.addObject("lucro", homeAdm.getLucro());
				modelAndView.addObject("servicoAberto", homeAdm.getServicosAberto());
			}
			modelAndView.addObject("papel", getUsuarioCorrente().getRoles().iterator().next().getRole());
			modelAndView.addObject("nome", getUsuarioCorrente().getNome());
		} catch (Exception e) {

		}

		modelAndView.addObject("page", "Home");
		return modelAndView;
	}
}
