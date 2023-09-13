package com.EcoClean.lavanderia.controller;

import com.EcoClean.lavanderia.cliente.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private InterfaceCliente interfaceCliente;

    @PostMapping
    public ResponseEntity<RecordActualizarReturn> agregar(@RequestBody @Valid DatosRecord datosRecord, UriComponentsBuilder uriComponentsBuilder){
      Cliente cliente= interfaceCliente.save(new Cliente(datosRecord));
       var recordActualizarReturn=new RecordActualizarReturn(cliente.getId(), cliente.getNombre(), cliente.getTelefono(),
               cliente.getFecha(), cliente.getPeso(), cliente.getNota(), cliente.getEstado());
        URI url=uriComponentsBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();

       return ResponseEntity.created(url).body(recordActualizarReturn);
    }

    @GetMapping
    public ResponseEntity<Page<Cliente>>  listar(@PageableDefault(sort = "nombre") Pageable pageable){
        return ResponseEntity.ok(interfaceCliente.findAll(pageable));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminar(@PathVariable Long id){
       Cliente cliente=interfaceCliente.getReferenceById(id);
      interfaceCliente.delete(cliente);
      return ResponseEntity.noContent().build();
    }
    @PutMapping()
    @Transactional
    public ResponseEntity update(@RequestBody @Valid RecordActualizarDatos actualizarDatos){
       Cliente cliente=interfaceCliente.getReferenceById(actualizarDatos.id());
        cliente.actualizarD(actualizarDatos);
        return ResponseEntity.ok(new RecordActualizarReturn(cliente.getId(), cliente.getNombre(),
         cliente.getTelefono(), cliente.getFecha(), cliente.getPeso(), cliente.getNota(), cliente.getEstado()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<RecordActualizarReturn> buscarUnidad(@PathVariable("id") Long id){
        Cliente cliente = interfaceCliente.getReferenceById(id);
        var RespuestCliente=new RecordActualizarReturn(cliente.getId(), cliente.getNombre(), cliente.getTelefono(), cliente.getFecha(), cliente.getPeso(), cliente.getNota(),cliente.getEstado());
        return ResponseEntity.ok(RespuestCliente);
    }
    private record RecordActualizarReturn(Long id, String nombre, String telefono,
      String fecha, String peso, String nota, Estado estado){

    }
}

