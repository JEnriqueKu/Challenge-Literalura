package com.alluracursos.literalura.data;

import com.alluracursos.literalura.model.Autor;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "AUTORDATA")
public class AutorData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String nombre;
    private Integer fechaNacimiento;
    private Integer fechaFallecimiento;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL )
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "autordata_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "librodata_id",referencedColumnName = "id")
    )
    private List<LibroData> listaLibroData;

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

    public void setLibros(List<LibroData> libroData){
        this.listaLibroData = libroData;
    }

    public List<LibroData> getListaLibroData() {
        return listaLibroData;
    }
}