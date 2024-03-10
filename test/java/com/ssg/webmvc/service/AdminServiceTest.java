package com.ssg.webmvc.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@Log4j2
class AdminServiceTest {
 AdminService adminService = AdminService.INSTANCE;
 @Test
    public void testlogin()throws Exception{
     log.info(adminService.login("9023","9023"));

 }
}