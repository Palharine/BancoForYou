package org.foryou.bancoforyou.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//Mudar o mapping do site nessa parte
@RequestMapping("/conta")
//Serve para receber os métodos do repository, contendo a lógica de negócio da aplicação
@Service
public class UserService{
	
	@Autowired
	UserRepository userRepository;
	
	public void save(Usuarios user) {
		userRepository.save(user);
	}
	@GetMapping("/conta/contas")
	public List<Usuarios> allUsers() {
		return userRepository.findAll();	
		}
	
	public Optional<Usuarios> oneUser(String name){
		return userRepository.findUserByName(name);
	}
}