package com.parcial.tellez.controllers;

import com.parcial.tellez.dtos.DoctorDTO;
import com.parcial.tellez.services.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctores")
@CrossOrigin(origins = "*")
public class DoctorController {

    private final DoctorService doctorService; 
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
    @GetMapping
    public List<DoctorDTO> listar() {
        return doctorService.listarTodos();
    }
    @GetMapping("/{id}")
    public DoctorDTO obtenerPorId(@PathVariable Long id) {
        return doctorService.buscarPorId(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DoctorDTO crear(@RequestBody DoctorDTO dto) {
        return doctorService.crear(dto);
    }
    @PutMapping("/{id}")
    public DoctorDTO actualizar(@PathVariable Long id,
                                @RequestBody DoctorDTO dto) {
        return doctorService.actualizar(id, dto);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        doctorService.eliminar(id);
    }
}
