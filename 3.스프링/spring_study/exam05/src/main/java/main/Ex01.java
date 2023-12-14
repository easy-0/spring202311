package main;
import aopex.*;
import config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Calculator cal = ctx.getBean(Calculator.class); // proxy 객체
        long result = cal.factorial(10L);

        long result2 = cal.factorial(20L);
        long result3 = cal.factorial(10L);
        long result4 = cal.factorial(20L);

        System.out.printf("cal : %d%n", result);

        System.out.printf("cal : %d%n", result2);
        System.out.printf("cal : %d%n", result3);
        System.out.printf("cal : %d%n", result4);

        ctx.close();
    }
}
