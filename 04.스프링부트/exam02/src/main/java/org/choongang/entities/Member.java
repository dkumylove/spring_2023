package org.choongang.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.choongang.commons.MemberType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity  // 클래스를 엔티티로 선언, 변화감지의 데이터를 의미함
@Table(name = "USERS", indexes = @Index(name ="idx_member_createdAt", columnList = "createdAt DESC"))  // 엔티티와 매핑할 테이블을 지정
public class Member {

    @Id @GeneratedValue  // @Id : 테이블의 기본키에 사용할 속성을 지정, @GeneratedValue : 키 값을 생성하는 전략 명시(자동증감)
    private Long seq;
    private String email;
    private String name;
    private String password; // varchar2
    //@Lob //CLOB
    @Transient // 해당 필드 데이터베이스 매핑 무시, 엔티티 내부에서만 사용하기 위해 정의, 베제됨
    private String introduction;

    @Enumerated(EnumType.STRING)  //스트링으로 받아야함. 순서가 바뀌어도 상관없음
    private MemberType type;

    @CreationTimestamp  // insert SQL실행시
    private LocalDateTime createdAt;

    @UpdateTimestamp  // update SQL실행시
    private LocalDateTime modifiedAt;

    @Temporal()
    public Date dt;
}
