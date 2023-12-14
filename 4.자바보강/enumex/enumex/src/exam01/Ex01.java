package exam01;
import static exam01.Transportation.*;

public class Ex01 {
    public static void main(String[] args) {
        // import 에 static 을 붙여 enum 상수를 편하게 부를 수 있다.
        Transportation bus = BUS;
        System.out.println(BUS == Transportation.BUS);
        System.out.printf("ordinal : %d name : %s%n",bus.ordinal(),bus.name());
    }
}
