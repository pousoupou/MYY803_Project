package com.uoi.softeng.app.config;

import com.uoi.softeng.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{

    @Autowired
    private CustomSecuritySuccessHandler customSecuritySuccessHandler;

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

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        String[] PUBLIC_ENDS = {"../static/**", "/hello", "/register", "/login", "/error"};
        String[] ADMIN_ENDS = {"/admin/**"};
        String[] USER_ENDS = {"/user/**"};
        String[] API_ENDS = {"/api/**"};

        http.csrf(
                (csrf) -> csrf
                        .ignoringRequestMatchers("/api/**")
        );

        http.authenticationProvider(authenticationProvider());

        http.formLogin(fL -> fL.loginPage("/login")
                .failureUrl("/login?error=true")
                .successHandler(customSecuritySuccessHandler)
                .usernameParameter("email")
                .passwordParameter("password")
        );

        http.logout(logOut -> logOut.logoutUrl("/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
        );

        http.authorizeHttpRequests(
                (auth) -> auth
                        .requestMatchers(PUBLIC_ENDS).permitAll()
//                        .requestMatchers(ADMIN_ENDS).hasRole("ADMIN")
                        .requestMatchers(USER_ENDS).hasRole("USER")
                        .anyRequest().authenticated()
        );

        return http.build();
    }
}
