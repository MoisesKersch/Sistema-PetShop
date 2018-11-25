package com.petshop.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.petshop.component.SessaoInfo;
import com.petshop.models.Servico;
import com.petshop.models.ServicoCategoria;
import com.petshop.repositories.ServicoCategoriaRepository;
import com.petshop.repositories.ServicoRepository;
import com.petshop.services.ServicoCategoriaService;
import com.petshop.services.ServicoService;

@Controller
public class CadastroServicoController extends SessaoInfo
{
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private ServicoCategoriaRepository servicoCategoriaRepository;
	
	@Autowired
	private ServicoCategoriaService servicoCategoriaService;

	@Autowired
	private ServicoService servicoService;

	@RequestMapping(value = "/cadastroservico")
	public ModelAndView getCadastroServicoPage()
	{
		ModelAndView modelAndView = new ModelAndView("cadastroservico");
		
		if (getUsuarioCorrente() == null)
			return new ModelAndView("/login");

		try
		{
			modelAndView.addObject("papel", getUsuarioCorrente().getRoles().iterator().next().getRole());
			modelAndView.addObject("nome", getUsuarioCorrente().getNome());
		} catch (Exception e)
		{

		}

		return modelAndView;
	}

	@ResponseBody
	@RequestMapping(value = "/getservicos")
	public List<Servico> getCadastroServico()
	{
		try
		{
			return servicoRepository.findByEmpresa( getEmpresa() );
		} catch (Exception e)
		{
			return null;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getcategorias")
	public List<ServicoCategoria> getCategorias()
	{
		try
		{
			return servicoCategoriaRepository.findByEmpresa( getEmpresa() ) ;
		} catch (Exception e)
		{
			return null;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/cadastroservico", method = RequestMethod.POST)
	public Servico postCadastroServico(@Valid Servico servico, BindingResult bindingResult, HttpServletRequest request,
			final RedirectAttributes redirectAttributes, Long categoriaId)
	{
		if (bindingResult.hasErrors())
		{
			// tratar com uma growl mensagem?
			redirectAttributes.addFlashAttribute("mensagemErro", bindingResult.getAllErrors());
			return null;
		}
		servico.setEmpresa( getUsuarioCorrente().getEmpresa() );
		return servicoService.salvar(servico, categoriaId);
	}

	@ResponseBody
	@RequestMapping(value = "/cadastrocategoria", method = RequestMethod.POST)
	public ServicoCategoria postCadastroCategoria(@Valid ServicoCategoria servicoCategoria, BindingResult bindingResult,
			HttpServletRequest request, final RedirectAttributes redirectAttributes)
	{

		if (bindingResult.hasErrors())
		{
			// tratar com uma growl mensagem?
			redirectAttributes.addFlashAttribute("mensagemErro", bindingResult.getAllErrors());
			return null;
		}

		try
		{
			servicoCategoria.setEmpresa( getEmpresa() );
			return servicoCategoriaService.salvar(servicoCategoria);
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/removerservico", method = RequestMethod.POST)
	public Servico removerServico(Long id)
	{
		try
		{
			servicoRepository.deleteById(id);
		} catch (Exception e)
		{
			return null;
		}
		return new Servico();
	}

	@ResponseBody
	@RequestMapping(value = "/removercategoria", method = RequestMethod.POST)
	public ServicoCategoria removerCategoria(Long id)
	{
		try
		{
			servicoCategoriaRepository.deleteById(id);
		} catch (Exception e)
		{
			return null;
		}

		return new ServicoCategoria();
	}
}
