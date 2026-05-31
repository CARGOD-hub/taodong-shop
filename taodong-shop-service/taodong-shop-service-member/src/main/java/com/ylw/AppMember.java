package com.ylw;

// import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
// import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
//@EnableSwagger2Doc  // 禁用旧版 Swagger，与 Spring Boot 2.7.x 不兼容
//@EnableApolloConfig
@MapperScan(basePackages = "com.ylw.service.member.mapper")
public class AppMember {

    public static void main(String[] args) {
        SpringApplication.run(AppMember.class, args);
    }

}
