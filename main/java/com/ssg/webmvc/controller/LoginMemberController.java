package com.ssg.webmvc.controller;

import com.ssg.webmvc.dto.AdminDTO;
import com.ssg.webmvc.service.AdminService;
import com.ssg.webmvc.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@Log4j2
@WebServlet(name="loginMemberController",urlPatterns = "/login")
public class LoginMemberController extends HttpServlet {
    MemberService memberService = MemberService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      log.info("로그인을 해볼까나 ");
       request.getRequestDispatcher("/WEB-INF/member/Loginmember.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mid = request.getParameter("mid");
        String mpw = request.getParameter("mpw");
        try {
            AdminDTO dto = AdminService.INSTANCE.login(mid, mpw);
            HttpSession session = request.getSession();
            session.setAttribute("loginInfo",dto);
            response.sendRedirect("/member/listMembers.do");

        } catch (Exception e) {
            response.sendRedirect("/login?result=error");
        }

    }
}
