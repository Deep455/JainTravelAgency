package com.jaintravelagency.jaintravelagency.Config;


import com.jaintravelagency.jaintravelagency.Services.EmployeeDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    EmployeeDetailsServiceImpl userDetailsService;

    @Autowired
    public WebSecurityConfiguration(EmployeeDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception{
        return authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/","/login","/logout","/homepage","/register","/registersuccess","/registererror").permitAll();
        http.authorizeRequests().antMatchers("/self","/self/**","/loggedhomepage","/showemployee","/showtrip","/showvehicle","/tripregister","/tripregistersuccess","/vehicleregister","/vehicleregistersuccess").access("hasAuthority('normalemployee') or hasAuthority('admin')");
        http.authorizeRequests().antMatchers("/admin","/admin/**","/deleteemployee","deleteemployeesuccess","/deleteemployeeerror","/deletetrip","/deletetriperror","/deletetripsuccess","/deletevehicle","deletevehicleerror","deletevehiclesuccess").access("hasAuthority('admin')");
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/accessdenied");
        http.authorizeRequests().and().formLogin().loginPage("/login")
                .defaultSuccessUrl("/loggedhomepage",true).failureUrl("/login?error=true").usernameParameter("empId")
                .passwordParameter("password").and().logout().logoutUrl("/logout").logoutSuccessUrl("/");
    }

}
