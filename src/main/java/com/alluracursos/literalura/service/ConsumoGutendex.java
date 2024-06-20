package com.alluracursos.literalura.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoGutendex {

    public String obtenerDatos(String busqueda){
        busqueda = busqueda.replaceAll("\\s+", "%20");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder
                (URI.create("https://gutendex.com/books/?search=" + busqueda)).build();

        HttpResponse<String> response = null;

        try {
            response = client.send(request,HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException | IOException e){
            throw new RuntimeException(e);
        }

        return response.body();
    }
}
