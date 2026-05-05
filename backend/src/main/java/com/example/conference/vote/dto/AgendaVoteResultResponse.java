package com.example.conference.vote.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AgendaVoteResultResponse {
    private Long agendaId;
    private long agreeCount;
    private long disagreeCount;
    private long abstainCount;
}
