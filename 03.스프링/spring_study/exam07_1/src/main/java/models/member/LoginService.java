package models.member;

import controllers.member.RequestLogin;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    // 의존지입을 위한 선언
    private final MemberDao memberDao;
    private final HttpSession session;

    public void login(RequestLogin form) {
        /**
         * 1. 아이디로 회원조회
         * 2. 세션에 회원정보 유지
         */

        String userId = form.userId();

        // 1. 아이디로 회원조회
        Member member = memberDao.get(userId);

        // 2. 세션에 회원정보 유지
        session.setAttribute("member", member);

    }
}
