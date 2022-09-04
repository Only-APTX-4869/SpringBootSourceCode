package com.czh.highlight_spring4.ch1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect //1
@Component //2
public class LogAspect {
	
	@Pointcut("@annotation(com.czh.highlight_spring4.ch1.aop.Action)") //3
	public void annotationPointCut(){};
	
	  @After("annotationPointCut()") //4
	    public void after(JoinPoint joinPoint) {
	        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	        Method method = signature.getMethod();
	        Action action = method.getAnnotation(Action.class);
		  System.out.println("logAspect.after()" + action.name()); //5
	    }
	  
	   @Before("execution(* com.czh.highlight_spring4.ch1.aop.DemoMethodService.*(..))") //6
	    public void before(JoinPoint joinPoint){
	        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	        Method method = signature.getMethod();
		   System.out.println("logAspect.before()" + method.getName());

	    }
	   
	  
	
}
