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
    @Column(updatable = false)
    private LocalDateTime createdAt;

    //@UpdateTimestamp  // update SQL실행시
    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime modifiedAt;
}
