package pl.edu.pjwstk.jaz;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class UserService {
    private final EntityManager em;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(EntityManager em) { this.em = em;}

    public void saveUser(String username){
        var userEntity = new UserEntity();

        //        userEntity.setUsername("pjanowiak")
        //        userEntity.setPassword("pjanowiak")

        em.persist(userEntity);
        //      userEntity.getId() > 0
    }
    public UserEntity findUserByUsername(String username){
        return em.createQuery("select ue from UserEntity ue where ue.username = :username", UserEntity.class)
                .setParameter("username", username) //username!!
                .getSingleResult();
    }
}
