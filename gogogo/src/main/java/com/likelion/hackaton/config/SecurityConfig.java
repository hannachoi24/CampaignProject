package com.likelion.hackaton.config;

import com.likelion.hackaton.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @Configuration
 * config bean 을 명시해주는 annotation
 */
@Configuration

/**
 * @EnableWebSecurity
 * spring security config를 할 클래스라는 것을 명시
 */
@EnableWebSecurity
@RequiredArgsConstructor
// WebSecurityConfigurerAdapter 를 상속받아 필요한 메서드 구현
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AccountService accountService;

    /**
     * 입력받은 비밀번호를 그대로 DB에 저장하는 것이 아니라,
     * 암호화해서 저장
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * WebSecurity는 FilterChainProcy를 생성하는 필터,
     * ignoring()을 사용하여 Spring security가 무시할수 있도록 설정가능
     * 파일의 기준 경로는 resources/static
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/css/**","/img/**");
    }

    /**
     * http로 들어오는 요청에대하여 보안을 구성할 수 있는 클래스
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/**").permitAll()
                .and()
             .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .and()
            .exceptionHandling();

    }

    /**
     * 인증을 관리하는 AuthenticationManage를 생성하는 클래스,
     * 유저의 정보를 memberService에서 찾아 담아줌
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .userDetailsService(accountService)
                .passwordEncoder(passwordEncoder());
    }
}
