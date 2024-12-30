package com.membershipTracker.MembershipTracker.MemberAndAttendance.Services;

import com.membershipTracker.MembershipTracker.MemberAndAttendance.Command;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Controller.UpdateCommands.UpdateAttendanceCommand;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Attendance;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.DTO.AttendanceDTO;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Repository.AttendanceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PutAttendanceService implements Command<UpdateAttendanceCommand, AttendanceDTO> {
private AttendanceRepository attendanceRepository;

    public PutAttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public ResponseEntity<AttendanceDTO> execute(UpdateAttendanceCommand command) {
        try{
            Optional<Attendance> attendanceOptional = attendanceRepository.findById(command.getId());
            if(attendanceOptional.isPresent()){
                Attendance attendance = command.getAttendance();
                attendance.setId(command.getId());
                attendanceRepository.save(attendance);
                return ResponseEntity.ok(new AttendanceDTO(attendance));
            }
        }catch(Exception e){

        }
        return null;
    }
}
