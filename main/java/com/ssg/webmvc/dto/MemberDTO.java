package com.ssg.webmvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private String mid;
    private String mpw;
    private String email;
    private String mname;
    private LocalDate signdate;

}
