package com.petshop.controllers;

import java.util.List;

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
import com.petshop.models.Usuario;
import com.petshop.repositories.AnimalRepository;

@Controller
public class CadastroAnimalController extends SessaoInfo
{
	@Autowired
	private AnimalRepository animalRepository;

	@RequestMapping(value = "/cadastroanimal")
	public ModelAndView getCadastroAnimalPage()
	{
		ModelAndView modelAndView = new ModelAndView("cadastroanimal");

		if (getUsuarioCorrente() == null)
			return new ModelAndView("/login");

		try
		{
			modelAndView.addObject("papel", getUsuarioCorrente().getRoles().iterator().next().getRole());
			modelAndView.addObject("nome", getUsuarioCorrente().getNome());
		} catch (Exception e)
		{

		}

		modelAndView.addObject("page", "Cadastro Animal");
		modelAndView.addObject("mainTitle", "Cadastrar Animais");
		modelAndView.addObject("secondTitle", "Cadastrar Animais");
		modelAndView.addObject("caption", "Cadastre, remova e altere animais cadastrados no seu sistema.");
		
		return modelAndView;
	}

	@ResponseBody
 	@RequestMapping(value = "/getanimais")
	public List<Animal> getCadastroAnimal()
	{
		try 
		{
			return animalRepository.findByUsuario(getUsuarioCorrente());
		} catch (Exception e) {
			return null;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/cadastroanimal", method = RequestMethod.POST)
	public Animal postCadastroAnimalPage(@Valid Animal animal, BindingResult bindingResult, HttpServletRequest request, final RedirectAttributes redirectAttributes)
	{
		if (bindingResult.hasErrors())
		{
			// tratar com uma growl mensagem?
			redirectAttributes.addFlashAttribute("mensagemErro", bindingResult.getAllErrors());
			return null;
		}
		
		try
		{
			if (animal.getPedigree() == null)
				animal.setPedigree("Não");
			
			animal.setUsuario((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
			animal = animalRepository.save(animal);
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
		return animal;
	}

	@ResponseBody
	@RequestMapping(value = "/animalremove", method = RequestMethod.POST)
	public Boolean removerAnimal(Long id)
	{
		try 
		{
			animalRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
