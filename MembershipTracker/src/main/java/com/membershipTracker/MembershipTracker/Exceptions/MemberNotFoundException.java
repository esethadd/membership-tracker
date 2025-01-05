package com.membershipTracker.MembershipTracker.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MemberNotFoundException extends RuntimeException{
    public MemberNotFoundException(){
        super(MemberErrorMessage.MEMBER_NOT_FOUND.getMessage());
    }
}
