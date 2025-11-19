package com.parcial.tellez.controllers;

import com.parcial.tellez.dtos.ClinicaDTO;
import com.parcial.tellez.services.ClinicaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinicas")
@CrossOrigin(origins = "*")
public class ClinicaController {

    private final ClinicaService clinicaService;

    public ClinicaController(ClinicaService clinicaService) {
        this.clinicaService = clinicaService;
    }

    @GetMapping
    public List<ClinicaDTO> listar() {
        return clinicaService.listarTodas();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClinicaDTO crear(@RequestBody ClinicaDTO dto) {
        return clinicaService.crear(dto);
    }
}
