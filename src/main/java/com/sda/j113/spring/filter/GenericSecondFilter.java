package com.sda.j113.spring.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 08.10.2022
 */
@Slf4j
@Order(2)
@Component
public class GenericSecondFilter extends GenericFilter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        log.info(String.format("Request: %s / %s / %s %d", httpServletRequest.getRequestURI(), httpServletRequest.getRequestURL(), httpServletRequest.getPathInfo(), System.currentTimeMillis()));

//        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//        httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
