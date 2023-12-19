package configs;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.member.Member;
import org.springframework.web.servlet.HandlerInterceptor;

public class MemberOnlyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();

        Member member = (Member)session.getAttribute("member");

        // 로그인 상태확인
        if(member != null) {  // 로그인상태
            return true;
        }

        // 비회원 -> 로그인페이지로 이동
        String url = request.getContextPath() + "/member/login";
        response.sendRedirect(url);

        // 로그인상태 아니면
        return false;
    }
}
