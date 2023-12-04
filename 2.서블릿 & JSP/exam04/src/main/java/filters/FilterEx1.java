package filters;

import jakarta.servlet.*;

import java.io.IOException;

public class FilterEx1 implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filterEx1!! - 요청 전");
        chain.doFilter(request, response);
        System.out.println("filterEx1 - 응답 후");
    }
}
