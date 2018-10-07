package uy.com.cvaucher.mvc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private DataSource dataSource;
	
	@Value("${spring.queries.users-query}")
	private String usersQuery;
	
	@Value("${spring.queries.roles-query}")
	private String rolesQuery;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.
			jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery(usersQuery)
				.authoritiesByUsernameQuery(rolesQuery)
				.passwordEncoder(passwordEncoder())
				.and().eraseCredentials(false);
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
//		http.authorizeRequests()
//		.antMatchers("/").permitAll()
//		.antMatchers("/login").permitAll()
//		.antMatchers("/registration").permitAll()
//		.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN").anyRequest()
//		.authenticated().and().formLogin()
//		.loginPage("/login")
//		.loginProcessingUrl("/j_spring_security_check")
//		.usernameParameter("j_username")
//		.passwordParameter("j_password")
//		.defaultSuccessUrl("/pacsearch")
//		.failureUrl("/login?error=true")
//		.and().logout()
//		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//		.logoutSuccessUrl("/").and().exceptionHandling()
//		.accessDeniedPage("/login");
		
		http.csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("**/login")).and().authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/registration").permitAll()
				.antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
				.authenticated().and().formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/j_spring_security_check")
				.usernameParameter("j_username")
				.passwordParameter("j_password")
				.defaultSuccessUrl("/pacsearch")
				.failureUrl("/login?error=true")
				.and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login").and().exceptionHandling()
				.accessDeniedPage("/access-denied");
			
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/Images/**, /ICO/**, /fonts/**");
	}

//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		CharSequence rawPassword=new CharSequence();
//		this.bCryptPasswordEncoder.encode(rawPassword);
//		return bCryptPasswordEncoder;
//	}
	
	@Bean
	public SimpleUrlLogoutSuccessHandler logoutRedirectToAny() {
		SimpleUrlLogoutSuccessHandler simpleUrlLogoutSuccessHandler= new SimpleUrlLogoutSuccessHandler();
		simpleUrlLogoutSuccessHandler.setTargetUrlParameter("redirectTo");
		
		return simpleUrlLogoutSuccessHandler;
	}
	
	@Bean
	public DefaultWebSecurityExpressionHandler webSecurityExpressionHandler() {
		return new DefaultWebSecurityExpressionHandler();
	}
}
