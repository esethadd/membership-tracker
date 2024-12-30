package com.membershipTracker.MembershipTracker.MemberAndAttendance.Controller.UpdateCommands;

import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Member;
import lombok.Getter;

@Getter
public class UpdateMemberCommand {
    private Integer id;
    private Member member;

    public UpdateMemberCommand(Integer id, Member member) {
        this.id = id;
        this.member = member;
    }
}
