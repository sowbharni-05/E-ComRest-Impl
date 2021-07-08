package com.banfico.EcomApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    Contact contact = new Contact("Sowbharnika",
            "https://www.sowbharni_ecomapplication","sowbharni@gmail.com");

    List<VendorExtension> vendorExtensionList = new ArrayList<>();

    ApiInfo apiInfo =new ApiInfo("EcomApplication Swagger Document",
            "This project demonstrates basic e-commerce operations.",
            "1.0.1 ",
            "http://www.appsdeveloperblof.com/service.html", contact,
            "Apache 2.0 "," http://www.apache.org/licenses/LICENSE-2.0 ",vendorExtensionList);

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.banfico.EcomApplication"))
                .build()
                .apiInfo(apiInfo);
    }
}
