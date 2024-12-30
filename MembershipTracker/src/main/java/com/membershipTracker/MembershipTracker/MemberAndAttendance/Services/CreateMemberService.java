package com.membershipTracker.MembershipTracker.MemberAndAttendance.Services;

import com.membershipTracker.MembershipTracker.MemberAndAttendance.Command;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.DTO.MemberDTO;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Member;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateMemberService implements Command<Member, MemberDTO>{

    private final MemberRepository memberRepository;

    public CreateMemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public ResponseEntity<MemberDTO> execute(Member member) {
        Member savedMember = memberRepository.save(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MemberDTO(savedMember));
    }
}
