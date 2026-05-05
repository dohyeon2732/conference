package com.example.conference.attendance.dto;

import com.example.conference.vote.entity.VoteType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AttendanceResultResponseDTO {
    private Long attendanceId;
    private Long agendaId;
    private Long userId;
    private String userName;
    private String userPos;
    private String deptName;
    private VoteType voteValue;
}
