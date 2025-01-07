package com.membershipTracker.MembershipTracker.Exceptions;


import lombok.Getter;

@Getter
public enum MemberErrorMessage {
    MEMBER_NOT_FOUND("Member Not Found"),
    NAME_REQUIRED("Name is required."),
    VALID_EMAIL_REQUIRED("Valid email is required.");

    private final String message;

    MemberErrorMessage(String message){
        this.message = message;
    }

}
