package com.example.conference.state.dto;

import com.example.conference.state.entity.State;
import com.example.conference.state.entity.ConferenceState;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StateResponseDTO {
    private Long stateId;
    private ConferenceState currentState;

    public static StateResponseDTO from(State state){
        return StateResponseDTO.builder()
                .stateId(state.getStateId())
                .currentState(state.getCurrentState())
                .build();
    }

}
