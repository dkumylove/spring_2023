package models.member;

import config.ManualBean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@ManualBean
@Repository
public class MemberDao { // 빈이름 memberDao
    private static Map<String, Member> members = new HashMap<>();

   // 회원가입
   public void register(Member member) {
       members.put(member.getUserId(), member);
   }

   // 아이디의 존재여부 체크
   public boolean exists(String userId) {
       return members.containsKey(userId);
   }

    // 저장된 회원목록 가져오기
    public List<Member> getList(){
       return new ArrayList<>(members.values());
    }
}
