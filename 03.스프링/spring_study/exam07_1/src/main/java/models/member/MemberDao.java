package models.member;

import controllers.admin.MemberSearch;
import lombok.RequiredArgsConstructor;
import mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository // 자동스켄대상이 되기 위한
@RequiredArgsConstructor  // 생성자메개변수 추가해, 의존성해결, @Autowired 추가x
public class MemberDao {

    //MemberMapper 구현
    private final MemberMapper mapper;

    // 회원가입
    public boolean register(Member member) {

        int affectedRows = mapper.register(member);

        return affectedRows > 0;
    }

    // 아이디 중복 검사
    public boolean exist(String userId) {
        int cnt = mapper.exist(userId);

        return cnt > 0; // 1이상 - 이미 등록된 아이디
    }

    // 회원조회
    public Member get(String userId) {
        return mapper.get(userId);
    }

    // 회원정보조회(리스트로출력)
    public  List<Member> getList(MemberSearch search){
        LocalDate edate = search.getEdate();
        if(edate != null) {
            LocalDate newEdate = edate.plusDays(1);
            search.setEdate(newEdate);
        }
        return mapper.getList(search);
    }
}