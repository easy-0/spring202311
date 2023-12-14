package commons.validators;

import org.springframework.util.StringUtils;

public interface RequiredValidator {
    // default method
    default void checkRequired(String str, RuntimeException e){
        // StringUtils.hasText() : null, 공백 체크 / 스프링 제공 유틸
        if (!StringUtils.hasText(str)){
            throw e;
        }
    }

    // 참이 아닐때 예외 발생
    default void checkTrue(boolean result, RuntimeException e){
        if (!result) {
            throw e;
        }
    }

    // 참 일때 예외 발생
    default void checkFalse(boolean result, RuntimeException e){
        if (result) {
            throw e;
        }
    }
}
