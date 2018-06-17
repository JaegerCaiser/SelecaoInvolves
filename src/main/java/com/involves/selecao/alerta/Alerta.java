package com.involves.selecao.alerta;

import org.springframework.data.annotation.Id;

public class Alerta {

    @Id
    private String id;
    private String pontoDeVenda;
    private String descricao;
    private String sobre;
    private Integer flTipo;
    private Integer margem;

    public Alerta() {
    }

    public Alerta(Integer flTipo, String descricao) {
        this.flTipo = flTipo;
        this.descricao = descricao;
    }

    public String getPontoDeVenda() {
        return pontoDeVenda;
    }

    public void setPontoDeVenda(String pontoDeVenda) {
        this.pontoDeVenda = pontoDeVenda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

    public Integer getFlTipo() {
        return flTipo;
    }

    public void setFlTipo(Integer flTipo) {
        this.flTipo = flTipo;
    }

    public Integer getMargem() {
        return margem;
    }

    public void setMargem(Integer margem) {
        this.margem = margem;
    }

    public void preencheDados(Pesquisa pesquisa) {
        this.sobre = pesquisa.getProduto();
        this.pontoDeVenda = pesquisa.getPonto_de_venda();
    }

    public void preencheDados(Pesquisa pesquisa, Integer margem) {
        this.sobre = pesquisa.getProduto() != null ? pesquisa.getProduto() : pesquisa.getCategoria();
        this.pontoDeVenda = pesquisa.getPonto_de_venda();
        this.margem = margem;
    }

    @Override
    public String toString() {
        return "Alerta{" +
                "id='" + id + '\'' +
                ", pontoDeVenda='" + pontoDeVenda + '\'' +
                ", descricao='" + descricao + '\'' +
                ", sobre='" + sobre + '\'' +
                ", flTipo=" + flTipo +
                ", margem=" + margem +
                '}';
    }
}
