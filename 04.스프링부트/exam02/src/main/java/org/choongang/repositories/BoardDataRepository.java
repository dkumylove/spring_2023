package org.choongang.repositories;

import org.choongang.entities.BoardData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardDataRepository extends JpaRepository<BoardData, Long> {
}
