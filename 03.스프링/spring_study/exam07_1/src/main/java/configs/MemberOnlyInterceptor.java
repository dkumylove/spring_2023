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
        // 응답코드 추가 SC_UNAUTHORIZED : 401
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        String url = request.getContextPath() + "/member/login";
        // getContextPath() : 루트경로에 붙어있는 /exam07 : 이걸 사용하는 이유, 바뀔수도 있기 때문에 주소로 호툴하는 것임
        response.sendRedirect(url);

        // 로그인상태 아니면
        return false;
    }
}
