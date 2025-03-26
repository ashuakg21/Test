package test.test;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import test.test.UserSimple;
import test.test.UserServiceSimple;


@RestController()
public class UserControllerSimple {

    private final UserServiceSimple userService;

    @Autowired
    public UserControllerSimple(UserServiceSimple userService){
        this.userService = userService;
    }

    @GetMapping("/user")
    public UserSimple getUser(@RequestParam Integer id){
        Optional<UserSimple> user = userService.getUser(id);
        return (UserSimple) user.orElse(null);
    }
}
