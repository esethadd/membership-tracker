package com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Repository;

import com.membershipTracker.MembershipTracker.MemberAndAttendance.Model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Integer> {

}
