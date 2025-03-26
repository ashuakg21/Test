package test.test;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceSimple {

    private List<UserSimple> userList;

    public UserServiceSimple() {
        userList = new ArrayList<>();

        UserSimple user1 = new UserSimple(1,"Ida", 32, "ida@mail.com");
        UserSimple user2 = new UserSimple(2,"Hans", 26, "hans@mail.com");
        UserSimple user3 = new UserSimple(3,"Lars", 45, "lars@mail.com");
        UserSimple user4 = new UserSimple(4,"Ben", 32, "ben@mail.com");
        UserSimple user5 = new UserSimple(5,"Eva", 59, "eva@mail.com");

        userList.addAll(Arrays.asList(user1,user2,user3,user4,user5));
    }

    public Optional<UserSimple> getUser(Integer id) {
        Optional<UserSimple> optional = Optional.empty();
        for (UserSimple user: userList) {
            if(id == user.getId()){
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }
}
