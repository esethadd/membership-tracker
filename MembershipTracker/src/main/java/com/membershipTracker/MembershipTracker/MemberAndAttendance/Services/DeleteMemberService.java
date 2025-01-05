package com.membershipTracker.MembershipTracker.MemberAndAttendance.Services;

import com.membershipTracker.MembershipTracker.Exceptions.MemberNotFoundException;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Command;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Member;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteMemberService implements Command<Integer,Void> {

    private final MemberRepository memberRepository;

    public DeleteMemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer id) {
            Optional<Member> memberOptional = memberRepository.findById(id);
            if(memberOptional.isPresent()){
                memberRepository.deleteById(id);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }

        throw new MemberNotFoundException();
    }
}
