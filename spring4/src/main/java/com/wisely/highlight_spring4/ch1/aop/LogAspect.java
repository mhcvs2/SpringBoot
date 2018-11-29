package com.wisely.highlight_spring4.ch1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.beans.Expression;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.wisely.highlight_spring4.ch1.aop.Action)")
    public void annotationPointCut(){}

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截 " + action.name());
    }

    @Before("execution(* com.wisely.highlight_spring4.ch1.aop.DemoMethodService.*(..))")  //注意星号后边的空格
    public void before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截," + method.getName());
    }

    @Pointcut("@annotation(com.wisely.highlight_spring4.ch1.aop.Action2)")
    public void testaround(){}

    @Around("testaround()")
    public Object taround(ProceedingJoinPoint joinPoint){
        Object result = null;
        CodeSignature codeSignature = (CodeSignature)joinPoint.getStaticPart().getSignature();
        // 参数名
        String[] params = codeSignature.getParameterNames();
        System.out.println(Arrays.toString(params));
//        [a, b]

        // 参数类型
        Class[] types = codeSignature.getParameterTypes();
        System.out.println(Arrays.toString(types));
//        [class java.lang.String, int]

        // 参数值
        Object[] args = joinPoint.getArgs();
        System.out.println(Arrays.toString(args));
//        [haa, 222]

        // 获取注解
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        Action2 action = method.getAnnotation(Action2.class);
        System.out.println(action.value());
//        t1

        // 参数值生成key
        SimpleKey simpleKey = new SimpleKey(args);
        int key = simpleKey.hashCode();
        System.out.println(key);
//        3195671

        SimpleKey simpleKey1 = new SimpleKey("haa", 222);
        if (simpleKey.equals(simpleKey1)) {
            System.out.println("yes");
        }
//        yes

        //执行被切的方法
        try {
            result = joinPoint.proceed(args);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Pointcut("@annotation(com.wisely.highlight_spring4.ch1.aop.Action3)")
    public void testaround3(){}

    // https://blog.csdn.net/u012834750/article/details/79388294
    @Around("testaround3()")
    public Object taround3(ProceedingJoinPoint joinPoint){
        Object result = null;
        CodeSignature codeSignature = (CodeSignature)joinPoint.getStaticPart().getSignature();
        String[] params = codeSignature.getParameterNames();
        Object[] args = joinPoint.getArgs();
        Map<String,Object> map = new HashMap<String, Object>();
        if (params!=null) {
            for (int i=0;i<params.length;i++) {
                map.put(params[i], args[i]);
            }
        }


        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        Action3 action = method.getAnnotation(Action3.class);
        System.out.println(action.value());

        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext();
        for (Map.Entry entry: map.entrySet()) {
            context.setVariable((String)entry.getKey(), entry.getValue());
        }

        String key = parser.parseExpression(action.value()).getValue(context, String.class);
        System.out.println(key);

        try {
            result = joinPoint.proceed(args);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
