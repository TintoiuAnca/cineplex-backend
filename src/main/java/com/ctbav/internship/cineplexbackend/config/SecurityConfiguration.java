package com.ctbav.internship.cineplexbackend.config;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import com.auth0.spring.security.api.JwtWebSecurityConfigurer;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Value(value = "${auth0.apiAudience}")
    private String apiAudience;
    @Value(value = "${auth0.issuer}")
    private String issuer;
    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
        configuration.setAllowCredentials(true);
        configuration.addAllowedHeader("Authorization");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    protected void configure(HttpSecurity http) throws Exception {
        JwtWebSecurityConfigurer.forRS256(apiAudience, issuer).configure(http).authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/v1/movies").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/movies/**").permitAll()
//              .antMatchers(HttpMethod.GET, "/api/v1/history").permitAll()
//              .antMatchers(HttpMethod.GET, "/api/v1/payment").permitAll()
//              .antMatchers(HttpMethod.GET, "/api/v1/reservation").permitAll()
//              .antMatchers(HttpMethod.GET, "/api/v1/user").permitAll()
//              .antMatchers(HttpMethod.GET, "/api/v1/ticket").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/room").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/seat").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/seat/**").permitAll()
//              .antMatchers(HttpMethod.GET, "/api/v1/statistic").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/schedule").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/schedule/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/usertype").permitAll()
//              .antMatchers(HttpMethod.GET, "/api/v1/movies/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/movies").permitAll()
//              .antMatchers(HttpMethod.POST, "/api/v1/history").permitAll()
//              .antMatchers(HttpMethod.POST, "/api/v1/payment").permitAll()
//              .antMatchers(HttpMethod.POST, "/api/v1/reservation").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/user").permitAll()
//              .antMatchers(HttpMethod.POST, "/api/v1/ticket").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/room").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/seat").permitAll()
//              .antMatchers(HttpMethod.POST, "/api/v1/statistic").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/schedule").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/usertype").permitAll()
//              .antMatchers(HttpMethod.POST, "/api/v1/movies/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/user").hasAuthority("view:users").anyRequest().authenticated();
    }

}
