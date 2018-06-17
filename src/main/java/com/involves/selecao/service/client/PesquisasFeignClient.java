package com.involves.selecao.service.client;

import com.involves.selecao.alerta.Pesquisa;
import com.involves.selecao.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@FeignClient(name = "selecao-involves", url = "https://selecao-involves.agilepromoter.com", configuration = FeignConfiguration.class)
public interface PesquisasFeignClient {

    @GetMapping(value = "/pesquisas")
    Set<Pesquisa> getSearches();
}
