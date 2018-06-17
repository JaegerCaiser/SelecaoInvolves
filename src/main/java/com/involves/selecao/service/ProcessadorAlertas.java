package com.involves.selecao.service;

import java.util.Set;

import com.involves.selecao.alerta.Alerta;
import com.involves.selecao.repository.AlertaRepository;
import com.involves.selecao.service.client.PesquisasFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.involves.selecao.alerta.Pesquisa;
import com.involves.selecao.gateway.AlertaGateway;

@Service
public class ProcessadorAlertas {

    PesquisasFeignClient pesquisasFeignClient;

    AlertaRepository alertaRepository;

    public ProcessadorAlertas(PesquisasFeignClient pesquisasFeignClient, AlertaRepository alertaRepository) {
        this.pesquisasFeignClient = pesquisasFeignClient;
        this.alertaRepository = alertaRepository;
    }

    public void processa() {
        Set<Pesquisa> pesquisas = pesquisasFeignClient.getSearches();

        pesquisas.forEach(pesquisa -> {
            if (pesquisa.getCategoria() != null) {
                processaPesquisaCategoria(pesquisa);
            } else {
                processaPesquisaProduto(pesquisa);
            }
        });
    }

    private void processaPesquisaProduto(Pesquisa pesquisa) {
        pesquisa.getRespostas().forEach(resposta -> {
            if (resposta.getPergunta().equals("Qual a situação do produto?")) {
                if (resposta.getResposta().equals("Produto ausente na gondola")) {
                    Alerta alerta = new Alerta(1, "Ruptura detectada!");
                    alerta.preencheDados(pesquisa);
                    alertaRepository.save(alerta);
                }
            } else if (resposta.getPergunta().equals("Qual o preço do produto?")) {
                int precoColetado = Integer.parseInt(resposta.getResposta());
                int precoEstipulado = Integer.parseInt(pesquisa.getPreco_estipulado());
                if (precoColetado > precoEstipulado) {
                    Alerta alerta = new Alerta(2, "Preço acima do estipulado!");
                    int margem = precoColetado - precoEstipulado;
                    alerta.preencheDados(pesquisa, margem);
                    alertaRepository.save(alerta);
                } else if (precoColetado < precoEstipulado) {
                    Alerta alerta = new Alerta(3, "Preço abaixo do estipulado!");
                    int margem = precoEstipulado - precoColetado;
                    alerta.preencheDados(pesquisa, margem);
                    alertaRepository.save(alerta);
                }
            }
        });
    }

    private void processaPesquisaCategoria(Pesquisa pesquisa) {
        pesquisa.getRespostas().forEach(resposta -> {
            if (resposta.getPergunta().equals("%Share")) {
                int participacaoEstipulada = Integer.parseInt(pesquisa.getParticipacao_estipulada());
                int participacaoColetada = Integer.parseInt(resposta.getResposta());
                if (participacaoColetada > participacaoEstipulada) {
                    Alerta alerta = new Alerta(4, "Participação superior ao estipulado");
                    int margem = participacaoColetada - participacaoEstipulada;
                    alerta.preencheDados(pesquisa, margem);
                    alertaRepository.save(alerta);
                } else if (participacaoColetada < participacaoEstipulada) {
                    Alerta alerta = new Alerta(5, "Participação inferior ao estipulado");
                    int margem = participacaoEstipulada - participacaoColetada;
                    alerta.preencheDados(pesquisa, margem);
                    alertaRepository.save(alerta);
                }
            }
        });
    }
}

