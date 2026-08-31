package com.agencia.viagens.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Destino {

    private Long id;
    private String nome;
    private String pais;
    private String localizacao;
    private String descricao;
    private Double preco;
    private LocalDateTime dataCriacao;
    private List<Avaliacao> avaliacoes = new ArrayList<>();
    private Double mediaAvaliacoes;

    public Destino() {
    }

    public Destino(Long id, String nome, String pais, String localizacao,
                   String descricao, Double preco) {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
        this.localizacao = localizacao;
        this.descricao = descricao;
        this.preco = preco;
        this.dataCriacao = LocalDateTime.now();
        this.avaliacoes = new ArrayList<>();
        this.mediaAvaliacoes = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public Double getMediaAvaliacoes() {
        return mediaAvaliacoes;
    }

    public void setMediaAvaliacoes(Double mediaAvaliacoes) {
        this.mediaAvaliacoes = mediaAvaliacoes;
    }
}
