package com.ea.miushop_cart.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	// Isolates/restricts WHERE @Logging can be applied
	@Pointcut("execution(* com.ea.miushop_cart.service..*(..))")
	public void applicationMethod() {
	}

	// Annotation
	@Pointcut("@annotation(com.ea.miushop_cart.aspect.annotation.Logging)")
	public void logging() {
	}

	// Point cut.
	@Before("logging() && applicationMethod()")

	public void logResource(JoinPoint joinPoint) {
		Logger log = Logger.getLogger("");
		log.info("   **********     TARGET CLASS : " + joinPoint.getSignature().getName() + "    **********");
		System.out.println();
		System.out.println("   **********     TARGET CLASS : " + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName() + "    **********");
	}

}
