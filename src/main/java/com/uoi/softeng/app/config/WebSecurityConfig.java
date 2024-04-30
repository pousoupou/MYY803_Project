package com.uoi.softeng.app.config;

import com.uoi.softeng.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


/*
 * @Configuration Indicates that a class declares one or more
 * @Bean methods and may be processed by the
 * Spring container to generate bean definitions
 * and service requests for those beans at runtime.
 * The class may also have code that configures other
 * spring functionalities.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig{

    @Autowired
    private CustomSecuritySuccessHandler customSecuritySuccessHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                (authz) -> authz
//                        .requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
//                        .requestMatchers("/user/**").hasAnyAuthority("USER")
//                        .requestMatchers("/css/**").permitAll()
                        .requestMatchers("/", "/login", "/register", "/save", "/resources/**").permitAll()
                        .anyRequest().permitAll()
        );

//        http.formLogin(fL -> fL.loginPage("/login")
//                .failureUrl("/login?error=true")
//                .successHandler(customSecuritySuccessHandler)
//                .usernameParameter("username")
//                .passwordParameter("password")
//        );
//
//        http.logout(logOut -> logOut.logoutUrl("/logout")
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/")
//        );
//
//
//        http.authenticationProvider(authenticationProvider());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }
}
