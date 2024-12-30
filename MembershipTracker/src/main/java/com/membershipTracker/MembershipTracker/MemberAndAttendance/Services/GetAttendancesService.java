package com.membershipTracker.MembershipTracker.MemberAndAttendance.Services;

import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Attendance;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.DTO.AttendanceDTO;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Repository.AttendanceRepository;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAttendancesService implements Query<Void,List<AttendanceDTO>> {
    private final AttendanceRepository attendanceRepository;

    public GetAttendancesService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public ResponseEntity<List<AttendanceDTO>> execute(Void input) {
        List<Attendance> attendances = attendanceRepository.findAll();
        List<AttendanceDTO> attendanceDTOS = attendances.stream().map(AttendanceDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(attendanceDTOS);
    }
}
