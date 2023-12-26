package org.choongang.repositories;

import org.choongang.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CrudRepository와 같은 기능 + flush():DB반영 기능 가능
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
}
