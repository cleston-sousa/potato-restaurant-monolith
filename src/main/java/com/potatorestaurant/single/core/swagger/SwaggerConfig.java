package com.potatorestaurant.single.core.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket swaggerAPI() {
		return new Docket(DocumentationType.SWAGGER_2).select()
		// @formatter:off
		//.apis(RequestHandlerSelectors.any())
		//.paths(PathSelectors.any())
		.apis(RequestHandlerSelectors.basePackage("com.potatorestaurant.single.api"))
		.build()
		.useDefaultResponseMessages(false)
		.apiInfo(apiInfo());
		// @formatter:on
	}

	private ApiInfo apiInfo() {
		// @formatter:off
		return new ApiInfoBuilder()
				.title("Potato Restaurant Monolith API")
				.description("Open API documentation")
				.version("1")
				.contact(new Contact("Cleston Sousa", "https://github.com/cleston-sousa/", ""))
				.build();
		// @formatter:on
	}
}
