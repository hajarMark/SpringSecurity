package com.wildcodeschool.myProjectWithSecurity.config;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    private final String champion = "CHAMPION";
    private final String director = "DIRECTOR";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("Steve").password(encoder.encode("motdepasse")).roles(champion)
                .and()
                .withUser("Nick").password(encoder.encode("flerken")).roles(director);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(auth -> auth
                .mvcMatchers("/").permitAll()
                .mvcMatchers("/avengers/assemble").hasRole(champion)
                .mvcMatchers("/secret-bases").hasRole(director)
                .anyRequest().denyAll())
                .formLogin()
                .and()
                .httpBasic()
                .and()
                .logout();
    }
}
