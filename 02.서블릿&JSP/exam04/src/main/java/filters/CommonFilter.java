package filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class CommonFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // 다음 필더가 있는지 확인하는 메서드 : 꼭 필요함
        chain.doFilter(new CommonRequestWrapper((HttpServletRequest) request), response);

    }
}
