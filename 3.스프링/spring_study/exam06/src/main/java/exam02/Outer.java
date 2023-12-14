package exam02;

public class Outer {

    Calculator method(int num3){
        return new Calculator(){
            public int add(int num1, int num2){
                /* 함수(메서드) 내에 정의된 지역변수
                    호출돼서 실행할때 자원 할당
                    연산 후 자원 해제

                    지역변수는 스택영역에 저장돼 제거돼야하지만,
                    지역 내부에서 정의된 클래스의 메서드에서 사용중이면
                    지역변수를 상수화 하여 유지 값을 유지한다.
                 */
                return num1 + num2 + num3;
            }
        };
    }

    /*void method(){
        // 지역 내부 클래스 : 인터페이스, 추상클래스가 객체가 되는 조건
        //  환경 조건 : 지역 내부, 멤버 변수 // (실행 과정 중)
        //  조건2 : 미 구현된 추상 메서드의 구현 내용을 추가함으로써
        class Inner{
            void innerMethod(){
                System.out.println("지역 내부 클래스");
            }
        }
        Inner in = new Inner();
        in.innerMethod();
    }*/
}
