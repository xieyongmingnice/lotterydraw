package com.blue.lotterydraw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * springboot 启动类
 * @author
 */
@SpringBootApplication
@MapperScan("com.blue.lotterydraw.mapper")
@ComponentScan(basePackages = {
		"com.blue.lotterydraw.config",
		"com.blue.lotterydraw.controller",
		"com.blue.lotterydraw.service"})
public class LotteryDrawApplication {

	public static void main(String[] args) {
		SpringApplication.run(LotteryDrawApplication.class, args);
	}

}
