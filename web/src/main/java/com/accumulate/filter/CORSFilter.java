package com.accumulate.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 解决ajax跨域问题。需要的地方在web.xml中配置。
 * Created by tjwang on 2016/9/12.
 */
public class CORSFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (response instanceof HttpServletResponse) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            // CQRS
            httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
