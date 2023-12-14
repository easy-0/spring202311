package config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Aspect
@Order(2)
public class ProxyCalculator {
    /*
    @Pointcut("execution(* aopex..*(..))")
    public void publicTarget() {}

    @Around("publicTarget()")
    */
    // @Around("execution(* aopex..*(..))")    // 경로가 간단할 경우 Pointcut을 사용하지 않고 바로 경로 작성.
    @Around("config.CommonPointcut.publicTarget()") // Pointcut만 정의한 외부 클래스파일의 경로 입력.
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        /*Signature sig = joinPoint.getSignature();
        System.out.println(sig.toLongString());*/
        Object[] args = joinPoint.getArgs();
        System.out.println(Arrays.toString(args));

        long stime = System.nanoTime(); // 공통 기능
        try {
            Object result = joinPoint.proceed();    // 핵심 기능을 수행하는 메서드 proceed()

            return result;
        } finally {
            long etime = System.nanoTime(); // 공통 기능
            System.out.printf("걸린 시간 : %d%n", etime - stime);
        }
    }
}
