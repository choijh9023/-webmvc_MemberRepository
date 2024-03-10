package com.ssg.webmvc.controller;

import com.ssg.webmvc.dto.MemberDTO;
import com.ssg.webmvc.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name="listmemberController", urlPatterns = "/member/listMembers.do")
@Log4j2
public class ListMemberController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("ListMemberController doGet 메소드 실행 ");
        try{
            List<MemberDTO> memberDTOList = memberService.list();

            request.setAttribute("memberDTOList",memberDTOList);
            request.getRequestDispatcher("/WEB-INF/member/listmembers.jsp").forward(request, response);
        }catch (Exception e){
            e.printStackTrace();

        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

}