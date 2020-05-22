package com.znsd.config;

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

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        // 创建API页面展示信息
        ApiInfo apiInfo = new ApiInfoBuilder()
                // 页面标题 swagger-ui.html的标题
                .title("SpringBoot整合Swagger2-znsd")
                // 描述下的链接信息
                .contact(new Contact("laosu", "192.168.0.28", ""))
                // 版本号  页面标题上显示的版本号
                .version("1.0")
                // 页面API文档的描述信息
                .description("API 描述").build()
                ;

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(
                        // 将包路径下所有方法扫描成API
                        RequestHandlerSelectors.basePackage("com.znsd.controller")
                )
                .paths(PathSelectors.any())
                .build().protocols(Stream.of("http").collect(Collectors.toSet()));
    }
}
