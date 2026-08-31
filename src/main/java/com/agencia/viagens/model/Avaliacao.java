package com.agencia.viagens.model;

public class Avaliacao {

    private Long id;
    private Integer nota;
    private String comentario;
    private String autor;

    public Avaliacao() {
    }

    public Avaliacao(Long id, Integer nota, String comentario, String autor) {
        this.id = id;
        this.nota = nota;
        this.comentario = comentario;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
