package spineapp.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import spineapp.backend.services.LoggedInUserDetailsService;

import javax.servlet.http.HttpServletResponse;
import java.security.SecureRandom;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JWTFilter filter;
    private final LoggedInUserDetailsService uds;

    /**
     * Constructs instance of JWTFilter with the loggedInUserDetailsService and jwtFilter via dependency injection.
     * @param filter Parameter of type JWTFilter to be injected into.
     * @param uds Parameter of type LoggedInUserDetailsService to be injected into.
     */
    @Autowired
    public SecurityConfig(JWTFilter filter, LoggedInUserDetailsService uds) {
        this.filter = filter;
        this.uds = uds;
    }

    /**
     * Configures the security of the http session of the user.
     * @param http the {@link HttpSecurity} to modify.
     * @throws Exception
     */
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .httpBasic().disable()
                .cors()
                .and()
                .authorizeHttpRequests()
                // ALL ALLOWED ENDPOINTS FOR ALL USERS (AUTHENTICATED AND UNAUTHENTICATED)//
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("/newpassword/{accountId}").permitAll()
                // ADMIN ACCOUNT TYPE ROUTES//
//                .antMatchers("/api/account/{accountId}/authorised").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/api/account/{accountId}").hasRole("ADMIN")
                .and()
                .userDetailsService(uds)
                .exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, authException) ->
                                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized")
                )
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("*");
            }
        };
    }

    /**
     * Creates a bean for the passwordEncoder. This lets Spring Boot handle the creation and management of the PasswordEncoder.
     * @return Returns a BCryptPasswordEncoder with strength: 10 and new SecureRandom().
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10, new SecureRandom());
    }

    /**
     * Creates a bean for the authenticationManager. This lets Spring Boot handle the creation and management of the authenticationManager.
     * @return
     * Returns an authenticationManagerBean.
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
