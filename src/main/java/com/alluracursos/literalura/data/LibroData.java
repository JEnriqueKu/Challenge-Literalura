package com.alluracursos.literalura.data;

import com.alluracursos.literalura.model.Libro;
import jakarta.persistence.*;

import java.util.Set;
import java.util.stream.Collectors;


@Entity
@Table(name = "LIBRODATA")
public class LibroData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private Integer libroDataId;
    private String titulo;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "autor_Id",referencedColumnName = "Id"),
            inverseJoinColumns = @JoinColumn(name = "libro_Id", referencedColumnName = "Id")
    )
    private Set<AutorData> listaAutorData;
    private String lenguajes;
    private Integer numeroDeDescargas;

    public LibroData() {
    }

    public LibroData(Libro libro) {
        this.libroDataId = libro.id();
        this.titulo = libro.titulo();
        this.lenguajes = String.join(", ", libro.lenguajes());
        this.numeroDeDescargas = libro.numeroDeDescargas();
        this.listaAutorData = libro.autores().stream().map(AutorData::new).collect(Collectors.toSet());
    }


    public Integer getLibroId() {
        return libroDataId;
    }

    public void setLibroId(Integer libroDataId) {
        this.libroDataId = libroDataId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(String lenguajes) {
        this.lenguajes = lenguajes;
    }

    public Integer getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Integer numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    public Integer getLibroDataId() {
        return libroDataId;
    }

    public void setLibroDataId(Integer libroDataId) {
        this.libroDataId = libroDataId;
    }

    public Set<AutorData> getListaAutorData() {
        return listaAutorData;
    }

    public void setListaAutorData(Set<AutorData> listaAutorData) {
        this.listaAutorData = listaAutorData;
    }

    @Override
    public String toString() {
        String autores = listaAutorData.stream().
                map(autor -> "\"" + autor.getNombre() + "\"").
                collect(Collectors.joining("; "));

        return "Titulo: '" + titulo + '\'' + '\n'+
                "Autor:" + "[" + autores + "]" + '\n'+
                "Lenguajes:'" + lenguajes + '\'' + '\n'+
                "Descargas:" + numeroDeDescargas;
    }
}