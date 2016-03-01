package org.bobbyjam99.web.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * 1番目に呼ばれる ServletFilter.<br/>
 * 複数のFilterを設定する際にはOrderで設定可能
 */
@Component
@Order(1)
public class FirstCallFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("*** 1. FIRST CALL FILTER START ***");
        chain.doFilter(request, response);
        System.out.println("*** 4. FIRST CALL FILTER END ***");
    }

    @Override
    public void destroy() {

    }
}
