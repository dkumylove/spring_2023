package org.choongang.entities;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode  // ID 해시코드를 구할때 필수적임,
@AllArgsConstructor @NoArgsConstructor //맴버변수가 담긴 생성자와 기본생성자 둘다 필요
public class BoardViewId {

    private Long seq;
    private int uid;

}
