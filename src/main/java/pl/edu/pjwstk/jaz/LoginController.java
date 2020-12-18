package pl.edu.pjwstk.jaz;

import org.springframework.jmx.export.UnableToRegisterMBeanException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private UserRepository userRepository;
    private final AuthenticationService authenticationService;

    public LoginController(AuthenticationService  authenticationService, UserRepository userRepository){
        this.userRepository = userRepository;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginRequest loginRequest){
        //uwierzytelnić
        var ussr = userRepository.findByUsername(loginRequest.getUsername());

        if(ussr.isPresent()){
            var isLogged = authenticationService.login(loginRequest.getUsername(), loginRequest.getPassword());
            if(!isLogged){
                throw new UnauthorizedException();
            }
        }

        if(ussr.isEmpty()){  //if user does not exist(is empty) gtfo
            throw new UnauthorizedException();
        }

        //previously there was userSession.logIn();
    }
}
