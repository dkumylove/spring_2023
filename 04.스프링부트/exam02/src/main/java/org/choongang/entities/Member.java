package org.choongang.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity  // 클래스를 엔티티로 선언, 변화감지의 데이터를 의미함
@Table(name = "USERS", indexes = @Index(name ="idx_member_createdAt", columnList = "createdAt DESC"))  // 엔티티와 매핑할 테이블을 지정
public class Member {

    @Id @GeneratedValue  // @Id : 테이블의 기본키에 사용할 속성을 지정, @GeneratedValue : 키 값을 생성하는 전략 명시(자동증감)
    private Long seq;
    private String email;
    private String name;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
