package com.ssg.webmvc.service;

import com.ssg.webmvc.dao.MemberDAO;
import com.ssg.webmvc.domain.MemberVO;
import com.ssg.webmvc.dto.MemberDTO;
import com.ssg.webmvc.util.MapperUtil;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public enum MemberService {
    INSTANCE;
    private MemberDAO memberDAO;
    private ModelMapper modelMapper;

    MemberService() {
        memberDAO = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.getModelMapper();
    }

    public List<MemberDTO> list() throws Exception {
        List<MemberVO> volist = memberDAO.listMembers();
        List<MemberDTO> dtoList = volist.stream()
                .map(vo -> modelMapper.map(vo, MemberDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }

    public int insert(MemberDTO dto) throws Exception {
        MemberVO vo = modelMapper.map(dto, MemberVO.class);

        int result = memberDAO.insert(vo);

        return result;
    }
   public MemberDTO select(String mid)throws Exception{
      MemberVO vo = memberDAO.select(mid);

       MemberDTO dto = modelMapper.map(vo,MemberDTO.class);

   return dto;}

    public int delete(MemberDTO dto) throws Exception {
        MemberVO vo = modelMapper.map(dto, MemberVO.class);
        int result = memberDAO.delete(vo);

        return result;
    }
    public int update(MemberDTO dto)throws Exception{
       int result = 0;
     result =    memberDAO.update(dto);
   return result; }

}