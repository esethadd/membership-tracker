package com.membershipTracker.MembershipTracker.MemberAndAttendance.Services;

import com.membershipTracker.MembershipTracker.Exceptions.AttendanceNotFoundException;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Attendance;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.DTO.AttendanceDTO;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Repository.AttendanceRepository;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetAttendanceService implements Query<Integer, AttendanceDTO> {

    private final AttendanceRepository attendanceRepository;

    public GetAttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public ResponseEntity<AttendanceDTO> execute(Integer input) {

            Optional<Attendance> attendanceOptional = attendanceRepository.findById(input);

            if (attendanceOptional.isPresent()) {
                return ResponseEntity.ok(new AttendanceDTO(attendanceOptional.get()));
            }

        throw new AttendanceNotFoundException();
    }
}
