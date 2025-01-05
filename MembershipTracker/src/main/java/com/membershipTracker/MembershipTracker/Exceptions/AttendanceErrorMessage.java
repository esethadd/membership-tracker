package com.membershipTracker.MembershipTracker.Exceptions;

import lombok.Getter;

public enum AttendanceErrorMessage {
    ATTENDANCE_NOT_FOUND("Attendance Record(s) Not Found");

    @Getter
    private final String message;

    AttendanceErrorMessage(String message){
        this.message = message;
    }
}
