package com.systemcrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.systemcrud.domain.Usuario;
import com.systemcrud.services.UsuarioService;

@Controller
@RequestMapping("/")
public class ApplicationController {
	
	@Autowired
	private UsuarioService UsuarioService;

	
	@GetMapping("usuarios")
	public ModelAndView paginaDeUsuarios(@PageableDefault(size = 5) Pageable pg) {
		
		ModelAndView view = new ModelAndView("listaUsuarios");
		Page<Usuario> usuarios = UsuarioService.listarUsuarios(pg);
		view.addObject("usuarios", usuarios);
		return view;
	}
	
	@GetMapping("formusuario")
	public ModelAndView formUsuario() {
		ModelAndView view = new ModelAndView("cadastro/formUsuario");
		return view;
	}
	
	@PostMapping("salvarusuario")
	public String salvarUsuario(Usuario usuario, Model model) {
		UsuarioService.salvarUsuario(usuario);
		model.addAttribute("status", "sucess");
		model.addAttribute("message", "Usuário criado com sucesso");
		return "redirect:/usuarios";
	}
	
	@GetMapping("deleteusuario/{id}")
	public String deletarUsuario(@PathVariable("id") Long id, Model model) {
		UsuarioService.deletar(id);
		model.addAttribute("message", "Usuario deletado");
		return "redirect:/usuarios";
	}
	
	@GetMapping("editarusuario/{id}")
	public ModelAndView formEditarUsuario(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("cadastro/formEdit");
		Usuario usuario  = UsuarioService.usuarioPorId(id);
		view.addObject("usuario", usuario);
		return view;
	}
	
	@PostMapping("salvaralteracoes/{id}")
	public String salvarAlteracoes(@PathVariable("id") Long id, Usuario usuario, Model model) {
		UsuarioService.alterarUsuario(id, usuario);
		model.addAttribute("message", "Alterações salvas com sucesso!");
		return "redirect:/usuarios";
	}
	
	
}
