package pl.edu.pjwstk.jaz;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppWebSecurityConfig {
    //metoda tworząca
    @Bean
    public FilterRegistrationBean<Filter> Filter(UserSession userSession){
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new Filter(userSession));
        registrationBean.addUrlPatterns("/auth0/*");

        return registrationBean;
    }
}
