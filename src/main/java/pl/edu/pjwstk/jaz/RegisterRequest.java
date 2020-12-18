package pl.edu.pjwstk.jaz;

public class RegisterRequest { //prosta klasa dla registru
    //na razie puste
    private final String username;
    private final String password;
    private final String name;

    public RegisterRequest(String username, String password, String name){
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getName(){
        return name;
    }
}
