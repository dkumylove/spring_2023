package main;

import models.member.*;

import java.time.LocalDateTime;

public class Ex06 {
    public static void main(String[] args) {
//        MemberDao memberDao = new MemberDao();
//        JoinValidator joinValidator = new JoinValidator(memberDao);
//        JoinService joinService = new JoinService(memberDao, joinValidator);
//
//        ListService listService = new ListService();
//        listService.setMemberDao(memberDao);

        JoinService joinService = ServiceManager.getInstance().joinService();
        ListService listService = ServiceManager.getInstance().listService();

        // 가입자 정보
        Member member = new Member();
        member.setUserId("user01");
        member.setUserPw("123456");
        member.setConfirmPw("123456");
        member.setUserNm("사용자01");
        member.setRegDt(LocalDateTime.now());

        // 가입
        joinService.join(member);

        // 목록출력
        listService.print();
    }
}
