package org.study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.study.service.LogService;

/**
 * 1.1.下载慢的配置下国内镜像，gradle
 * 1.2.涉及到其他版本spring可以查对应的gradle版本和jdk版本以及aspectj用的那个版本
 * 1.3.其他aspectj用于测试springaop功能，springaop使用了asoectj的功能，jdk解析不出来，所以需要使用aspectj编译器，
 *   具体配置aspectj就是直接idea下载插件，然后引入到spring-aop，在aj编译器指定aspectj本地安装路径
 * 2.1.aspectj 1.9.7在jdk8基础上开发
 * 2.2.aspectj 1.9.8支持jdk17   https://github.com/eclipse-aspectj/aspectj/releases
 * 2.3.spring6.x 在jdk17基础上开发
 * 2.4.gradle 7.5.1
 * 2.5.jdk 17
 * 2.6.受检查的包在settings.gradle去除
 * plugins {
 * 	id "com.gradle.enterprise" version "3.12.6"
 * //	id "io.spring.ge.conventions" version "0.0.13"
 * }
 * 2.7.新建模块的plugins{id 'java'}-> {id 'java-library'},否则其他模块部分功能引入不进来
 * 2.8.新建模板位置错了的时候，移除模板，在删除，在去除项目settings.gradle配置的模板引入
 * 2.9.gradle的clean清楚，classes编译，有时候调着调着新代码一直更新不上，就clean在classes
 */
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyApplication.class);
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}
		LogService logSercice = (LogService)context.getBean("logService");
		logSercice.log();
	}
}
