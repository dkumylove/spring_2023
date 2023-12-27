package org.choongang.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@Entity
public class BoardData extends Base{

    @Id @GeneratedValue  // @Id : 테이블의 기본키에 사용할 속성을 지정, @GeneratedValue : 키 값을 생성하는 전략 명시(자동증감)
    private Long seq;

    @Column(length = 100, nullable = false)
    private String subject;

    @Lob
    @Column(nullable = false)
    private String content;

    /*
    @CreatedDate
    @Column(updatable = false)  // 추가o, 수정x
    private LocalDateTime createdAt;  // 처음에 값이 등록되고 이후에 변경되면 x
    @LastModifiedDate
    @Column(insertable = false)  // 추가x, 수정o
    private LocalDateTime modifiedAt;  // 처음등록대는 등록되면 x, 이후 수정할 때 가능
     */

    @ManyToOne
    @JoinColumn(name = "userNo")
    private Member member;
}
