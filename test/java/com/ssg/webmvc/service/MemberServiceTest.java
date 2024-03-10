package com.ssg.webmvc.service;

import com.ssg.webmvc.dto.MemberDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@Log4j2
class MemberServiceTest {
    MemberService memberService = MemberService.INSTANCE;

    @Test
    public void testlist()throws Exception{
      log.info(memberService.list());
    }

    @Test
    public void testdelete()throws Exception{
        MemberDTO dto = MemberDTO.builder()
                .mid("hosang").build();
        int result = memberService.delete(dto);
        if(result==1)log.info("delete 테스트 성공 ");

    }
    @Test
    public void testselect()throws Exception{
        String mid = "junghon";
        MemberDTO dto = memberService.select(mid);
        log.info(dto);
    }
}