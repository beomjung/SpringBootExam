package kopo.poly.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Aspect
public class TimeTraceAop {

    @Around("execution(* kopo.poly..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
       long start = System.currentTimeMillis();
        System.out.println("start : " + joinPoint.toString());
       try {
          return joinPoint.proceed();
       }finally {
           long finish = System.currentTimeMillis();
           long timeMs = finish - start;
           System.out.println("END : "+ joinPoint.toString() + " " + timeMs + "ms");
       }
    }
}
