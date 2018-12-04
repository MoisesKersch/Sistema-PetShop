package com.petshop.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.petshop.component.SessaoInfo;
import com.petshop.models.Animal;
import com.petshop.models.OrdemServico;
import com.petshop.models.Servico;
import com.petshop.models.Usuario;
import com.petshop.pojo.ServicoAgendado;
import com.petshop.repositories.AnimalRepository;
import com.petshop.repositories.OrdemServicoRepository;
import com.petshop.services.OrdemServicoService;

@Controller
public class ServicoController extends SessaoInfo
{
	@Autowired
	private AnimalRepository animalRepository;

	@Autowired
	private OrdemServicoService ordemServicoService;

	@Autowired
	OrdemServicoRepository ordemServicoRepository;

	@RequestMapping(value = "/servicos")
	public ModelAndView getServicoPage()
	{
		ModelAndView modelAndView = new ModelAndView("servicos");
		

		if (getUsuarioCorrente() == null)
			return new ModelAndView("/login");

		try {
			modelAndView.addObject("papel", getUsuarioCorrente().getRoles().iterator().next().getRole());
			modelAndView.addObject("nome", getUsuarioCorrente().getNome());
		} catch (Exception e) {

		}

		modelAndView.addObject("page", "Serviços");
		modelAndView.addObject("mainTitle", "Serviços");
		modelAndView.addObject("secondTitle", "Serviços");
		modelAndView.addObject("caption", "Agende ou ou cancele serviços disponíveis na loja.");
		modelAndView.addObject("js", "servico.js");
		modelAndView.addObject("servicos", getServico());
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping(value = "/getservicosagendados")
	public List<ServicoAgendado> getServico()
	{
		try {
			return ordemServicoService.getServicoCliente(getUsuarioCorrente().getId());
		} catch (Exception e) {
			return null;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getanimaisservico")
	public List<Animal> getCadastroAnimal()
	{
		try {
			return animalRepository.findByUsuario(getUsuarioCorrente());
		} catch (Exception e) {
			return null;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/cancelarordemservico")
	public Servico cancelarOrdemServico(Long ordemServicoId)
	{
		Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(ordemServicoId);
		try {
			ordemServico.get().setStatus("Cancelado");
			ordemServico.get().setDataFinalizada(new Date());
			ordemServicoRepository.save(ordemServico.get());
		} catch (Exception e) {
			return null;
		}
		return ordemServico.get().getServico();
	}

	@ResponseBody
	@RequestMapping(value = "/servicos", method = RequestMethod.POST)
	public OrdemServico postServicoPage(@Valid OrdemServico ordemServico, BindingResult bindingResult, Long servicoId,
			Long animalId, HttpServletRequest request, final RedirectAttributes redirectAttributes,
			HttpServletRequest response)
	{
		if (bindingResult.hasErrors()) {
			// tratar com uma growl mensagem?
			redirectAttributes.addFlashAttribute("mensagemErro", bindingResult.getAllErrors());
			return null;
		}
		ordemServico.setStatus("Aberto");
		try {
			return ordemServicoService.salvar(ordemServico, animalId, servicoId,
					(Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		} catch (Exception e) {
			return null;
		}
	}
}
