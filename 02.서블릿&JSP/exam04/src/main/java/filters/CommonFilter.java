package filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class CommonFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // 다음 필터가 있는지 호출하는 메서드 : 꼭 필요함
        // 상위클래스가 하위클래스에 값으로 들러갈떄는 타입을 확인해야함(출처가 명확하지 않기때문 : 형변환필요)
        chain.doFilter(new CommonRequestWrapper((HttpServletRequest) request), response);

        // 하위클래스HttpServletRequest 상위클래스request;
        //HttpServletRequest req = (HttpServletRequest)request;


    }
}
