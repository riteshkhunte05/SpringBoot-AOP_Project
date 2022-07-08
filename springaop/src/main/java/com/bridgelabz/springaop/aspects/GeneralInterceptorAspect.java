package com.bridgelabz.springaop.aspects;

import com.bridgelabz.springaop.model.Department;
import com.bridgelabz.springaop.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class GeneralInterceptorAspect {

    //@Pointcut("execution(*com.bridgelabz.springaop.controller.*.*(..))")
    //@Pointcut("within( com.bridgelabz.springaop..*)")
    //@Pointcut("this(com.bridgelabz.springaop.service.DepartmentService)")
    @Pointcut("@annotation(com.bridgelabz.springaop.annotation.CustomAnnotation)")
    public void loggingPointCut(){}

    /*@Before("loggingPointCut()")
    public void before( JoinPoint joinPoint ){
        log.info("Before method invoked::"+joinPoint.getSignature());
    }
    @AfterReturning(value = "execution(* com.bridgelabz.springaop.controller.*.*(..))",
            returning = "employee")
    public void after( JoinPoint joinPoint, Employee employee ){
        log.info("After method invoked::"+employee);
    }
    @AfterThrowing(value = "execution(* com.bridgelabz.springaop.controller.*.*(..))",
            throwing = "e")
    public void after( JoinPoint joinPoint, Exception e ){
        log.info("After method invoked::"+e.getMessage());
    }*/


    @Around("loggingPointCut()")
    public Object around( ProceedingJoinPoint joinPoint ) throws Throwable {
        log.info("Before method invoked::"+joinPoint.getArgs()[0]);
        Object object = joinPoint.proceed();

        if(object instanceof Employee){
            log.info("After method invoked..."+joinPoint.getArgs()[0]);
        }else if(object instanceof Department){
            log.info("After method invoked..."+joinPoint.getArgs()[0]);
        }

        return object;
    }

}