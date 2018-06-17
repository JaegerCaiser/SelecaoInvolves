package com.involves.selecao.web.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.involves.selecao.alerta.Alerta;
import com.involves.selecao.service.BuscaAlertasService;
import com.involves.selecao.service.ProcessadorAlertas;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

    private BuscaAlertasService buscaAlertasService;

    private ProcessadorAlertas processador;

    public AlertaController(BuscaAlertasService buscaAlertasService, ProcessadorAlertas processador) {
        this.buscaAlertasService = buscaAlertasService;
        this.processador = processador;
    }

    @GetMapping
    public List<Alerta> alertas() {
        return buscaAlertasService.buscarTodos();
    }

    @GetMapping("/processar")
    public void processar() {
        processador.processa();
    }
}
