package com.parcial.tellez.dtos;   

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {
    private Long id;
    private String nombre;
    private String especialidad;
    private String clinicaId;
    private String email;
    private String telefono;
    private LocalDate fechaContratacion;
}
