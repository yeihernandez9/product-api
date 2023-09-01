package com.producto.api.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class createProductDTO {

    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;

    @NotBlank
    @Max(10)
    @Min(3)
    private double pricio;

    private String categoria;

}
