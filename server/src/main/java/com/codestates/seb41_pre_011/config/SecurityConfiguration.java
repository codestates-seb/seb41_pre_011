package com.codestates.seb41_pre_011.config;
import com.codestates.seb41_pre_011.auth.filter.JwtAuthenticationFilter;
import com.codestates.seb41_pre_011.auth.filter.JwtVerificationFilter;
import com.codestates.seb41_pre_011.auth.handler.MemberAccessDeniedHandler;
import com.codestates.seb41_pre_011.auth.handler.MemberAuthenticationEntryPoint;
import com.codestates.seb41_pre_011.auth.handler.MemberAuthenticationFailureHandler;
import com.codestates.seb41_pre_011.auth.handler.MemberAuthenticationSuccessHandler;
import com.codestates.seb41_pre_011.auth.jwt.JwtTokenizer;
import com.codestates.seb41_pre_011.auth.utils.CustomAuthorityUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {
    private final JwtTokenizer jwtTokenizer;
    private final CustomAuthorityUtils authorityUtils;

    public SecurityConfiguration(JwtTokenizer jwtTokenizer, CustomAuthorityUtils authorityUtils) {
        this.jwtTokenizer = jwtTokenizer;
        this.authorityUtils = authorityUtils;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().sameOrigin()
                .and()
                .csrf().disable()
//                .cors(withDefaults())
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin()
                .loginPage("/auth/login")
                .loginProcessingUrl("/process_login")
                .failureUrl("/auth/login?error")
                .and()
                .httpBasic().disable()
                .exceptionHandling()
                .authenticationEntryPoint(new MemberAuthenticationEntryPoint())
                .accessDeniedHandler(new MemberAccessDeniedHandler())
                .and()
                .apply(new CustomFilterConfigurer())
                .and()
                .authorizeHttpRequests(authorize -> authorize
//                        .antMatchers(HttpMethod.POST,"/*/member").permitAll()
//                        .antMatchers(HttpMethod.GET, "/*/member").hasRole("ADMIN")
//                        .antMatchers(HttpMethod.POST,"/*/question").hasAnyRole("USER","ADMIN")
//                        .antMatchers(HttpMethod.PATCH,"/*/question/**").hasAnyRole("USER","ADMIN")
//                        .antMatchers(HttpMethod.DELETE,"/*/question/**").hasAnyRole("USER","ADMIN")
//                        .antMatchers(HttpMethod.POST,"/*/answer").hasAnyRole("USER","ADMIN")
//                        .antMatchers(HttpMethod.PATCH,"/*/answer/**").hasAnyRole("USER","ADMIN")
//                        .antMatchers(HttpMethod.DELETE,"/*/answer/**").hasAnyRole("USER","ADMIN")
//                        .antMatchers(HttpMethod.POST,"/*/tag").hasAnyRole("USER","ADMIN")
//                        .antMatchers(HttpMethod.PATCH,"/*/tag/**").hasAnyRole("USER","ADMIN")
//                        .antMatchers(HttpMethod.DELETE,"/*/tag/**").hasAnyRole("USER","ADMIN")
                        .anyRequest().permitAll()
                );
        return http.build();
    }

    public class CustomFilterConfigurer extends AbstractHttpConfigurer<CustomFilterConfigurer, HttpSecurity>{
        @Override
        public void configure(HttpSecurity builder) throws Exception{
            AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);
            JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager,jwtTokenizer);
            jwtAuthenticationFilter.setFilterProcessesUrl("/v1/auth/login");
            jwtAuthenticationFilter.setAuthenticationSuccessHandler(new MemberAuthenticationSuccessHandler());
            jwtAuthenticationFilter.setAuthenticationFailureHandler(new MemberAuthenticationFailureHandler());

            JwtVerificationFilter jwtVerificationFilter = new JwtVerificationFilter(jwtTokenizer,authorityUtils);

            builder
                    .addFilter(jwtAuthenticationFilter)
                    .addFilterAfter(jwtVerificationFilter, JwtAuthenticationFilter.class);
        }
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST", "PATCH", "DELETE"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}