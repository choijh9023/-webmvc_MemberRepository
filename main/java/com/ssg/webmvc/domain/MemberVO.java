package com.ssg.webmvc.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {

    private String mid;
    private String mpw;
    private String email;
    private String mname;
    private LocalDate signdate;

}
