package com.alluracursos.literalura.data;

import com.alluracursos.literalura.model.Libro;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "LIBRODATA")
public class LibroData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private Integer libroDataId;
    private String titulo;
    @ManyToMany(mappedBy = "listaLibroData")
    /*@JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "librodata_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "autordata_id", referencedColumnName = "id")
    )*/
    private List<AutorData> listaAutorData;
    private String lenguajes;
    private Integer numeroDeDescargas;

    public LibroData() {
    }

    public LibroData(Libro libro) {
        this.libroDataId = libro.id();
        this.titulo = libro.titulo();
        this.lenguajes = String.join(", ", libro.lenguajes());
        this.numeroDeDescargas = libro.numeroDeDescargas();
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
}