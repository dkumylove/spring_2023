package filters;

import jakarta.servlet.*;

import java.io.IOException;

public class FilterEx2 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("FilterEx2 - 요청전");

        // 다음 필터가 있는지 호출하는 메서드 : 꼭 필요함
        chain.doFilter(request,response);

        System.out.println("FilterEx2 - 응답후");
    }
}
