package com.membershipTracker.MembershipTracker.MemberAndAttendance.Services;

import com.membershipTracker.MembershipTracker.Exceptions.AttendanceNotFoundException;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Command;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Attendance;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Repository.AttendanceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteAttendanceService implements Command<Integer,Void> {

    private final AttendanceRepository attendanceRepository;

    public DeleteAttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer id) {
            Optional<Attendance> attendanceOptional = attendanceRepository.findById(id);
            if(attendanceOptional.isPresent()){
                attendanceRepository.deleteById(id);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }


        throw new AttendanceNotFoundException();
    }
}
