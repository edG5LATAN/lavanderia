package com.EcoClean.lavanderia.cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRecord(@NotBlank String nombre,
                          @NotBlank String telefono, @NotBlank String fecha,
                          @NotBlank String peso, @NotNull Estado estado,String nota) {
}
