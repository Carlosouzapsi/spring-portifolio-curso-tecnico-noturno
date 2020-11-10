package br.com.gerenciamentoprojetos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.gerenciamentoprojetos.security.ProjetoUserDetailsService;

@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	ProjetoUserDetailsService projetoUserDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			//Habilitar index
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/usuario/add").permitAll()
			.antMatchers("/usuario/save").permitAll()
			//Restrição específica por pasta com base na permissão
			//TODO: essas duas linhas só funcionam inserindo manualmente no banco a permissao
			//TODO: fazer um controle de usuário no sistema para gerenciar essas telas
			//.antMatchers("/funcinario/**").hasRole("padrao")
			//.antMatchers("/projeto/**").hasRole("padrao")
			//Habilitar as pastas Static
			.antMatchers("/bootstrap-4.5.2/**").permitAll()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/img/**").permitAll()
			.antMatchers("/fontawesome/**").permitAll()
			.antMatchers("/js/**").permitAll()
			//Restrição genérica que exige o usuário estar logado
			.anyRequest().authenticated()
			.and()
			//LOGIN
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/projeto/list", true)
				.permitAll()
			.and()
			//Relembrar
			.rememberMe();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception{
		builder
			.userDetailsService(projetoUserDetailsService)
			.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	public static void main(String[] args) {
		System.out.println("Senha criptografada: " + new BCryptPasswordEncoder().encode("123456"));
	}

}
