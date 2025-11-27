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
@RequestMapping("/conta")
public class UserController{
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/contas")
	public List<UserMinDTO> findAll(){
	 	List<UserMinDTO> result = userService.findAll();
        return result;
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<Optional<UserMinDTO>> getUserByName(@PathVariable String name){
		return new ResponseEntity<Optional<UserMinDTO>>(userService.findUserByName(name), HttpStatus.OK);
	}
}
