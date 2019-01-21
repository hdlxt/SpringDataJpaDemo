package com.lxt.demo;

import com.lxt.demo.dao.UserDao;
import com.lxt.demo.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
//
//    @Value("${spring.datasource.driverClassName}")
//    private String jdbcDriver;
//    @Value("${spring.datasource.url}")
//    private String jdbcUrl;
//    @Value("${spring.datasource.username}")
//    private String jdbcUser;
//    @Value("${spring.datasource.password}")
//    private String jdbcPassword;
//    @Bean
//    public DataSource getDataSource() {
//        DataSourceBuilder dataSource=  DataSourceBuilder.create();
//        dataSource.driverClassName(jdbcDriver);
//        dataSource.url(jdbcUrl);
//        dataSource.username(jdbcUser);
//        dataSource.password(jdbcPassword);
//        return dataSource.build();
//    }
}

