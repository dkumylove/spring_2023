package org.choongang.jpaex;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.entities.BoardData;
import org.choongang.entities.HashTag;
import org.choongang.repositories.BoardDataRepository;
import org.choongang.repositories.HashTagRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex08Test {

    @Autowired
    private BoardDataRepository boardDataRepository;

    @Autowired
    private HashTagRepository hashTagRepository;

    @PersistenceContext //주입 받을 필드, 메서드, 또는 생성자에 붙일 수 있다.
    private EntityManager em;
    // EntityManager : 영속성 컨텍스트와 관련된 작업을 수행
    // 영속성 안에 있으면 캐시를 사용하는 것과 같은 효고가 나타남
    // 장점도 있지만 단점도있음


    @BeforeEach
    void init() {
        List<HashTag> tags = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            HashTag tag = new HashTag();
            tag.setTag("태그" + i);
            tags.add(tag);
        }
        hashTagRepository.saveAllAndFlush(tags);

        List<BoardData> items = new ArrayList<>();
        for(int i = 1; i <= 5; i++){
            BoardData item = new BoardData();
            item.setSubject("제목" + i);
            item.setContent("내용" + i);
            item.setTags(tags);
            items.add(item);
        }
        boardDataRepository.saveAllAndFlush(items);
        em.clear();  // 영속성 비우기
    }

    @Test
    void test1() {
        BoardData item = boardDataRepository.findById(1L).orElse(null);
        List<HashTag> tags = item.getTags();
        System.out.println("tags = " + tags);
    }

    @Test
    void test2() {
        HashTag tag = hashTagRepository.findById("태그1").orElse(null);
        System.out.println("tag = " + tag);
        List<BoardData> items = tag.getItems();
        items.forEach(System.out::println);
    }
}
