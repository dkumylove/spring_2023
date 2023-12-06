package models.member;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ListService {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    // setter를 통한 주입
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
