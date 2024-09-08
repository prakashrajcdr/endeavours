package com.prakash.AOPDemo.aspect;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.prakash.AOPDemo.dto.Employee;

@Aspect
@Slf4j
@Component
public class GeneralInterceptorAdvice {

    @Pointcut("execution (* com.prakash.AOPDemo.controller.*.*(..))")
//    @Pointcut("within(com.prakash.AOPDemo.controller.*)") // within for package level
//    @Pointcut("this(com.prakash.AOPDemo.controller.MainController)") // this for class level
//	@Pointcut("@annotation(com.prakash.AOPDemo.annotations.Important)") // annotation for annotation level
    public void loggingPointCut(){}

    @Before("loggingPointCut()")
    public void before(JoinPoint joinPoint){
        log.info("Before advice invoke : " + joinPoint.getSignature().getName());
    }

    @After("execution (java.util.List<com.prakash.AOPDemo.dto.Employee> com.prakash.AOPDemo.controller.*.*(..))") // instead of pointcut loggingPointCut()
    public void after(JoinPoint joinPoint){
        log.info("After advice invoke : " + joinPoint.getArgs());
    }
    
    @AfterThrowing(pointcut = "loggingPointCut()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
    	log.info("AfterThrowing Advice - " + ex.getMessage());
    }
    
    @Around("loggingPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
    	Object obj = null;
    	
    	log.info("Around Advice Before proceeding.. ");
//    	log.info("Around Advice Before proceeding Thread -  " + Thread.currentThread().getName());
    	
    	obj = joinPoint.proceed();
    	
    	if(obj instanceof Employee)
    		log.info("Around Advice After proceeding Employee - " + (Employee) obj);
    	else if(obj instanceof List<?>)
    		log.info("Around Advice After proceeding List<Employee> - " + (List<Employee>) obj);
    	else
    		log.info("Around Advice After proceeding String or void - " + (String) obj);

    	
    	
    	return obj;
    }

}
