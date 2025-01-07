package com.membershipTracker.MembershipTracker.MemberAndAttendance.Model;

import lombok.Getter;

@Getter
public class ErrorResponse {
    public String message;

    public ErrorResponse(String message){
        this.message = message;
    }
}
