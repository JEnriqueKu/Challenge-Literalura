package com.alluracursos.literalura.repository;

import com.alluracursos.literalura.data.LibroData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<LibroData,Long> {

    /*List<LibroData> findByAnioDeNacimientoAutorLessThanEqualAndAnioFallecimientoAutorGreaterThanEqualAndAnioDeNacimientoAutorIsNotNullAndAnioFallecimientoAutorIsNotNull
            (String nacimiento, String fallecimiento);

    List<LibroData> findByLenguajes(String lenguaje);*/
}
