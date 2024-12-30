package com.membershipTracker.MembershipTracker.MemberAndAttendance.Controller.UpdateCommands;

import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Attendance;
import lombok.Getter;

@Getter
public class UpdateAttendanceCommand {
    private Integer id;
    private Attendance attendance;

    public UpdateAttendanceCommand(Integer id, Attendance attendance) {
        this.id = id;
        this.attendance = attendance;
    }
}
