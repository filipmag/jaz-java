package pl.edu.pjwstk.jaz;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class UserSession {
    //tutaj jakaś zmienna informacja
    //która pozwoli określić czy użytkownik jest zalogowany czy nie
    private boolean logged = false;
    public void logIn(){
        logged = true;
    }
    public void logOut(){
        logged = false;
    }
    public boolean isLoggedIn() {
        return logged;
    }
    //metody do zarządzania tą informacją
}
