package com.choongang.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

@Data @Builder  // @Builder 기본생성자 private 범위
@NoArgsConstructor @AllArgsConstructor // 편법 : 기본생성자 사용가능
public class Member {
    // USER_NO -> userNo 사용
    @Id // PrimaryKey : 기본키로 사용됨
    private Long userNo;
    private String userId;
    @JsonIgnore // 변환 배제
    private String userPw;
    private String userNm;
    private String email;

    @JsonFormat(pattern = "yyyy.MM.dd HH:mm")
    private LocalDateTime regDt;
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm")
    private LocalDateTime modDt;

}
