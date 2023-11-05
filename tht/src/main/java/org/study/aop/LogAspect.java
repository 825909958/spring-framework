package org.study.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
	@Pointcut("execution(* org.study.service.*.*(..))")
	public void pointCut(){}
	@Before("pointCut()")
	public void before(JoinPoint joinPoint){
		String className = joinPoint.getSignature().getDeclaringTypeName();//得到调用的类名
		String methodName = joinPoint.getSignature().getName();//获取方法名
		System.out.println("准备执行"+className+"的"+methodName+"方法");
	}

	@After("pointCut()")
	public void after(JoinPoint joinPoint){
		String className = joinPoint.getSignature().getDeclaringTypeName();//得到调用的类名
		String methodName = joinPoint.getSignature().getName();//获取方法名
		System.out.println(className+"的"+methodName+"方法执行完毕");
	}

	@AfterReturning(value = "pointCut()",returning = "returnValue")
	public void returnMethod(JoinPoint joinPoint,Object returnValue){
		System.out.println("输入参数为"+ Arrays.toString(joinPoint.getArgs()));
		System.out.println("返回值为"+returnValue);
	}
}
