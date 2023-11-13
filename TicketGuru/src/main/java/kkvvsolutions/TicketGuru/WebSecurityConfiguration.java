package kkvvsolutions.TicketGuru;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import kkvvsolutions.TicketGuru.web.UserDetailServiceImpl;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
@EnableWebSecurity
public class WebSecurityConfiguration {

        @Autowired
        private UserDetailServiceImpl userDetailsService;

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http
                                .authorizeHttpRequests(authorize -> {
                                        authorize
                                                        .requestMatchers(new AntPathRequestMatcher("/api/users/**"))
                                                        .hasAuthority("ADMIN")
                                                        .requestMatchers(new AntPathRequestMatcher("/api/**"))
                                                        .hasAnyAuthority("ADMIN", "TICKETSELLER")
                                                        .requestMatchers(new AntPathRequestMatcher("/api/sales/**",
                                                                        HttpMethod.POST.name()))
                                                        .hasAnyAuthority("ADMIN", "TICKETSELLER")
                                                        .requestMatchers(new AntPathRequestMatcher("/api/sales/**",
                                                                        HttpMethod.DELETE.name()))
                                                        .hasAnyAuthority("ADMIN", "TICKETSELLER")
                                                        .anyRequest().authenticated();
                                })
                                .formLogin(Customizer.withDefaults())
                                .csrf(AbstractHttpConfigurer::disable)
                                .cors(Customizer.withDefaults())
                                .httpBasic(Customizer.withDefaults())
                                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()));

                return http.build();
        }
        
        @Bean
        CorsConfigurationSource corsConfigurationSource() {
        	CorsConfiguration configuration = new CorsConfiguration();
        	configuration.setAllowedOrigins(Arrays.asList("*")); // Esim. "https://localhost:8080"
        	configuration.setAllowedMethods(Arrays.asList("*")); // ("GET", "POST"), jne.
        	configuration.setAllowedHeaders(Arrays.asList("*"));
        	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        	source.registerCorsConfiguration("/**", configuration);
        	return source;
        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
                auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        }
}
