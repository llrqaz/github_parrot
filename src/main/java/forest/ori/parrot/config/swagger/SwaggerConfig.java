package forest.ori.parrot.config.swagger;


import org.springframework.beans.factory.annotation.Value;
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
    @Value("${swagger.enabled}")
    private Boolean enabled;
    @Bean
    @SuppressWarnings("all")
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                //是否开启Swagger
                .enable(enabled)
                //设置Api的描述
                .apiInfo(apiInfo())
                .select()
                //swagger要扫描的包路径
                .apis(RequestHandlerSelectors.basePackage("forest.ori.parrot.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot Swagger 测试")
                .description("Springboot 整合Swagger2")
                .version("1.0")
                .build();
    }
}
