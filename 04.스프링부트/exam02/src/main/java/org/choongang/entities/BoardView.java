package org.choongang.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

@Data
@Entity
@IdClass(BoardViewId.class)
public class BoardView {
    @Id
    private Long seq;

    @Id
    @Column(name="_uid")
    private int uid; // uid 오라클에서 예약어임


}
