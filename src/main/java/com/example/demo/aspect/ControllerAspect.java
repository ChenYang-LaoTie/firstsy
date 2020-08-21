package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Description: ControllerAscrpt
 * @Author ChenYang
 * @Date 2020/8/17   6:40 下午
 */

@Aspect
@Component
public class ControllerAspect {
    private final static Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);

    /**
     * 关联在方法上的切点
     * 第一个*代表返回类型不限
     * 第二个*代表module下所有子包
     * 第三个*代表所有类
     * 第四个*代表所有方法
     * (..) 代表参数不限
     * Order 代表优先级，数字越小优先级越高
     */
    @Pointcut("execution(public * com.example.demo.modules.*.controller.*.*(..))")
    @Order(1)
    public void controllerPointCut() {
    }

    @Before(value = "com.example.demo.aspect.ControllerAspect.controllerPointCut()")
    public void beforeController(JoinPoint joinpoint) {
        LOGGER.debug("==== This is before controller ====");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        LOGGER.debug("请求来源" + request.getRemoteAddr());
        System.out.println("请求来源" + request.getRemoteAddr());
        LOGGER.debug("请求URL" + request.getRequestURI());
        System.out.println("请求URL" + request.getRequestURI());
        LOGGER.debug("请求方式" + request.getMethod());
        System.out.println("请求方式" + request.getMethod());
        LOGGER.debug("响应方法" + joinpoint.getSignature().getDeclaringTypeName() + "." + joinpoint.getSignature().getName());
        System.out.println("响应方法" + joinpoint.getSignature().getDeclaringTypeName() + "." + joinpoint.getSignature().getName());
        LOGGER.debug("请求参数" + joinpoint.getArgs());
        System.out.println("请求参数" + Arrays.toString(joinpoint.getArgs()));

    }

    @Around(value = "com.example.demo.aspect.ControllerAspect.controllerPointCut()")
    public Object aroundController(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOGGER.debug("==== This is around controller ==== ");
        return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
    }

    @After(value = "com.example.demo.aspect.ControllerAspect.controllerPointCut()")
    public void afterController() {

    }
}
