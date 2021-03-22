package com.systemcrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systemcrud.domain.Usuario;
import com.systemcrud.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public void salvarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public List<Usuario> listarUsuarios(){
		return usuarioRepository.findAll();
	}
	
	public void deletar(Long id) {
		Usuario user = usuarioRepository.findById(id).get();
		usuarioRepository.delete(user);
	}
	
	public Usuario usuarioPorId(Long id) {
		return usuarioRepository.findById(id).get();
	}
	
	public void alterarUsuario(Long idusuario, Usuario obj) {
		Usuario user = usuarioRepository.findById(idusuario).get();
		user.setNome(obj.getNome());
		user.setDataNascimento(obj.getDataNascimento());
		user.setSobrenome(obj.getSobrenome());
		usuarioRepository.save(user);
	}
	
}
