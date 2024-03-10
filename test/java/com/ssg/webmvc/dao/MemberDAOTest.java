package com.ssg.webmvc.dao;

import com.ssg.webmvc.domain.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@Log4j2
class MemberDAOTest {
    private MemberDAO memberDAO;
    @BeforeEach
    public void go()throws Exception{
        memberDAO = new MemberDAO();
    }

    @Test
    public void testlistMmebers()throws Exception{
       log.info(memberDAO.listMembers());

    }

    @Test
    public void testdelete()throws Exception{
        MemberVO vo = MemberVO.builder()
                .mid("정휘제").build();
        int result = memberDAO.delete(vo);
       log.info("삭제 테스트 결과는 ="+result);
    }
    @Test
    public void testselectone()throws Exception{
        String mid = "junghon";

        log.info(memberDAO.select(mid));
    }
}