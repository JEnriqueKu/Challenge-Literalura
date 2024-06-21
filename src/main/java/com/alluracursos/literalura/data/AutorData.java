package com.alluracursos.literalura.data;

import com.alluracursos.literalura.model.Autor;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "AUTORDATA")
public class AutorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = false)
    private String nombre;
    private Integer fechaNacimiento;
    private Integer fechaFallecimiento;
    @ManyToMany(mappedBy = "listaAutorData",cascade =CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<LibroData> listaLibroData = new HashSet<>();

    public AutorData() {
    }

    public AutorData(Autor autor) {
        this.nombre = autor.nombre();
        this.fechaNacimiento = autor.anioDeNacimiento() != null ? autor.anioDeNacimiento() : null;
        this.fechaFallecimiento = autor.anioDeFallecimiento() != null ? autor.anioDeFallecimiento() : null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(Integer fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public Set<LibroData> getListaLibroData() {
        return listaLibroData;
    }

    public void setListaLibroData(Set<LibroData> listaLibroData) {
        this.listaLibroData = listaLibroData;
    }

    @Override
    public String toString() {
        String libros = listaLibroData.stream().
                map(libro -> "\"" + libro.getTitulo() + "\"").
                collect(Collectors.joining("; "));

        return "Nombre: '" + nombre + '\'' + '\n'+
                "Fecha de nacimiento: " + fechaNacimiento + '\n'+
                "Fecha de fallecimiento: " + fechaFallecimiento + '\n'+
                "Libros: " + libros;
    }
}