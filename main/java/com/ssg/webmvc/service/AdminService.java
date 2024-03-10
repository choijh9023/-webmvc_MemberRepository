package com.ssg.webmvc.service;

import com.ssg.webmvc.dao.AdminDAO;
import com.ssg.webmvc.domain.AdminVO;
import com.ssg.webmvc.dto.AdminDTO;
import com.ssg.webmvc.util.MapperUtil;
import org.modelmapper.ModelMapper;

public enum AdminService {
    INSTANCE;
    private AdminDAO adminDAO;

    private ModelMapper modelMapper;

    AdminService() {
        adminDAO = new AdminDAO();
        modelMapper = MapperUtil.INSTANCE.getModelMapper();
    }

    public AdminDTO login(String mid, String mpw) throws Exception {
        AdminVO vo = adminDAO.getWithPassword(mid, mpw);
        AdminDTO adminDTO = modelMapper.map(vo, AdminDTO.class);


        return adminDTO;
    }
}
