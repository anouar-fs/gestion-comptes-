package com.ensah.gestion_comptes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import CustomFilter.CustomFilter;


@SpringBootApplication
public class GestionComptesApplication{

	public static void main(String[] args) {
		SpringApplication.run(GestionComptesApplication.class, args);
	
	}
	
	 @Bean
	    public FilterRegistrationBean<CustomFilter> customFilterRegistration() {
	        FilterRegistrationBean<CustomFilter> registration = new FilterRegistrationBean<>();
	        registration.setFilter(customFilter());
	        registration.addUrlPatterns("/showForm"); 
	        registration.addUrlPatterns("/addUtilisateur");
	        registration.addUrlPatterns("/admin/comptes");
	        registration.addUrlPatterns("/admin/FormCompte");
	        
	        
	        
	        
	        // Specify the URL patterns to which the filter should be applied
	        // You can also set the order of the filter execution using registration.setOrder()
	        return registration;
	    }

	    @Bean
	    public CustomFilter customFilter() {
	        return new CustomFilter();
	    }
	

}
