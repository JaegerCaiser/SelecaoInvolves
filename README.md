# Análise de problemas em pontos de venda

Um software simples que através do processamento de dados coletados em pontos de venda gera informações estratégicas para empresas de trade-marketing.

## Como funciona

Com recursos do spring-boot a aplicação fornece os dados processados atráves de alertas.

Foi utilizado o mongodb-repository do spring para persistência de dados.

Por default o repositório do spring salva os dados no database test


**Atenção: Você precisa do Mongo DB instalado e rodando para prosseguir**

1. Rode o sistema
``` 
gradlew bootRun
```

2. Acesse o diretório app-angular e execute.
```
npm install
```
e depois 
```
ng serve
```

3. Acesse http://localhost:4200 no browser
