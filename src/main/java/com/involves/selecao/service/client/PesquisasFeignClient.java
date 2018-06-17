package com.involves.selecao.service.client;

import com.involves.selecao.alerta.Pesquisa;
import com.involves.selecao.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

/**
 * Feign client é forma mais simples e fácil de consumir um web-service<br>
 *
 * Adicinando um name, url e configuration o Feign Client pode ser utilizado em toda aplicação spring.<br>
 *
 * O parametro url guarda o context path do serviço<br>
 *
 * O parametro configuration chama a classe que irá sobrescrever configurações default do Feign<br>
 *
 * See {@link FeignConfiguration}<br>
 */
@FeignClient(name = "selecao-involves", url = "https://selecao-involves.agilepromoter.com", configuration = FeignConfiguration.class)
public interface PesquisasFeignClient {

    /**
     * Assim como é feito um serviço REST do spring é feito a chamada de um feign end-poontaining tint
     *
     * @return Set de Pesquisa
     */
    @GetMapping(value = "/pesquisas")
    Set<Pesquisa> getSearches();
}
