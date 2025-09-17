package com.santander.agencia.controller;

import com.santander.agencia.dto.CadastroAgenciaRequest;
import com.santander.agencia.dto.CadastroAgenciaResponse;
import com.santander.agencia.dto.DistanciaResponse;
import com.santander.agencia.service.AgenciaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/desafio")
@CrossOrigin(origins = "*")
@Validated
public class AgenciaController {


    @Autowired
    private AgenciaService agenciaService;

    @PostMapping("/cadastrar")
    public ResponseEntity<CadastroAgenciaResponse> cadastrarAgencia(
            @Valid @RequestBody CadastroAgenciaRequest request) {
        
        CadastroAgenciaResponse response = agenciaService.cadastrarAgencia(request);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/distancia")
    public ResponseEntity<DistanciaResponse> buscarAgenciasProximas(
            @RequestParam(value = "posX", required = true) 
            @NotNull(message = "Posição X é obrigatória")
            @DecimalMin(value = "-180.0", message = "Posição X deve ser maior ou igual a -180")
            @DecimalMax(value = "180.0", message = "Posição X deve ser menor ou igual a 180")
            Double posX,
            
            @RequestParam(value = "posY", required = true) 
            @NotNull(message = "Posição Y é obrigatória")
            @DecimalMin(value = "-90.0", message = "Posição Y deve ser maior ou igual a -90")
            @DecimalMax(value = "90.0", message = "Posição Y deve ser menor ou igual a 90")
            Double posY) {
        

        DistanciaResponse response = agenciaService.buscarAgenciasProximas(posX, posY);
        
        
        return ResponseEntity.ok(response);
    }
}
