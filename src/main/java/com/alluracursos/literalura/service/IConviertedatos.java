package com.alluracursos.literalura.service;

public interface IConviertedatos {
    public <T> T obtenerDatos(String json,Class<T> clase);

}
