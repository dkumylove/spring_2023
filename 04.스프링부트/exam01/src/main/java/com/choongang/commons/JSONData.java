package com.choongang.commons;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor // 기본생성자
@RequiredArgsConstructor  // 초기화 필요한 상수 같은 것을 위한 생성자를 추가함
public class JSONData<T> {
    private boolean success = true; // 성공하는 경우가 더 많기 떄문에 true로 고정
    private HttpStatus status = HttpStatus.OK;  // 응답 상태 코드, 가장많은것이 200으로 고정

    @NonNull
    private T data;  // 성공시 body 데이터
    private String message;  // 실패시 메시지

}
