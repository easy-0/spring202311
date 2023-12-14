package commons.exceptions;

public class BadRequestException extends RuntimeException{
    // runtime 이 포함된 exception 은 확인 시점에 차이가 있다. 실행 시점에 확인 == 유연한 예외, 예외가 발생하는 상황에도 실행
    //  >> 컴파일 -> 실행 -> 예외발생
    // 반면 Exception은 컴파일 시점에 예외를 확인 > 이상하면 > 컴파일x == 엄격한 예외, 형식(예외처리) 필수!
    /* 예외처리의 목적? 서비스 중단을 막기 위한 처리!! */
    public BadRequestException(String msg) {
        super(msg);
    }
}
