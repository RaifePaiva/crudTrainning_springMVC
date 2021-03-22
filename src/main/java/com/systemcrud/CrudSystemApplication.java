package com.systemcrud;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.systemcrud.domain.Usuario;
import com.systemcrud.repositories.UsuarioRepository;

@SpringBootApplication
public class CrudSystemApplication implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CrudSystemApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		
		
		Usuario user1 = new Usuario(null, "Raífe", "Ferreira Paiva", LocalDate.of(1997, 11, 22));
		Usuario user2 = new Usuario(null, "Jorge", "Quintanilla Ribeiro", LocalDate.of(1990, 6, 15));
		Usuario user3 = new Usuario(null, "Rafael", "Justino Souza", LocalDate.of(1982, 8, 10));
		Usuario user4 = new Usuario(null, "Júlio", "Queiroz Dias", LocalDate.of(2000, 1, 20));
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3, user4));
		
		
	}

}
