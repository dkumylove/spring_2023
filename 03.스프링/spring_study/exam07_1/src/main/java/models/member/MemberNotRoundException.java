package models.member;

import commons.CommonException;
import org.springframework.http.HttpStatus;

public class MemberNotRoundException extends CommonException {

    public MemberNotRoundException() {
        super("등록되지 않은 회원입니다.", HttpStatus.NOT_FOUND); // 404
    }
}
