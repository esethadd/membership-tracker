package com.membershipTracker.MembershipTracker.MemberAndAttendance.Controller;

import com.membershipTracker.MembershipTracker.MemberAndAttendance.Controller.UpdateCommands.UpdateAttendanceCommand;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Attendance;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.DTO.AttendanceDTO;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//Listens for Request
@RequestMapping
public class AttendanceController {
    //Constructor Injection
    //Services for "Business Logic" Abstraction


    private final CreateAttendanceService createAttendanceService;

    private final GetAttendancesService getAttendancesService;

    private final PutAttendanceService putAttendanceService;

    private final DeleteAttendanceService deleteAttendanceService;

    private final GetAttendanceService getAttendanceService;
    public AttendanceController(CreateAttendanceService createAttendanceService,
                                GetAttendancesService getAttendancesService,//All Attendances
                                GetAttendanceService getAttendanceService,//Attendance by ID
                                PutAttendanceService putAttendanceService,
                                DeleteAttendanceService deleteAttendanceService) {
        this.createAttendanceService = createAttendanceService;
        this.getAttendancesService = getAttendancesService;//All Attendances
        this.getAttendanceService = getAttendanceService;//Attendance by ID
        this.putAttendanceService = putAttendanceService;
        this.deleteAttendanceService = deleteAttendanceService;
    }
    //Dependency Injection to Inject the "Service" Classes
    //Field Injection can be implemented via @Autowired

    //Change later to only allow users to "Read" their attendances
    @PostMapping("/member/attendance")
    public ResponseEntity<AttendanceDTO> createAttendance(@RequestBody Attendance attendance){
        return createAttendanceService.execute(attendance);
    }
    //Get all
    @GetMapping("/member/attendances")
    public ResponseEntity<List<AttendanceDTO>> getAttendances(){
        return getAttendancesService.execute(null);
    }

    //Find by ID
    @GetMapping("/member/attendance/{id}")
    public ResponseEntity<AttendanceDTO> getAttendanceById(@PathVariable Integer id){
        return getAttendanceService.execute(id);
    }
    @PutMapping("/member/attendance/{id}")
    public ResponseEntity<AttendanceDTO> updateAttendance(@PathVariable Integer id, @RequestBody Attendance attendance){
        return putAttendanceService.execute(new UpdateAttendanceCommand(id, attendance));
    }
    @DeleteMapping("/member/attendance/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Integer id){
        return deleteAttendanceService.execute(id);
    }

}
