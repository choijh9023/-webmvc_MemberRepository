package com.ssg.webmvc.filter;

// log4j2 라이브러리의 기능을 사용하기 위한 import

import lombok.extern.log4j.Log4j2;

// 웹 필터로 사용하기 위한 어노테이션 import
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebFilter(urlPatterns = {"/member/*"})
public class LoginCheckFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        // 로그 정보 출력
        log.info("login check filter....");

        // HTTPServletRequest와 HTTPServletResponse로 형변환
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // 현재 세션 가져오기
        HttpSession session = req.getSession();

        // 만약 세션에 "loginInfo" 속성이 없다면 로그인 페이지로 리다이렉트, 즉, loginPage로 이동
        if (session.getAttribute("loginInfo") == null) {
            resp.sendRedirect("/login");

            // 필터 체인을 중단하고 메서드를 종료
            return;
        }

        // 세션에 "loginInfo" 속성이 있으면 다음 필터로 체인을 전달
        chain.doFilter(request, response);
    }

}
