package models.member;

import java.util.List;

public class ListService {

    private MemberDao memberDao;

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
