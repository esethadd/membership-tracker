package com.membershipTracker.MembershipTracker.Exceptions;


import lombok.Getter;

@Getter
public enum MemberErrorMessage {
    MEMBER_NOT_FOUND("Member Not Found");

    private final String message;

    MemberErrorMessage(String message){
        this.message = message;
    }

}
