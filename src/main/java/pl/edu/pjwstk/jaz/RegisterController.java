package pl.edu.pjwstk.jaz;



import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@RestController
public class RegisterController {

    /*public HashMap<String, User> users = new HashMap<~>();

    public HashMap<String, User> getUsersMap() {
        return users;
    }
    public User getUser(String username){
        if(users.containsKey(username)) return users.get(username);
        return null;
    }*/
    UserRepository userRepository;

    public RegisterController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest registerRequest) {
        //register user
        if(userRepository.findByUsername(registerRequest.getUsername()).isEmpty()){
            userRepository.add(registerRequest.getUsername(), registerRequest.getPassword(), registerRequest.getName());
        }
        else {
            throw new UnauthorizedException();
        }
    }
}
