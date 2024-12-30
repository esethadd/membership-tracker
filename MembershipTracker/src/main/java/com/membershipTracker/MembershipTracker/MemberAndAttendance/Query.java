package com.membershipTracker.MembershipTracker.MemberAndAttendance;

import org.springframework.http.ResponseEntity;
//Only used for the Get Requests
public interface Query <I,O>{//I is defined as input, O is output
    ResponseEntity<O> execute(I input);
}
