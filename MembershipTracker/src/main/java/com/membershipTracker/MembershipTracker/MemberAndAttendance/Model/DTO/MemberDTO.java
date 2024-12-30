package com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.DTO;

import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Member;
import lombok.Data;

@Data
public class MemberDTO {
    private Integer id;
    private String name;

    public MemberDTO(Member member){
        this.id = member.getId();
        this.name = member.getName();
    }
}
