package org.choongang.repositories;

import org.choongang.entities.BoardData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardDataRepository extends JpaRepository<BoardData, Long>, QuerydslPredicateExecutor<BoardData> {

    @EntityGraph(attributePaths = {"member"}) // 직접 명시해서 즉시로딩
    List<BoardData> findBySubjectContaining(String keyword);

    // page 관련 포함되어있음
    Page<BoardData> findBySubjectContaining(String keyword, Pageable pageable);

    List<BoardData> findBySubjectContainingOrderBySeqDesc(String keyword);

    @Query("SELECT b FROM BoardData b LEFT JOIN FETCH b.member WHERE b.subject LIKE %:key% ORDER BY b.seq DESC")
    List<BoardData> getSubjects(@Param("key") String keyword);

    @Query("SELECT b FROM BoardData b WHERE b.subject LIKE %:key%")
    Page<BoardData> getSubjects(@Param("key") String keyword, Pageable pageable);

}
