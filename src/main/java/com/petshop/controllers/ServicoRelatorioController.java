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
public class ServicoRelatorioController extends SessaoInfo
{
	@Autowired
	private UltimoAgendadoRepository ultimoAgendadoRepository;

	@Autowired
	OrdemServicoRepository ordemServicoRepository;

	@RequestMapping(value = "/servicorelatorio")
	public ModelAndView getServicoPage()
	{
		ModelAndView modelAndView = new ModelAndView("servicorelatorio");

		if (getUsuarioCorrente() == null)
			return new ModelAndView("/login");

		try {
			modelAndView.addObject("papel", getUsuarioCorrente().getRoles().iterator().next().getRole());
			modelAndView.addObject("nome", getUsuarioCorrente().getNome());
		} catch (Exception e) {

		}
		
		ultimoAgendadoRepository.deleteAll();
		
		modelAndView.addObject("page", "Serviços Relatório");
		modelAndView.addObject("mainTitle", "Serviços Relatório");
		modelAndView.addObject("secondTitle", "Serviços Relatório");
		modelAndView.addObject("caption", "Serviços Relatório.");
		modelAndView.addObject("js", "servico-relatorio.js");
		modelAndView.addObject("tableId", "servico-relatorio-table");
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping(value = "/servicorelatorio",  method = RequestMethod.POST)
	public List<OrdemServico> getServico()
	{
		try {
			return ordemServicoRepository.findByEmpresa(getUsuarioCorrente().getEmpresa());
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
