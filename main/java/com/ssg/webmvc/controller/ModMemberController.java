package com.ssg.webmvc.controller;

import com.ssg.webmvc.dto.MemberDTO;
import com.ssg.webmvc.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet(name="modMemberController",urlPatterns ="/member/modMember.do")
@Log4j2
public class ModMemberController extends HttpServlet {
    MemberService memberService = MemberService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ModMemberController doGet 실행 ");
       String mid = request.getParameter("mid");
        System.out.println(mid);
        try {
            MemberDTO dto =memberService.select(mid);

            request.setAttribute("dto",dto);
            log.info(dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //리퀘스트로 받아온 mid를 다시 jsp페이지를 요청할때 리퀘스트객체에 setAttribute해서 가져간다.


        request.getRequestDispatcher("/WEB-INF/member/modmember.jsp").forward(request,response);


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //mid는 안가져와진다.
        MemberDTO dto = MemberDTO.builder()
                .mid( request.getParameter("mid"))
                .mpw(request.getParameter("mpw"))
                .mname(request.getParameter("mname"))
                .email(request.getParameter("email")).build();
        try {
            memberService.update(dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(dto);

        response.sendRedirect("/member/listMembers.do");

    }
}
