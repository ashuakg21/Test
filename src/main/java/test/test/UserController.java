package test.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/addUser")
	public Users addUser(@RequestBody Users user) {
		return userService.createUser(user);
	}

	@PostMapping("/addUsers")
	public List<Users> addUsers(@RequestBody List<Users> users) {
		return userService.createUsers(users);
	}

	@GetMapping("/user/{id}")
	public Users getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}

	@GetMapping("/users")
	public List<Users> getAllUsers() {
		return userService.getUsers();
	}
	
	@PutMapping("/updateuser")
	public Users updateUser(@RequestBody Users user) {
		return userService.updateUser(user);
	}

	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {
		return userService.deleteUserById(id);
	}
}
