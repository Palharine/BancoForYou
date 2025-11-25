package org.foryou.bancoforyou.User;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta/contas")
public class UserController{
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<Usuarios>> getallUsers(){
		return new ResponseEntity<List<Usuarios>>(userService.allUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<Optional<Usuarios>> getUserByName(@PathVariable String name){
		return new ResponseEntity<Optional<Usuarios>>(userService.oneUser(name), HttpStatus.OK);
	}
	
}