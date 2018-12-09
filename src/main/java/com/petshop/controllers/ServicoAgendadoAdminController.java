package com.petshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.component.SessaoInfo;
import com.petshop.models.OrdemServico;
import com.petshop.repositories.OrdemServicoRepository;
import com.petshop.repositories.UltimoAgendadoRepository;

@Controller
public class ServicoAgendadoAdminController extends SessaoInfo
{
	@Autowired
	private UltimoAgendadoRepository ultimoAgendadoRepository;

	@Autowired
	OrdemServicoRepository ordemServicoRepository;

	@RequestMapping(value = "/servicoagendadoadmin")
	public ModelAndView getServicoPage()
	{
		ModelAndView modelAndView = new ModelAndView("servicoagendadoadmin");

		if (getUsuarioCorrente() == null)
			return new ModelAndView("/login");

		try {
			modelAndView.addObject("papel", getUsuarioCorrente().getRoles().iterator().next().getRole());
			modelAndView.addObject("nome", getUsuarioCorrente().getNome());
		} catch (Exception e) {

		}
		
		ultimoAgendadoRepository.deleteAll();
		
		modelAndView.addObject("page", "Serviços Agendados");
		modelAndView.addObject("mainTitle", "Serviços Agendados");
		modelAndView.addObject("secondTitle", "Serviços Agendados");
		modelAndView.addObject("caption", "Agende ou ou cancele serviços disponíveis na loja.");
		modelAndView.addObject("js", "servico-agendado-admin.js");
		modelAndView.addObject("tableId", "servico-agendado-admin-table");
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping(value = "/servicoagendadoadmin",  method = RequestMethod.POST)
	public List<OrdemServico> getServico()
	{
		try {
			return ordemServicoRepository.findByEmpresaAndStatus(getUsuarioCorrente().getEmpresa(), "Aberto");
		} catch (Exception e) {
			return null;
		}
	}
//
//	@ResponseBody
//	@RequestMapping(value = "/getanimaisservico")
//	public List<Animal> getCadastroAnimal()
//	{
//		try {
//			return animalRepository.findByUsuario(getUsuarioCorrente());
//		} catch (Exception e) {
//			return null;
//		}
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/cancelarordemservico")
//	public Servico cancelarOrdemServico(Long ordemServicoId)
//	{
//		Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(ordemServicoId);
//		try {
//			ordemServico.get().setStatus("Cancelado");
//			ordemServico.get().setDataFinalizada(new Date());
//			ordemServicoRepository.save(ordemServico.get());
//		} catch (Exception e) {
//			return null;
//		}
//		return ordemServico.get().getServico();
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/servicos", method = RequestMethod.POST)
//	public OrdemServico postServicoPage(@Valid OrdemServico ordemServico, BindingResult bindingResult, Long servicoId,
//			Long animalId, HttpServletRequest request, final RedirectAttributes redirectAttributes,
//			HttpServletRequest response)
//	{
//		if (bindingResult.hasErrors()) {
//			// tratar com uma growl mensagem?
//			redirectAttributes.addFlashAttribute("mensagemErro", bindingResult.getAllErrors());
//			return null;
//		}
//
//		try {
//			return ordemServicoService.salvar(ordemServico, animalId, servicoId,
//					(Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//		} catch (Exception e) {
//			return null;
//		}
//	}
}
