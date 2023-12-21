package com.choongang.repositories;

import com.choongang.entities.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends CrudRepository<Member, Long> {
    // 조회
    Member findByUserId(String uesrId);

    // Containing : Like OrderByRegDtDesc : 정렬조건
    // 단점 : 복잡한 쿼리는 어려움
    List<Member> findByUserNmContainingOrUserIdContainingOrderByRegDtDesc(String keyword1, String keyword2);

    // 쿼리문 직접 입력
    @Query("SELECT * FROM MEMBER WHERE USER_NM LIKE '%:key1%' OR USER_ID LIKE '%key2%' ORDER BY REG_DT DESC")
    List<Member> getMembers(@Param("key1") String keyword1, @Param("key2") String keyword2);

    Page<Member> findByUserNmContaining(String key, Pageable pageable);
}
