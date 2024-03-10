package com.ssg.webmvc.dao;

import com.ssg.webmvc.domain.AdminVO;
import com.ssg.webmvc.domain.MemberVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO {

    public AdminVO getWithPassword(String mid, String mpw )throws Exception{
        String SQL = "SELECT * FROM ADMIN WHERE MID = ? AND MPW = ? ";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(SQL);
        pstmt.setString(1, mid);
        pstmt.setString(2, mpw);

        @Cleanup ResultSet rs = pstmt.executeQuery();
        rs.next();
        AdminVO adminVO = AdminVO.builder()
                .mid(rs.getString(1))
                .mpw(rs.getString(2)).build();
        return adminVO;
    }
}
