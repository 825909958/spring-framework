package org.study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.study.entity.Car;

@Configuration
@ComponentScan(basePackageClasses = MyApplication.class)
@EnableAspectJAutoProxy
public class MyApplication {
	@Bean
	public Car test() {
		return new Car();
	}
}
