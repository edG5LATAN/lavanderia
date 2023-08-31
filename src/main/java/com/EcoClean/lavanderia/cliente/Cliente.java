package com.EcoClean.lavanderia.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Cliente")
@Table(name = "cliente")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String telefono;
    private String fecha;
    private String peso;
    private  String  nota;
    private Estado estado;

    public Cliente(DatosRecord datosRecord) {
        this.nombre= datosRecord.nombre();
        this.telefono= datosRecord.telefono();
        this.fecha= datosRecord.fecha();
        this.peso= datosRecord.peso();
        this.nota= datosRecord.nota();
        this.estado=datosRecord.estado();
    }

    public void actualizarD(RecordActualizarDatos actualizarDatos) {
        this.nombre= actualizarDatos.nombre();
        this.telefono= actualizarDatos.telefono();
        this.fecha= actualizarDatos.fecha();
        this.peso= actualizarDatos.peso();
        this.nota= actualizarDatos.nota();
        this.estado=actualizarDatos.estado();
    }
}
