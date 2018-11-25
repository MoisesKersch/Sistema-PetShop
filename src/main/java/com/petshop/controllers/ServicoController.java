//package com.petshop.controllers;
//
//import java.util.List;
//import java.util.Optional;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import com.petshop.models.Empresa;
//import com.petshop.models.Servico;
//import com.petshop.models.Usuario;
//import com.petshop.repositories.EmpresaRepository;
//import com.petshop.repositories.OrdemServicoRepository;
//import com.petshop.repositories.ServicoRepository;
//
//@Controller
//public class ServicoController
//{
//	@Autowired
//	private ServicoRepository servicoRepository;
//	
//	@Autowired
//	private EmpresaRepository empresaRepository;
//	
//	@Autowired
//	private OrdemServicoRepository ordemServicoRepository;
//
//	@RequestMapping(value = "/servicos")
//	public ModelAndView getServicoPage()
//	{
//		ModelAndView modelAndView = new ModelAndView("servicos");
//		Usuario usuario = null;
//
//		try
//		{
//			usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		} catch (Exception e)
//		{
//		}
//
//		if (usuario != null)
//		{
//			if (usuario.getLogin() == null)
//			{
//				SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
//				return null;
//			}
//		} else
//		{
//			return new ModelAndView("/login");
//		}
//
//		try
//		{
//			modelAndView.addObject("papel", usuario.getRoles().iterator().next().getRole());
//			modelAndView.addObject("nome", usuario.getNome());
//		} catch (Exception e)
//		{
//
//		}
//
//		modelAndView.addObject("page", "Cadastro Servico");
//		return modelAndView;
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/getservicos")
//	public List<Servico> getServicos()
//	{
//		// carrega empresa do petshop
//		Optional<Empresa> empresaFinder = empresaRepository.findById(1L);
//
//		if (empresaFinder.isPresent())
//		{
//			return servicoRepository.findByEmpresa(empresaFinder.get());
//		} else
//		{
//			return null;
//		}
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/servicos", method = RequestMethod.POST)
//	public Servico postServicoPage(@Valid Servico servico, BindingResult bindingResult, HttpServletRequest request,
//			final RedirectAttributes redirectAttributes)
//	{
//		if (bindingResult.hasErrors())
//		{
//			// tratar com uma growl mensagem?
//			redirectAttributes.addFlashAttribute("mensagemErro", bindingResult.getAllErrors());
//			return null;
//		}
//
//		try
//		{
//			if (servico.getPedigree() == null)
//				servico.setPedigree("Não");
//
//			servico.setUsuario((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//			servico = servicoRepository.save(servico);
//		} catch (Exception e)
//		{
//			System.out.println(e.getMessage());
//			return null;
//		}
//		return servico;
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/servicoremove", method = RequestMethod.POST)
//	public Servico removerUsuario(Long id)
//	{
//		try
//		{
//			servicoRepository.deleteById(id);
//		} catch (Exception e)
//		{
//			return null;
//		}
//		return null;
//	}
//}
