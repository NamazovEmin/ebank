package ru.namazov.ebank.config.security;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.spring.security.VaadinWebSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import ru.namazov.ebank.login.view.LoginView;
import ru.namazov.ebank.security.repository.UserRepository;

import lombok.AllArgsConstructor;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfig extends VaadinWebSecurity {

    private final UserRepository userRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        setLoginView(http, LoginView.class);
    }
    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsManager userDetailsManager(){
        List<UserDetails> users = new ArrayList<>();
        List<ru.namazov.ebank.security.entity.User> usersFromDB = new ArrayList<>(userRepository.findAll());
        usersFromDB.forEach(user -> users.add(User
                .withUsername(user.getLogin())
                .password(passwordEncoder().encode(user.getPassword()))
                .roles(user.getRoles().get(0).getName())
                .build()));
        return new InMemoryUserDetailsManager(users);
    }
}
