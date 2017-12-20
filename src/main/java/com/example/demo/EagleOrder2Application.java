package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@ServletComponentScan
@MapperScan("com.example.demo.order.dao")
@EnableTransactionManagement 
//@ComponentScan(basePackages={"com.example.demo.order.dao,com.example.demo.order.pojo,com.example.demo.x"}) 
public class EagleOrder2Application {

	public static void main(String[] args) {
		SpringApplication.run(EagleOrder2Application.class, args);
	}
	
	/**
	 * 查看使用哪种事务管理器 
	 * @param platformTransactionManager
	 * @return org.springframework.orm.jpa.JpaTransactionManager
	 */
	@Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager){
        System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
        return new Object();
    }
}
