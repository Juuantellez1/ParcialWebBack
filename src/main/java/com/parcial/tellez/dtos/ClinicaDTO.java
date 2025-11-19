package com.parcial.tellez.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClinicaDTO {

    private String identificador;
    private String nombre;
    private String direccion;
    private Integer cantidadCamas;
    private String telefono;
    private String ciudad;
    private LocalDate fechaCreacion;
}
