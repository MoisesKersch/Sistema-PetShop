package com.petshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.component.SessaoInfo;
import com.petshop.models.OrdemServico;
import com.petshop.repositories.OrdemServicoRepository;

@Controller
public class ServicoAgendadoControllerClient extends SessaoInfo
{

	@Autowired
	OrdemServicoRepository ordemServicoRepository;

	@RequestMapping(value = "/servicoagendadoclient")
	public ModelAndView getServicoPage()
	{
		ModelAndView modelAndView = new ModelAndView("servicoagendadoclient");

		if (getUsuarioCorrente() == null)
			return new ModelAndView("/login");

		try {
			modelAndView.addObject("papel", getUsuarioCorrente().getRoles().iterator().next().getRole());
			modelAndView.addObject("nome", getUsuarioCorrente().getNome());
		} catch (Exception e) {

		}
		
		modelAndView.addObject("page", "Serviços Agendados");
		modelAndView.addObject("mainTitle", "Serviços Agendados");
		modelAndView.addObject("secondTitle", "Serviços Agendados");
		modelAndView.addObject("caption", "Demonstração de todos os seus serviços agendados.");
		modelAndView.addObject("js", "servico-client-agendado.js");
		modelAndView.addObject("jsEditor", "servico-agendado-client-editor.js");
		modelAndView.addObject("tableId", "servico-agendado-client-table");
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping(value = "/getordemservicocliente")
	public List<OrdemServico> getServico()
	{
		try {
			return ordemServicoRepository.findByUsuarioAndEmpresaAndNotCanceled(getUsuarioCorrente(), getUsuarioCorrente().getEmpresa());
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
