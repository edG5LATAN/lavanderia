package com.EcoClean.lavanderia.cliente;

import jakarta.validation.constraints.NotNull;

public record RecordActualizarDatos(@NotNull Long id, String nombre, String telefono,
   String fecha, String peso, String nota, Estado estado) {

}
