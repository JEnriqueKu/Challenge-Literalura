package com.alluracursos.literalura.repository;

import com.alluracursos.literalura.data.LibroData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface LibroRepository extends JpaRepository<LibroData,Long> {

    @Query(value = "SELECT * FROM librodata ld WHERE :lenguaje = ANY (ld.lista_lenguajes)",nativeQuery = true)
    ArrayList<LibroData> findByListaLenguajes(String lenguaje);
}
