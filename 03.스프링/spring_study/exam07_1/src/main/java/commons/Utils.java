package commons;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import models.member.Member;
import org.springframework.beans.factory.annotation.Autowired;

public class Utils {

    @Autowired
    private HttpSession session;

    // 회원정보가있다 로그인상테
    public boolean isLogin() {
        return getMember() != null;
    }

    // 회원정보를 세션에tj 조회
    public Member getMember() {
        Member member = (Member)session.getAttribute("member");
        return member;
    }

//    public String toUpper(String str) {
//        //return str.toLowerCase();
//    }
}
