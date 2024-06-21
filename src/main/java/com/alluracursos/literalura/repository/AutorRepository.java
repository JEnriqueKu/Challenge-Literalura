package com.alluracursos.literalura.repository;

import com.alluracursos.literalura.data.AutorData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<AutorData,Long> {
    AutorData findByNombre(String nombre);

    List<AutorData> findByFechaNacimientoLessThanEqualAndFechaFallecimientoGreaterThanEqualAndFechaNacimientoNotNullAndFechaFallecimientoNotNull(Integer fechaNacimiento, Integer fechaFallecimiento);

}
