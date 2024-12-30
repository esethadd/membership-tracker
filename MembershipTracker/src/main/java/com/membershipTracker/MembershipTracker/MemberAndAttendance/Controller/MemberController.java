package com.membershipTracker.MembershipTracker.MemberAndAttendance.Controller;

import com.membershipTracker.MembershipTracker.MemberAndAttendance.Controller.UpdateCommands.UpdateMemberCommand;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.DTO.MemberDTO;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Member;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MemberController {
    private final CreateMemberService createMemberService;
    private final GetMembersService getMembersService;
    private final GetMemberService getMemberService;
    private final PutMemberService putMemberService;
    private final DeleteMemberService deleteMemberService;

    public MemberController(CreateMemberService createMemberService,
                            GetMembersService getMembersService,
                            PutMemberService putMemberService,
                            DeleteMemberService deleteMemberService,
                            GetMemberService getMemberService) {
        this.createMemberService = createMemberService;
        this.getMembersService = getMembersService;//Get All
        this.getMemberService = getMemberService;//Get by ID
        this.putMemberService = putMemberService;
        this.deleteMemberService = deleteMemberService;
    }

    @PostMapping("/member")
    public ResponseEntity<MemberDTO> createMember(@RequestBody Member member){
        return createMemberService.execute(member);
    }
    //Get All
    @GetMapping("/members")
    public ResponseEntity<List<MemberDTO>> getMembers(){
        return getMembersService.execute(null);
    }

    //Find by ID
    @GetMapping("/member/{id}")
    public ResponseEntity<MemberDTO> getMemberById(@PathVariable Integer id){
        return getMemberService.execute(id);
    }
    @PutMapping("/member/{id}")
    public ResponseEntity<MemberDTO> updateMember(@PathVariable Integer id, @RequestBody Member member){
        return putMemberService.execute(new UpdateMemberCommand(id, member));
    }
    @DeleteMapping("/member/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Integer id){
        return deleteMemberService.execute(id);
    }
}
