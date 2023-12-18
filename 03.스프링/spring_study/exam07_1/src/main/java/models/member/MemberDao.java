package models.member;

import lombok.RequiredArgsConstructor;
import mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // 자동스켄대상이 되기 위한
@RequiredArgsConstructor  // 생성자메개변수 추가해, 의존성해결, @Autowired 추가x
public class MemberDao {

    //MemberMapper 구현
    private final MemberMapper mapper;

    public boolean register(Member member) {

        int affectedRows = mapper.register(member);

        return affectedRows > 0;
    }

    public boolean exist(String userId) {
        int cnt = mapper.exist(userId);

        return cnt > 0; // 1이상 - 이미 등록된 아이디
    }

    public Member get(String userId) {
        return mapper.get(userId);
    }
}