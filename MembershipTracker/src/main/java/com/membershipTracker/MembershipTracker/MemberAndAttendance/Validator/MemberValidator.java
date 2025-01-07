package com.membershipTracker.MembershipTracker.MemberAndAttendance.Validator;

import com.membershipTracker.MembershipTracker.Exceptions.MemberErrorMessage;
import com.membershipTracker.MembershipTracker.Exceptions.MemberNotValidException;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Member;
import io.micrometer.common.util.StringUtils;

public class MemberValidator {
    private MemberValidator(){

    }

    public static void execute(Member member){
        if(StringUtils.isEmpty(member.getName())){
            throw new MemberNotValidException(MemberErrorMessage.NAME_REQUIRED.getMessage());
        }

        if(!member.getEmail().contains("@") || !member.getEmail().contains("students.kennesaw.edu")){
            throw new MemberNotValidException(MemberErrorMessage.VALID_EMAIL_REQUIRED.getMessage());
        }
    }

}
