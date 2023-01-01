package Com.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

public interface AppSecurityConfig2 {
    @Bean
    PasswordEncoder encoder();

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception;

    void configure(AuthenticationManagerBuilder auth) throws Exception;
}
