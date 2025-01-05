package com.membershipTracker.MembershipTracker.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AttendanceNotFoundException extends RuntimeException{
    public AttendanceNotFoundException(){
        super(AttendanceErrorMessage.ATTENDANCE_NOT_FOUND.getMessage());
    }
}
