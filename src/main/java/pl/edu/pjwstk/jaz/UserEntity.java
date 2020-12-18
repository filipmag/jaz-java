package pl.edu.pjwstk.jaz;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    //setup of getters and setters for (id, username, password) for UserEntity
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
