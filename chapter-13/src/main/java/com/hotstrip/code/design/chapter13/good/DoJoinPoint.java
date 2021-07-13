package com.hotstrip.code.design.chapter13.good;

import com.alibaba.fastjson.JSON;
import com.hotstrip.code.design.chapter13.good.annotation.DoDoor;
import com.hotstrip.code.design.chapter13.good.config.StarterService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * 切面处理白名单
 */
@Slf4j
@Component
@Aspect
public class DoJoinPoint {
    @Resource
    private StarterService starterService;

    @Pointcut("@annotation(com.hotstrip.code.design.chapter13.good.annotation.DoDoor)")
    public void aopPoint() {

    }

    @Around("aopPoint()")
    public Object doRouter(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 获取内容
        Method method = getMethod(proceedingJoinPoint);
        DoDoor doDoor = method.getAnnotation(DoDoor.class);
        // 获取字段值
        String keyValue = getFiledValue(doDoor.key(), proceedingJoinPoint.getArgs());
        log.info("itstack door handler method: {}, value: {}", method.getName(), keyValue);
        if (null == keyValue || "".equals(keyValue))
            return proceedingJoinPoint.proceed();
        // 配置内容
        String[] split = starterService.split(",");
        // 白名单过滤
        for (String str : split) {
            if (keyValue.equals(str)) {
                return proceedingJoinPoint.proceed();
            }
        }
        // 拦截
        return returnObject(doDoor, method);
    }

    /**
     * 拦截
     * @param doDoor
     * @param method
     * @return
     */
    private Object returnObject(DoDoor doDoor, Method method) throws IllegalAccessException, InstantiationException {
        Class<?> returnType = method.getReturnType();
        String returnJson = doDoor.returnJson();
        if ("".equals(returnJson)) {
            return returnType.newInstance();
        }
        return JSON.parse(returnJson);
    }

    /**
     * 获取属性值
     * @param filed
     * @param args
     * @return
     */
    private String getFiledValue(String filed, Object[] args) {
        String filedValue = null;
        for (Object arg : args) {
            try {
                if (null == filedValue || "".equals(filedValue)) {
                    filedValue = BeanUtils.getProperty(arg, filed);
                } else {
                    break;
                }
            } catch (Exception e) {
                if (args.length == 1) {
                    return args[0].toString();
                }
            }
        }
        return filedValue;
    }

    private Method getMethod(ProceedingJoinPoint proceedingJoinPoint) throws NoSuchMethodException {
        Signature signature = proceedingJoinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        return getClass(proceedingJoinPoint).getMethod(methodSignature.getName(),
                methodSignature.getParameterTypes());
    }

    private Class<? extends Object> getClass(ProceedingJoinPoint proceedingJoinPoint) {
        return proceedingJoinPoint.getClass();
    }
}
