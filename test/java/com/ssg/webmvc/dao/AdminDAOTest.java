package com.ssg.webmvc.dao;

import com.ssg.webmvc.domain.AdminVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@Log4j2

class AdminDAOTest {
    private AdminDAO adminDAO;
@BeforeEach
public void go()throws Exception{
    adminDAO = new AdminDAO();
}

@Test
    public void login()throws Exception{
    AdminVO test = adminDAO.getWithPassword("9023","9023");
    log.info(test);
}
}