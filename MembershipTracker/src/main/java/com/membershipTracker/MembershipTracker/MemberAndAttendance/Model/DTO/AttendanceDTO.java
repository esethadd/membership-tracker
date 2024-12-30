package com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.DTO;

import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Attendance;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Member;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AttendanceDTO {
    private Integer id;
    private LocalDate event_date;
    private Member member;

    public AttendanceDTO(Attendance attendance){
        this.id = attendance.getId();
        this.event_date = attendance.getEventDate();
        this.member = attendance.getMembers();
    }
}
