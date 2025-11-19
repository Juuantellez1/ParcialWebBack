package com.parcial.tellez.services;   
import com.parcial.tellez.dtos.DoctorDTO;
import com.parcial.tellez.entities.Clinica;
import com.parcial.tellez.entities.Doctor;
import com.parcial.tellez.repositories.ClinicaRepository;
import com.parcial.tellez.repositories.DoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final ClinicaRepository clinicaRepository;
    private final ModelMapper modelMapper;

    public DoctorService(DoctorRepository doctorRepository, ClinicaRepository clinicaRepository, ModelMapper modelMapper) {
        this.doctorRepository = doctorRepository;
        this.clinicaRepository = clinicaRepository;
        this.modelMapper = modelMapper;
    }

    private DoctorDTO mapToDTO(Doctor doctor) {
        DoctorDTO dto = modelMapper.map(doctor, DoctorDTO.class);
        if (doctor.getClinica() != null) {
            dto.setClinicaId(doctor.getClinica().getIdentificador());
        }
        return dto;
    }

    private Doctor mapToEntity(DoctorDTO dto) {
        Doctor doctor = modelMapper.map(dto, Doctor.class);

        if (dto.getClinicaId() != null) {
            Clinica clinica = clinicaRepository.findById(dto.getClinicaId())
                    .orElseThrow(() -> new RuntimeException("Clínica no encontrada"));
            doctor.setClinica(clinica);
        } else {
            doctor.setClinica(null);
        }

        return doctor;
    }

    public List<DoctorDTO> listarTodos() {
        return doctorRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public DoctorDTO buscarPorId(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor no encontrado"));
        return mapToDTO(doctor);
    }

    public DoctorDTO crear(DoctorDTO dto) {
        Doctor doctor = mapToEntity(dto);
        Doctor guardado = doctorRepository.save(doctor);
        return mapToDTO(guardado);
    }

    public DoctorDTO actualizar(Long id, DoctorDTO dto) {
        Doctor existente = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor no encontrado"));

        existente.setNombre(dto.getNombre());
        existente.setEspecialidad(dto.getEspecialidad());
        existente.setEmail(dto.getEmail());
        existente.setTelefono(dto.getTelefono());
        existente.setFechaContratacion(dto.getFechaContratacion());

        if (dto.getClinicaId() != null) {
            Clinica clinica = clinicaRepository.findById(dto.getClinicaId())
                    .orElseThrow(() -> new RuntimeException("Clínica no encontrada"));
            existente.setClinica(clinica);
        }

        Doctor actualizado = doctorRepository.save(existente);
        return mapToDTO(actualizado);
    }

    public void eliminar(Long id) {
        doctorRepository.deleteById(id);
    }
}
