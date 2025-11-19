package com.parcial.tellez.services;

import com.parcial.tellez.dtos.ClinicaDTO;
import com.parcial.tellez.entities.Clinica;
import com.parcial.tellez.repositories.ClinicaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClinicaService {

    private final ClinicaRepository clinicaRepository;
    private final ModelMapper modelMapper;

    public ClinicaService(ClinicaRepository clinicaRepository, ModelMapper modelMapper) {
        this.clinicaRepository = clinicaRepository;
        this.modelMapper = modelMapper;
    }

    public List<ClinicaDTO> listarTodas() {
        return clinicaRepository.findAll()
                .stream()
                .map(c -> modelMapper.map(c, ClinicaDTO.class))
                .collect(Collectors.toList());
    }
    public ClinicaDTO crear(ClinicaDTO dto) {
        Clinica entidad = modelMapper.map(dto, Clinica.class);
        Clinica guardada = clinicaRepository.save(entidad);
        return modelMapper.map(guardada, ClinicaDTO.class);
    }
}
