package br.com.springboot.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.springboot.bo.ClienteBO;
import br.com.springboot.model.Cliente;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	
	private ClienteBO bo;


	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(ModelMap model) {
		model.addAttribute("cliente", new Cliente());
		return new ModelAndView("/cliente/formulario", model);
	}
	
	@RequestMapping(value = "", method=RequestMethod.POST)
	public String salva(@ModelAttribute("cliente") Cliente cliente) {
		if (cliente.getId() == null)
			bo.insere(cliente);
		else
			bo.atualiza(cliente);
		return "redirect:/clientes/novo";
	}

}
