package com.membershipTracker.MembershipTracker.Exceptions;


import lombok.Getter;

public enum MemberErrorMessage {
    MEMBER_NOT_FOUND("Member Not Found");

    @Getter
    private final String message;

    MemberErrorMessage(String message){
        this.message = message;
    }

}
