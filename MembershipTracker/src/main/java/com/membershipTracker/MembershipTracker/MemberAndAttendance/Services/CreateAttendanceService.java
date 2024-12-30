package com.membershipTracker.MembershipTracker.MemberAndAttendance.Services;

import com.membershipTracker.MembershipTracker.MemberAndAttendance.Command;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Attendance;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.DTO.AttendanceDTO;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Repository.AttendanceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateAttendanceService implements Command<Attendance, AttendanceDTO> {

    private final AttendanceRepository attendanceRepository;

    public CreateAttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public ResponseEntity<AttendanceDTO> execute(Attendance attendance) {
        Attendance savedAttendance = attendanceRepository.save(attendance);
        return ResponseEntity.status(HttpStatus.CREATED).body(new AttendanceDTO(savedAttendance));
    }
}
