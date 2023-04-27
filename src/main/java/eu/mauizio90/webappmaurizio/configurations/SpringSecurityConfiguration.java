package eu.mauizio90.webappmaurizio.configurations;

import java.util.function.Function;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 *
 * @author mauiz
 */
@Configuration
public class SpringSecurityConfiguration {
    
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){
        
        UserDetails userDetails = createNewUser("mauizio90", "password");
        UserDetails userDetails1 = createNewUser("mau", "pas");
        
        return new InMemoryUserDetailsManager(userDetails, userDetails1);
        
    }

    private UserDetails createNewUser(final String username, final String password) {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles("USER","ADMIN")
                .build();
        return userDetails;
    }
    
    @Bean 
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
