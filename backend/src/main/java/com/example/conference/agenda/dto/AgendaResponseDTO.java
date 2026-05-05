package com.example.conference.agenda.dto;

import com.example.conference.agenda.entity.Agenda;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AgendaResponseDTO {
    private Long agendaId;
    private String agendaName;
    private boolean agendaState;
    private boolean agendaMinimum;

    private Integer agendaAgree;
    private Integer agendaDisagree;
    private Integer agendaAbstain;

    public static AgendaResponseDTO from(Agenda agenda){
        return AgendaResponseDTO.builder()
                .agendaId(agenda.getAgendaId())
                .agendaName(agenda.getAgendaName())
                .agendaState(agenda.isAgendaState())
                .agendaMinimum(agenda.isAgendaMinimum())
                .agendaAgree(agenda.getAgendaAgree())
                .agendaDisagree(agenda.getAgendaDisargree())
                .agendaAbstain(agenda.getAgendaAbstain())
                .build();
    }



}
