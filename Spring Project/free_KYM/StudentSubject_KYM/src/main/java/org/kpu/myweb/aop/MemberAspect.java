package org.kpu.myweb.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MemberAspect {
	
	private static Logger logger = LoggerFactory.getLogger(MemberAspect.class);
	
		/*
	   @Before("within(org.kpu.myweb..*)")
	   public void beforeMethod(JoinPoint jp) {
	        System.out.println("----------------------------------------------------------");
	        Signature sig = jp.getSignature();
	        System.out.println("[BeforeMethod] : [" + sig.getName() + "] 메소드 호출 예정");

	   }*/
	   /*
	    @After("within(org.kpu.myweb..*)")
	    public void afterMethod() {
	        System.out.println("----------------------------------------------------------");

	    }*/
	    
	    @AfterReturning(value = "within(org.kpu.myweb..*)", returning = "member")
	    public void afterReturningMethod(JoinPoint jp) {
	    	Signature sig = jp.getSignature();
	        System.out.println("		[" + sig.getName() + "] 메소드 호출 성공");
	        System.out.println("---------------------------------------------------------------");

	    }

	    
}
