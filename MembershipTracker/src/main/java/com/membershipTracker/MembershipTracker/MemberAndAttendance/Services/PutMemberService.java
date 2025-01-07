package com.membershipTracker.MembershipTracker.MemberAndAttendance.Services;

import com.membershipTracker.MembershipTracker.Exceptions.MemberNotFoundException;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Command;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Controller.UpdateCommands.UpdateMemberCommand;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.DTO.MemberDTO;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Member;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Repository.MemberRepository;
import com.membershipTracker.MembershipTracker.MemberAndAttendance.Validator.MemberValidator;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PutMemberService implements Command<UpdateMemberCommand, MemberDTO> {

    private MemberRepository memberRepository;

    public PutMemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override//Spring Starter Validation Alternative
    public ResponseEntity<MemberDTO> execute(UpdateMemberCommand command) {
            Optional<Member> memberOptional = memberRepository.findById(command.getId());
            if (memberOptional.isPresent()) {
                Member member = command.getMember();
                member.setId(command.getId());

                MemberValidator.execute(member);

                memberRepository.save(member);//Updates Entity
                return ResponseEntity.ok(new MemberDTO(member));
            }

        throw new MemberNotFoundException();
    }
}
