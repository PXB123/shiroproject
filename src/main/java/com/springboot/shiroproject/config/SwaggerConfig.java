/**
 * <h3>shiroproject</h3>
 * <p>Swagger配置</p>
 *
 * @author : 蒲雪冰
 * @date : 2020-01-07 19:39
 **/
package com.springboot.shiroproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.springboot.shiroproject.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("项目后台API测试")
                .description("项目的主要后台API列表")
                .contact(new Contact("蒲雪冰", "http://127.0.0.1:8080", "2679862469@qq.com"))
                .version("1.0.0-SNAPSHOT")
                .build();
    }
}
