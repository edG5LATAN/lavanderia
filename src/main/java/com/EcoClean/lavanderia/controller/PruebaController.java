package com.EcoClean.lavanderia.controller;

import com.EcoClean.lavanderia.cliente.DatosRecord;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prueba")
public class PruebaController {

    @GetMapping
    public void pruebaController(@RequestBody @Valid DatosRecord datosRecord){
        System.out.println(datosRecord);
    }


}
