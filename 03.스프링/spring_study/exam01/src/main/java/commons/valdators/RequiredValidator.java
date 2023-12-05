package commons.valdators;

public interface RequiredValidator {

    default void checkRequired(String str, RuntimeException e) {
        // 필수항목 - null 또는 빈 공백문자 있다면
        if (str == null || str.isBlank()) {
            throw e;
        }
    }
}
