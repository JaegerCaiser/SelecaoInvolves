package com.involves.selecao.service;

import com.involves.selecao.alerta.Alerta;
import com.involves.selecao.repository.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscaAlertasService {
	
	@Autowired
	private AlertaRepository alertaRepository;

	public List<Alerta> buscarTodos() {
		return alertaRepository.findAll();
	}

}
