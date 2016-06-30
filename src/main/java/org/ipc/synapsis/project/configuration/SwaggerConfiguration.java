package org.ipc.synapsis.project.configuration;


import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.ipc.synapsis.project.resource.impl.ProjectResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@Configuration
@EnableSwagger2
@ComponentScan(basePackageClasses = { ProjectResource.class })
public class SwaggerConfiguration {

    @Bean
    public Docket petApi() {
    	return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
    			.paths(Predicates.not(PathSelectors.regex("/error"))).build().apiInfo(apiInfo()); 
    }

    @Autowired
    private TypeResolver typeResolver;

    private ApiKey apiKey() {
        return new ApiKey("mykey", "api_key", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/anyPath.*")).build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return newArrayList(new SecurityReference("mykey", authorizationScopes));
    }

    @Bean
    SecurityConfiguration security() {
        return new SecurityConfiguration("test-app-client-id", "test-app-realm", "test-app", "apiKey");
    }

    @Bean
    UiConfiguration uiConfig() {
        return new UiConfiguration("validatorUrl");
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
          "Synapsis",
          "Project REST API",
          "",
          "Terms of service",
          "ilyass.togui@capgemini.com",
          "",
          "");
        return apiInfo;
    }
   }