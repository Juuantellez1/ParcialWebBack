package com.parcial.tellez.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "clinicas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Clinica {
    @Id
    @Column(length = 50)
    private String identificador;  
    private String nombre;
    private String direccion;
    @Column(name = "cantidad_camas")
    private Integer cantidadCamas;
    private String telefono;
    private String ciudad;
    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;
    @OneToMany(mappedBy = "clinica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Doctor> doctores;
}
