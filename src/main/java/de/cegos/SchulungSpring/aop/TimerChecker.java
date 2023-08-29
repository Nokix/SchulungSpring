package de.cegos.SchulungSpring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimerChecker {

    @Around("@annotation(TimeMe)")
    public Object timer(ProceedingJoinPoint jp) throws Throwable {
        long start = System.nanoTime();
        Object result = jp.proceed();
        long end = System.nanoTime();
        System.out.println(jp.getSignature() + " took " + (end-start) + " ns.");
        return result;
    }

}
