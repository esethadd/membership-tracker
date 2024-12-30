package com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Repository;

import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer> {

}
