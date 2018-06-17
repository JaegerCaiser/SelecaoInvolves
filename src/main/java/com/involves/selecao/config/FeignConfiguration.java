package com.involves.selecao.config;

import feign.codec.Decoder;
import feign.gson.GsonDecoder;
import org.springframework.context.annotation.Bean;

/**
 * Classe de sobrescrita da configuração default do Feign<br>
 *
 * O bean criado irá utilizar o GsonDecoder como decoder do client<br>
 *
 * GsonDecoder foi necessário para consumir o serviço que estava fornecendo um content como text/plain<br>
 *
 * Uma vez que é necessário a conversão para application/json GsonDecoder oferece essa funcionalidade.<br>
 */
public class FeignConfiguration {

    @Bean
    public Decoder getNewDecoder() {
        return new GsonDecoder();
    }
}
