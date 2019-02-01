package com.test.RestFulWebServices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService userService;

	@GetMapping("/users")
	public List<User> retrieveAll(){
		
		return userService.findAll();
	}
	@GetMapping("/users/{userId}")
	public Resource<User> retrieveUser(@PathVariable int userId) {
		User user = userService.findOne(userId);
		if(user==null) {
			throw new UserNotFoundException("Id-"+userId);
		}
		
		Resource<User> userResource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAll());
		userResource.add(linkTo.withRel("all-users"));
		return userResource;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		
		User returnUser=userService.saveUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(returnUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{userId}")
	public void deleteUser(@PathVariable int userId) {
		User user = userService.deleteById(userId);
		if(user==null) {
			throw new UserNotFoundException("Id-"+userId);
		}
		
	}
}
