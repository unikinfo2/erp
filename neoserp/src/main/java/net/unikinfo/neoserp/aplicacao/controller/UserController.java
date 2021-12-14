package net.unikinfo.neoserp.aplicacao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import net.unikinfo.neoserp.aplicacao.model.User;
import net.unikinfo.neoserp.aplicacao.repository.UserRepository;

@Controller
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/formusuario")
	public RedirectView form() {
		System.out.println("Entrei");
		return new RedirectView("formUsuario", true);
	}
	
	@GetMapping("/{id}")
	public User user(@PathVariable("id") Long id) {
		Optional<User> userFind = userRepository.findById(id);
		if(userFind.isPresent()) {
			return userFind.get();
		}
		return null;
	}

	@PostMapping("/")
	public User user(@RequestBody User user) {
		return userRepository.save( user );
	}
	
	@GetMapping("/list")
	public List<User> userList() {
		return userRepository.findAll();
	}

}
