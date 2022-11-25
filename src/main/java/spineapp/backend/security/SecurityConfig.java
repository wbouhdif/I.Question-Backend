package spineapp.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import spineapp.backend.services.LoggedInUserDetailsService;
import javax.servlet.http.HttpServletResponse;
import java.security.SecureRandom;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired private JWTFilter filter;
    @Autowired private LoggedInUserDetailsService uds;

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
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/account/**").hasRole("SPINE")
                .antMatchers("/api/account/**").hasRole("CAREGIVER")
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

    /**
     * Creates a bean for the passwordEncoder. This lets Spring Boot handle the creation and management of the PasswordEncoder.
     * @return Returns a BCryptPasswordEncoder with strength: 10 and new SecureRandom().
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10, new SecureRandom());
    }

    /**
     * Created a bean for the authenticationManager. This lets Spring Boot handle the creation and management of the authenticationManager.
     * @return
     * Returns an authenticationManagerBean.
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
