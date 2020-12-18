package pl.edu.pjwstk.jaz;

import java.util.HashSet;
import java.util.Set;

public class User {
    public String login;
    public String password;
    public String name;
    public Set<String> Authorities;

    public User(String login, String password, String name, String auth){
        this.login = login;
        this.password = password;
        this.name = name;
        Authorities = new HashSet<>();
        Authorities.add(auth);
    }

    public User(String login, String password, String name){
        this.login = login;
        this.password = password;
        this.name = name;
        Authorities = new HashSet<>();
        Authorities.add("basic");
    }

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }
    //setup of getters and setters for login password and name
    public String getLogin(){
        return login;
    }
    public void setLogin(){
        this.login = login;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(){
        this.password = password;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public Set<String> getAuthorities(){
        return Authorities;
    }
    public User(Set<String> Authorities){
        this.Authorities = Authorities;
    }
}
