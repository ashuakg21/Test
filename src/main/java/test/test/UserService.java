package test.test;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public Users createUser(Users user) {
		return userRepository.save(user);
	}

	public List<Users> createUsers(List<Users> users) {
		return userRepository.saveAll(users);
	}

	public Users getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}

	public List<Users> getUsers() {
		return userRepository.findAll();
	}
	
	public Users updateUser(Users user) {
		Users oldUser=null;
		Optional<Users> optionaluser=userRepository.findById(user.getId());
		if(optionaluser.isPresent()) {
			oldUser=optionaluser.get();
			oldUser.setName(user.getName());
			oldUser.setAddress(user.getAddress());
			userRepository.save(oldUser);
		}else {
			return new Users();
		}
		return oldUser;
	}
	
	public String deleteUserById(int id) {
		userRepository.deleteById(id);
		return "User got deleted";
	}

}
