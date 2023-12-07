package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {

    // 바로주입
    private MemberDao memberDao;

    // setter를 통한 주입 / 호출될떄 주입
    @Autowired
    public void setMemberDao(MemberDao memberDao){
        this.memberDao = memberDao;
    }

    public void print(){
        List<Member> members = memberDao.getList();
        for (Member member : members){
            System.out.println(member);
        }
    }
}
