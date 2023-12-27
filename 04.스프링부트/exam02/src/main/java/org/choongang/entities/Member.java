package org.choongang.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.choongang.commons.MemberType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity  // 클래스를 엔티티로 선언, 변화감지의 데이터를 의미함
//@Table(name = "USERS", indexes = @Index(name ="idx_member_createdAt", columnList = "createdAt DESC"))  // 엔티티와 매핑할 테이블을 지정
//@EntityListeners(AuditingEntityListener.class)  // 엔티티의 변화 감지 + 설정 활성화 필요
public class Member extends  Base {

    @Id @GeneratedValue  // @Id : 테이블의 기본키에 사용할 속성을 지정, @GeneratedValue : 키 값을 생성하는 전략 명시(자동증감)
    private Long seq;

    @Column(length = 80, unique = true, nullable = false)
    private String email;  // email을 아이디로 사용할것 : 중복되면 x

    @Column(length = 40, nullable = false)
    private String name;

    @Column(length = 65, nullable = false)
    private String password; // varchar2

    /* //@Lob //CLOB
    @Transient // 해당 필드 데이터베이스 매핑 무시, 엔티티 내부에서만 사용하기 위해 정의, 베제됨
    private String introduction; */

    @Enumerated(EnumType.STRING)  //스트링으로 받아야함. 순서가 바뀌어도 상관없음
    @Column(length = 10)
    private MemberType type;

    @ToString.Exclude
    @OneToMany(mappedBy ="member", fetch=FetchType.LAZY)
    private List<BoardData> items = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addressNo")
    private Address address;

    /*
    //@CreationTimestamp  // insert SQL실행시
    @CreatedDate
    private LocalDateTime createdAt;

    //@UpdateTimestamp  // update SQL실행시
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    //@Temporal(TemporalType.DATE)  // 날짜
    //@Temporal(TemporalType.TIME)  // 시간
    //@Temporal(TemporalType.TIMESTAMP)  // 날짜 + 시간
    //public Date dt; // 잘 사용하지 않음

     */
}
