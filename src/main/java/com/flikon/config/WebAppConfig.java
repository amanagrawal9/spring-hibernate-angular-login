package com.flikon.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.flikon.util.Constants;

@Configuration
@EnableWebMvc
@ComponentScan("com.flikon")
@PropertySource("classpath:application.properties")
@EnableScheduling
public class WebAppConfig extends WebMvcConfigurerAdapter {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	/* To load properties files */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer();
		ClassPathResource locations[] = {
				new ClassPathResource("/application.properties")};
		ppc.setLocations(locations);
		return ppc;
	}

	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	
	@Bean
	public OpenEntityManagerInViewInterceptor openEntityManagerInViewInterceptor() {
		OpenEntityManagerInViewInterceptor oemiv = new OpenEntityManagerInViewInterceptor();
		oemiv.setEntityManagerFactory(entityManagerFactory);
		return oemiv;
	}
	
	// Provides internationalization of messages
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename(Constants.MESSAGE_SOURCE_BASE_NAME);
		messageSource.setDefaultEncoding(Constants.DEFAULT_ENCODING);
		return messageSource;
	}
	
	// The LocaleChangeInterceptor class will intercept any changes in the locale. 
	@Bean 
    public LocaleChangeInterceptor localeChangeInterceptor() { 
            LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor(); 
            localeChangeInterceptor.setParamName(Constants.DEFAULT_LANGUAGE); 
            return localeChangeInterceptor; 
    } 
	
	@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/resources/app/");
		viewResolver.setSuffix(".html");
		/*viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");*/
        return viewResolver;
    }
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/*.html").addResourceLocations("/WEB-INF/pages/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/").setViewName("forward:/index.jsp");
	}
	/*
	@Override
	  public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/").setViewName("index");
	  }*/

}
