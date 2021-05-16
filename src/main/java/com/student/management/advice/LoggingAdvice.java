package com.student.management.advice;

import java.time.Duration;
import java.time.Instant;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Aspect
public class LoggingAdvice {
	
	Logger logger=LoggerFactory.getLogger(LoggingAdvice.class);
	
	@Around("execution(* com.student.management.*.*.*(..) )")
	public Object applicationLogger(ProceedingJoinPoint jointPoint) throws Throwable {
		ObjectMapper mapper=new ObjectMapper();
		String methodName=jointPoint.getSignature().getName();
		String className=jointPoint.getTarget().getClass().toString();
		Object[] argArray=jointPoint.getArgs();
		String argument=mapper.writeValueAsString(argArray);
		logger.info("Request for{}.{}() with arguement={}", className, methodName,argument);

		Instant start=Instant.now();
		Object responseObject=jointPoint.proceed();
		Instant end=Instant.now();
		Long timeElapsed=Duration.between(start, end).toMillis();
		
		String response=mapper.writeValueAsString(responseObject);
		logger.info("Response for{}.{}() with Result={}", className, methodName,response);
		logger.info("Time Taken ={} milli seconds",timeElapsed);
		
		return responseObject;
	}
	
	@Pointcut("within(com.student.management..*)")
	public void exceptionPackage() {
		//exception point cut
	}
	
	@AfterThrowing(pointcut = "exceptionPackage()", throwing = "exception")
	public void exceptionLogger(JoinPoint jointPoint,Throwable exception) {
		String name=jointPoint.getSignature().getDeclaringTypeName();
		String methodName=jointPoint.getSignature().getName();
		String message=exception.getMessage()!=null?exception.getMessage():null;
		
		logger.error("Exception in {}.{}() with message = {}",
				name,methodName,message);
	}
	
}
