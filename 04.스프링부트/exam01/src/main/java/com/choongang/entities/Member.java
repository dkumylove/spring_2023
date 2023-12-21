package com.choongang.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data @Builder  // @Builder 기본생성자 private 범위
@NoArgsConstructor @AllArgsConstructor // 편법 : 기본생성자 사용가능
public class Member {
    // USER_NO -> userNo 사용
    @Id // PrimaryKey : 기본키로 사용됨
    private Long userNo;
    private String userId;
    private String userPw;
    private String userNm;
    private String email;
    private LocalDateTime regDt;
    private LocalDateTime modDt;

}
