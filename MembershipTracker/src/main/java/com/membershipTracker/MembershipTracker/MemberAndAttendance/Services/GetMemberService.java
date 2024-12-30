package com.membershipTracker.MembershipTracker.MemberAndAttendance.Services;

import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.DTO.MemberDTO;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Member;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Repository.MemberRepository;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetMemberService implements Query<Integer, MemberDTO> {
    private final MemberRepository memberRepository;

    public GetMemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public ResponseEntity<MemberDTO> execute(Integer input) {
        try {
            Optional<Member> memberOptional = memberRepository.findById(input);

            if (memberOptional.isPresent()) {
                return ResponseEntity.ok(new MemberDTO(memberOptional.get()));
            }
        }catch(Exception e){
            //Member not found exception
        }
        return null;
    }
}
