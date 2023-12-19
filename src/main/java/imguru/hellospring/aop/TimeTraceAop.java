package imguru.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    // 적용 대상, 범위 설정
    @Around("execution(* imguru.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        System.out.println("START :: " + joinPoint.toString());

        try {
//            * Ctrl + Alt + Shift + T > inline variable
//            Object result = joinPoint.proceed();
//            return result;
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END :: " + joinPoint.toString() + " _ " + timeMs + "ms");
        }

    }

}
