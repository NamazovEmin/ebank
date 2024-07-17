package ru.namazov.ebank.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import ru.namazov.ebank.security.repository.UserRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ru.namazov.ebank.security.entity.User user = userRepository.findUserByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с таким логином не найден"));
        return new SecurityUser(user.getLogin(),passwordEncoder.encode(user.getPassword()), user.getAuthorities());
    }
}
