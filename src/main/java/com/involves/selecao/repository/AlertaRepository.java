package com.involves.selecao.repository;

import com.involves.selecao.alerta.Alerta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlertaRepository  extends MongoRepository<Alerta, String> {
}
