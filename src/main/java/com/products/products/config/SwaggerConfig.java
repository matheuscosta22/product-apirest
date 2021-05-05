package com.products.products.config;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.service.VendorExtension;
import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    @Bean
  public Docket apiProuct(){
      return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.products.products"))
        .paths(regex("/api.*"))
        .build()
        .apiInfo(metaInfo());
  }
  
  private ApiInfo metaInfo(){
      ApiInfo apiInfo = new ApiInfo(
        "API REST Products",
        "API REST for produtc registration.",
        "1.0",
         "terms of Service ", new Contact("Matheus Costa", "https://www.linkedin.com/in/matheus-costa-ba6090201",
            "mcostadesantana2539@gmail.com"
        ), "Apache license version", "https://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>()
      );

      return apiInfo;
  }

}
