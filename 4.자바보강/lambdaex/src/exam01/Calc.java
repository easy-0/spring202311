package exam01;

@FunctionalInterface
public interface Calc {
    int square(int num);
    /*
    // 하나의 기능만 구현해야한다, @FunctionalInterface로 제한
    int root(int num);
    */

}
