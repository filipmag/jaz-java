package pl.edu.pjwstk.jaz;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepository {
    User first_admin = new User("admin", "admin", "admin", "admin");
    User first_user = new User("user", "user", "user", "user");

    private Map<String, User> userMap = new HashMap<>(){{
        put(first_admin.login , first_admin);
        put(first_user.login, first_user);
    }};

    public void add(String username, String password, String name){
        User user = new User(username, password, name);
        userMap.put(username, user);
    }
    public Optional<User> findByUsername(String username){
        User user = userMap.get(username);
        return Optional.ofNullable(user);
    }

    public boolean usernameExist(String username) {
        return userMap.containsKey(username);
    }

    public boolean passwordMatch(String username, String password){
        return password.equals(userMap.get(username).getPassword());
    }

    public User getUser(String username){
        return userMap.get(username);
    }
}
