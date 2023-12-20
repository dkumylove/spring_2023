package controllers;

import commons.CommonException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("controllers")  // 설정 안하면 전체범위
public class CommonController {
    @ExceptionHandler(Exception.class)
    public String errorHandler(Exception e, Model model, HttpServletResponse response) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500

        // CommonException에 의한 객체인지 확인
        if(e instanceof CommonException){
            CommonException commonException = (CommonException)e;
            status = commonException.getStatus();  // 응답코드 가져옴
        }

        // 가져온 응답코드 고정
        response.setStatus(status.value());

        // 콘솔 출력
        e.printStackTrace();

        // 사용자쪽에 보낼 메시지
        model.addAttribute("message", e.getMessage());

        return "error/common";
    }
}
