package com.involves.selecao.config;

import feign.codec.Decoder;
import feign.gson.GsonDecoder;
import org.springframework.context.annotation.Bean;

public class FeignConfiguration {

    @Bean
    public Decoder getNewDecoder() {
        return new GsonDecoder();
    }
}
