package controller; /**
 * Created by Anthony on 2016/8/7.
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by 三劫散仙 on 2015/4/24.
 */
//@EnableAutoConfiguration
@Configuration
@ComponentScan
@EnableAutoConfiguration
//@EnableAutoConfiguration
//@EnableTransactionManagement
@SpringBootApplication
@ImportResource("applicationContext.xml")
//@EnableWebMvc
public class hello {
    public static void main(String[] args) {
        //第一个简单的应用，
        SpringApplication.run(hello.class,args);

    }

}