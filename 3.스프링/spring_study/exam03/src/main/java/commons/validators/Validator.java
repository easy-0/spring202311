package commons.validators;

public interface Validator<T> {
    // 예전 방식은 object, 요즘은 generics
    void validate(T value);
}
