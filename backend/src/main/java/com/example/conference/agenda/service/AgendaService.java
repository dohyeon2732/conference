package com.example.conference.agenda.service;

import com.example.conference.agenda.dto.AgendaRequestDTO;
import com.example.conference.agenda.dto.AgendaResponseDTO;
import com.example.conference.agenda.entity.Agenda;
import com.example.conference.agenda.repository.AgendaRepository;
import com.example.conference.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AgendaService {
    private final UserRepository userRepository;
    private final AgendaRepository agendaRepository;


    public AgendaResponseDTO save(AgendaRequestDTO dto){
        Agenda agenda = Agenda.builder()
                .agendaName(dto.getAgendaName())
                .agendaState(dto.isAgendaState())
                .agendaMinimum(dto.isAgendaMinimum())
                .agendaAgree(0)
                .agendaDisargree(0)
                .agendaAbstain(0)
                .build();

        Agenda saved = agendaRepository.save(agenda);
        return AgendaResponseDTO.from(saved);
    }

    public AgendaResponseDTO findById(Long id){
        Agenda agenda = agendaRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
        return AgendaResponseDTO.from(agenda);
    }

    public List<AgendaResponseDTO> findAll(){
        return agendaRepository.findAll().stream()
                .map(AgendaResponseDTO::from)
                .collect(Collectors.toList());
    }

    public void delete(Long id){agendaRepository.deleteById(id);}
    public void close(Long id){agendaRepository.closeById(id);}

}
