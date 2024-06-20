package com.alluracursos.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Libro(
        Integer id,
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<Autor> autores,
        @JsonAlias("languages") List<String> lenguajes,
        @JsonAlias("download_count") Integer numeroDeDescargas


) {
    @Override
    public Integer id() {
        return id;
    }

    @Override
    public String titulo() {
        return titulo;
    }

    @Override
    public List<Autor> autores() {
        return autores;
    }

    @Override
    public List<String> lenguajes() {
        return lenguajes;
    }

    @Override
    public Integer numeroDeDescargas() {
        return numeroDeDescargas;
    }
}
