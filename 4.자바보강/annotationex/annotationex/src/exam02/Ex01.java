package exam02;

import java.lang.annotation.Annotation;
import java.util.Arrays;

@MyAnno2(nums = {10, 20, 30, 40, 50})
public class Ex01 {
    public static void main(String[] args) {
        Class cls = Ex01.class;
        MyAnno2 anno =  (MyAnno2)cls.getAnnotation(MyAnno2.class);
        String value = anno.value();

        System.out.println("value : " + value);

        int[] nums = anno.nums();
        System.out.println(Arrays.toString(nums));
    }
}
