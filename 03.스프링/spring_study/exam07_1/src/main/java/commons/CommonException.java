package commons;

import org.springframework.http.HttpStatus;

public class CommonException extends RuntimeException {

    private HttpStatus status;

    // 기본 500에러
    public CommonException(String message) {
        this(message,  HttpStatus.INTERNAL_SERVER_ERROR); // 500
    }

    // 직접 응답코드를 만들기 위한
    public CommonException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
