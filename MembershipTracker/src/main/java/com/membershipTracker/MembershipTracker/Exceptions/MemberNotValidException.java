package com.membershipTracker.MembershipTracker.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MemberNotValidException extends RuntimeException{
    public MemberNotValidException(String message){
        super(message);
    }
}
