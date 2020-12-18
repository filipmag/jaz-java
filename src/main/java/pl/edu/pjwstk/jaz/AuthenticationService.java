package pl.edu.pjwstk.jaz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component // @Service
public class AuthenticationService {
    UserSession userSession;
    UserRepository userRepository;

    @Autowired
    public AuthenticationService(UserSession userSession, UserRepository userRepository){
        this.userSession = userSession;
        this.userRepository = userRepository;
    }

    public boolean login(String username, String password){
        // kod do zalogowania się
        // jest zalogowany

        //User checkUser = new User(username, password);
        //User registerUser = registerController.getUser(username);
        if(userRepository.usernameExist(username)){
            if(userRepository.passwordMatch(username, password)){
                userSession.logIn();
                SecurityContextHolder.getContext().setAuthentication(new AppAuthentication(userRepository.getUser(username)));
                return true;
            }
        }


        //var user = new User(Collections.emptySet());
        return false;
    }

}
