package models.sub;

public class Message2 {
    /**
     * 외부에 제공받은 컴파일된 클래스로 가정...
     */
    public void init() {
        System.out.println("init()!!");
    }
    // 매개변수가 없어야 호출가능하다.
    public void close() {
        System.out.println("close()!!!");
    }

}
