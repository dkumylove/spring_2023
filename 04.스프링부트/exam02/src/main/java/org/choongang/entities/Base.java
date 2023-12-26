package org.choongang.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter @Setter
@MappedSuperclass // 공통 속성화를 위한 상위 클래스임을 알려줘야 인식함
@EntityListeners(AuditingEntityListener.class) // 엔티티의 변화 감지 + 설정 활성화 필요
public abstract class Base {

    //@CreationTimestamp  // insert SQL실행시
    @CreatedDate
    @Column(updatable = false)  // 추가o, 수정x
    private LocalDateTime createdAt;  // 처음에 값이 등록되고 이후에 변경되면 x

    //@UpdateTimestamp  // update SQL실행시
    @LastModifiedDate
    @Column(insertable = false)  // 추가x, 수정o
    private LocalDateTime modifiedAt;  // 처음등록대는 등록되면 x, 이후 수정할 때 가능
}
