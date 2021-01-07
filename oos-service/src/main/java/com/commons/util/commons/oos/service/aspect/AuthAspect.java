package com.commons.util.commons.oos.service.aspect;

import com.commons.util.commons.base.annotation.Token;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author cxk
 * @date 2021/1/7 10:42
 */
@Slf4j
@Aspect
@Component
public class AuthAspect {
    //切入点表达式决定了用注解方式的方法切还是针对某个路径下的所有类和方法进行切，方法必须是返回void类型
    @Pointcut("@annotation(com.commons.util.commons.base.annotation.Token)")
    private void permissionCheckCut() {
    }

    ;

    //切入点表达式决定了用注解方式的方法切还是针对某个路径下的所有类和方法进行切，方法必须是返回void类型
    @Pointcut("execution(* com.commons.util.commons.oos.service.controller..*.*(..))")
    private void oosController() {
    }

    ;


    //定义了切面的处理逻辑。即方法上加了@PermissionCheck
    @Around(value = "oosController()&&permissionCheckCut()",argNames = "")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("==========进入AOP============================");
        //1.记录日志信息
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        String token = request.getHeader("token");
        Signature signature = pjp.getSignature();
        String className = pjp.getTarget().getClass().getSimpleName();
        String methodName = signature.getName();
        Object[] args = pjp.getArgs();
        log.info("className:{},methodName:{}", className, methodName, args);

        //2.角色权限校验
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        if (targetMethod.isAnnotationPresent(Token.class)) {
            //获取方法上注解中表明的权限
            Token permission = (Token) targetMethod.getAnnotation(Token.class);
            if (permission.value()) {
               if(!token.equals("101")){
                  new RuntimeException("token验证失败");
               }
            }

        }

        return pjp.proceed();
    }


}
