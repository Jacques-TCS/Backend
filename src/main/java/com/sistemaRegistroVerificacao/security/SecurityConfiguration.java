package com.sistemaRegistroVerificacao.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sistemaRegistroVerificacao.model.entity.Usuario;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private SecurityFilter filter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/usuario/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/servicoPrestado/salvar").permitAll()
                        .requestMatchers(HttpMethod.GET, "/servicoPrestado/todos").permitAll()
                        .requestMatchers(HttpMethod.GET, "/servicoPrestado/filtro").permitAll()
                        .requestMatchers(HttpMethod.GET, "/usuario/todos").hasRole(Usuario.NIVEL_RH)
                        .requestMatchers(HttpMethod.GET, "/usuario/todos").hasRole(Usuario.NIVEL_FUNCIONARIO)
                        .requestMatchers(HttpMethod.PUT, "/usuario/atualizar").hasRole(Usuario.NIVEL_RH)
                        .requestMatchers(HttpMethod.PUT, "/usuario/atualizar").hasRole(Usuario.NIVEL_FUNCIONARIO)
                        .requestMatchers(HttpMethod.POST, "/usuario/salvar").hasRole(Usuario.NIVEL_RH)
                        .requestMatchers(HttpMethod.POST, "/usuario/salvar").hasRole(Usuario.NIVEL_FUNCIONARIO)
                        .requestMatchers(HttpMethod.POST, "/ocorrencia/todos").hasRole(Usuario.NIVEL_RH)
                        .requestMatchers(HttpMethod.POST, "/ocorrencia/todos").hasRole(Usuario.NIVEL_FUNCIONARIO)
                        //voltar aqui e ver como se faz isso direito pq não entendi
                        .anyRequest().authenticated()
                )
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
