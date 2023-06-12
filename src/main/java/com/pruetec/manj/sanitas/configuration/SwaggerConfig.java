package com.pruetec.manj.sanitas.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * Clase de configuracion de Swagger
 */

//@Configuration
@EnableSwagger2
//@ComponentScan
public class SwaggerConfig implements WebMvcConfigurer {

	/**
	 * Metodo principal de la configuracion de Swagger
	 * @return Docket de configuracion de Swagger
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
//				.apis(RequestHandlerSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.pruetec.manj.sanitas.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/swagger-ui/");
		registry.addRedirectViewController("/swagger-ui", "/swagger-ui/");
		registry.addRedirectViewController("/calculadora", "/swagger-ui/");
	}

	
	
}
