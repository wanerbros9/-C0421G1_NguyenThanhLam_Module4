package com.codegym.config;

import com.codegym.model.service.impl.MyUserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailServiceImpl myUserDetailService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*Cài đặt cách lấy thông tin UserDetail, cơ chế Encoder...*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder());
    }

    /*Cấu hình security bằng HTTP basic*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                /*Login thanh cong se chuyen huong ve URL man hinh hien tai,
                neu truy cap truc tiep /login thi login thanh cong se chuyen huong ve /student */
                    .defaultSuccessUrl("/home").permitAll()
                .and()
                    .authorizeRequests().antMatchers("/home").permitAll()
                    .antMatchers("/employee/list").hasAnyRole("CUSTOMER","ADMIN","EMPLOYEE")
                    .antMatchers("/employee**").hasAnyRole("ADMIN,EMPLOYEE")
                    .antMatchers("/customer**").hasAnyRole("ADMIN,EMPLOYEE")
                    .antMatchers("/service**").hasAnyRole("ADMIN,EMPLOYEE")
                    .antMatchers("/contract**").hasAnyRole("ADMIN,EMPLOYEE")
                /* Tất cả request gởi lên server đều phải thực hiện xác thực*/
                .anyRequest().authenticated();
        /* Tất cả request gởi lên server không cần thực hiện xác thực*/
//                .authorizeRequests().anyRequest().permitAll();

        //Cau hinh remember me
        http.authorizeRequests().and().rememberMe()
                .tokenRepository(this.persistentTokenRepository()).tokenValiditySeconds(60*60*5);
    }
    
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return memoryTokenRepository;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/customize/**", "/jquery/**", "/dis/**", "/vendor/**");
    }
}
