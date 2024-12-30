package com.membershipTracker.MembershipTracker.MemberAndAttendance.Services;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.DTO.MemberDTO;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Member;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Repository.MemberRepository;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetMembersService implements Query<Void,List<MemberDTO>> {
    private final MemberRepository memberRepository;

    public GetMembersService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public ResponseEntity<List<MemberDTO>> execute(Void input) {
        List<Member> members = memberRepository.findAll();
        List<MemberDTO> memberDTOS = members.stream().map(MemberDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(memberDTOS);
    }
}
