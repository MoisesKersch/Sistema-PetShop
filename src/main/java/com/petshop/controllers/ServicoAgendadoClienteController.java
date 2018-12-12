package com.petshop.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.component.SessaoInfo;
import com.petshop.models.OrdemServico;
import com.petshop.repositories.OrdemServicoRepository;

@Controller
public class ServicoAgendadoClienteController extends SessaoInfo
{

	@Autowired
	OrdemServicoRepository ordemServicoRepository;

	@RequestMapping(value = "/servicoagendadocliente")
	public ModelAndView getServicoPage()
	{
		ModelAndView modelAndView = new ModelAndView("servicoagendadocliente");

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
		modelAndView.addObject("caption",
				"Demonstração de todos os seus serviços agendados. Você pode selecionar os serviços que deseja pagar e proseguir com o pagamento.");
		modelAndView.addObject("js", "servico-agendado-cliente.js");
		modelAndView.addObject("jsEditor", "servico-agendado-cliente-editor.js");
		modelAndView.addObject("tableId", "servico-agendado-cliente-table");
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping(value = "/servicoagendadocliente",  method = RequestMethod.POST)
	public List<OrdemServico> getServico()
	{
		try {
			return ordemServicoRepository.findByUsuarioAndEmpresaAndNotCanceled(getUsuarioCorrente(),
					getUsuarioCorrente().getEmpresa());
		} catch (Exception e) {
			return null;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/pagar", method = RequestMethod.POST)
	public List<OrdemServico> postPagar(@RequestParam(value = "ordemServicoIds[]") String[] ordemServicoIds)
	{
		try {
			for (int x = 0; x < ordemServicoIds.length; x++) {
				OrdemServico ordemServico = ordemServicoRepository.findById(Long.valueOf(ordemServicoIds[x])).get();
				ordemServico.setStatus("Pago");
				ordemServico.setDataFinalizada(new Date());
				ordemServicoRepository.save(ordemServico);
			}
		} catch (Exception e) {
			return null;
		}
		return getServico();
	}
}
