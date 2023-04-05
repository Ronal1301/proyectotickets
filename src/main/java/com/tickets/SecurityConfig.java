package com.tickets;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService users() {
        UserDetails admin = User.builder()
                .username("gustavo")
                .password("{noop}123")
                .roles("USER", "VENDEDOR", "ADMIN")
                .build();
        UserDetails vendedor = User.builder()
                .username("adriela")
                .password("{noop}456")
                .roles("USER", "VENDEDOR")
                .build();
        UserDetails usuario = User.builder()
                .username("ronal")
                .password("{noop}789")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(usuario, vendedor, admin);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests((request) -> request
                .requestMatchers("/",
                        "/index",
                        "errores/**",
                        "/webjars/**").permitAll()
                .requestMatchers("/cliente/nuevo",
                        "/cliente/guardar",
                        "/cliente/modificar/**",
                        "/cliente/eliminar/**",
                        "/categoria/nuevo",
                        "/categoria/guardar",
                        "/categoria/modificar/**",
                        "/categoria/eliminar/**",
                        "/actividad/nuevo",
                        "/actividad/guardar",
                        "/actividad/modificar/**",
                        "/actividad/eliminar/**")
                        .hasRole("ADMIN")
                        .requestMatchers("/cliente/listado",
                        "/categoria/listado",
                        "/actividad/listado")
                        .hasAnyRole("ADMIN", "VENDEDOR"))
                .formLogin((form) -> form
                .loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll())
                .exceptionHandling().accessDeniedPage("/errores/403");
        return http.build();
    }
}
