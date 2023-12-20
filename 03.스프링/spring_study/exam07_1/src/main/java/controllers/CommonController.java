package controllers;

import commons.CommonException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("controllers")  // 설정 안하면 전체범위
public class CommonController {
    @ExceptionHandler(Exception.class)
    public String errorHandler(Exception e, Model model) {

        // CommonException에 의한 객체인지 확인
        if(e instanceof CommonException){

        }

        // 콘솔 출력
        e.printStackTrace();

        // 사용자쪽에 보낼 메시지
        model.addAttribute("message", e.getMessage());

        return "error/common";
    }
}
