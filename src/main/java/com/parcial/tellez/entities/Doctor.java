package com.parcial.tellez.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "doctores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  
    private String nombre;
    private String especialidad;
    @ManyToOne
    @JoinColumn(name = "clinica_id")
    private Clinica clinica;
    private String email;
    private String telefono;
    @Column(name = "fecha_contratacion")
    private LocalDate fechaContratacion;
}
