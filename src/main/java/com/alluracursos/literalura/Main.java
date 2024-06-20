package com.alluracursos.literalura;

import com.alluracursos.literalura.data.AutorData;
import com.alluracursos.literalura.data.LibroData;
import com.alluracursos.literalura.model.Autor;
import com.alluracursos.literalura.model.Libro;
import com.alluracursos.literalura.repository.AutorRepository;
import com.alluracursos.literalura.repository.LibroRepository;
import com.alluracursos.literalura.service.ConsumoGutendex;
import com.alluracursos.literalura.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    ConsumoGutendex consumoGutendex = new ConsumoGutendex();
    ConvierteDatos convierteDatos = new ConvierteDatos();
    LibroRepository libroRepository;
    AutorRepository autorRepository;

    public Main(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    List<Autor> lista1 = new ArrayList<>();
    List<Autor> lista2 = new ArrayList<>();
    List<Autor> list32 = new ArrayList<>();
    List<String> lenguajes = new ArrayList<>();
    Autor autor1 = new Autor("nombre1", 1999, 2000);
    Autor autor2 = new Autor("nombre2", 1999, 2000);

    Libro libro1 = new Libro(1342,"libro1", lista1, lenguajes,10);
    Libro libro2 = new Libro(212,"libro2", lista2, lenguajes,10);
    Libro libro3 = new Libro(378,"libro3", list32, lenguajes,10);
    AutorData autorData1 = new AutorData(autor1);
    AutorData autorData2 = new AutorData(autor2);

    public void prueba(){
        lista1.add(autor1);
        lista2.add(autor2);
        list32.add(autor2);
        list32.add(autor1);
        LibroData libroData1 = new LibroData(libro1);
        LibroData libroData2 = new LibroData(libro2);
        LibroData libroData3 = new LibroData(libro3);

        libroRepository.save(libroData1);
        libroRepository.save(libroData2);
        libroRepository.save(libroData3);

        /*List<LibroData> listaLibros1 = new ArrayList<>();
        listaLibros1.add(libroData1);
        listaLibros1.add(libroData2);
        autorData1.setLibros(listaLibros1);

        List<LibroData> listaLibros2 = new ArrayList<>();
        listaLibros2.add(libroData1);
        autorData2.setLibros(listaLibros2);*/

        autorRepository.save(autorData1);
        autorRepository.save(autorData2);
    }




    /*public void mostrarMenu(){
        String opc;
        do {
            String text = """
    
				Elija la opción a través de su número:
				1.- Buscar libro por titulo
				2.- Buscar libros registrados
				3.- Listar autores registrados
				4.- Listar autores vivos en un determinado año
				5.- Listar libros por idioma
				0.- Salir
				""";
            System.out.println(text);

            opc = scanner.next();

            switch (opc){
                case "1" :
                    buscarLibroPorTituloYAgregarlo();
                    break;

                case "2" :
                    buscarLibrosRegistrados();
                    break;

                case "3":
                    listarAutoresRegistrados();
                    break;

                case "4":
                    listarAutoresVivosEnDeterminadoAnio();
                    break;
                case "5":
                    listarLibrosPorIdioma();
                    break;
                case "0":
                    System.out.println("Saliendo de la aplicaion. Gracias.");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (!opc.equals("0"));



    }

    private void buscarLibroPorTituloYAgregarlo() {
        System.out.println("Escriba el nombre del libro");
        String nombre = scanner.next();
        String resultadosJson = consumoGutendex.obtenerDatos(nombre);

        var resultados = convierteDatos.obtenerDatos(resultadosJson, Resultados.class);

        try {
            resultados.libros().forEach(libro -> {
                System.err.println("Esta es la clase LIBROOOOO");
                System.out.println(libro);
                libroRepository.save(new LibroData(libro));
                libro.autores().forEach(autor -> autorRepository.save(new AutorData(autor)));
            });
        } catch (DataIntegrityViolationException e){
            System.out.println("Se encontraron libros que ya estan en la base de datos, estos no se agregarán");
        }


        if (resultados.libros().isEmpty()) System.err.println("No se encontraron resultados");
        else {
            System.out.println("Se encontraron: " + "\n");
            System.out.println(resultados.libros().stream().map(Libro::titulo).collect(Collectors.joining("\n")));
        }
    }

    private void buscarLibrosRegistrados() {
        List<LibroData> libroData = libroRepository.findAll();
        libroData.forEach(this::imprimirLibro);
    }

    private void listarAutoresRegistrados() {
        List<LibroData> librosEncontrados = libroRepository.findAll();

        imprimirAutores(librosEncontrados);
    }

    private void listarAutoresVivosEnDeterminadoAnio() {
        *//*System.out.println("Ingrese el año vivo del autor(es) que desee buscar");
        String anio = scanner.next();

        List<LibroData> librosEncontrados = libroRepository.findByAnioDeNacimientoAutorLessThanEqualAndAnioFallecimientoAutorGreaterThanEqualAndAnioDeNacimientoAutorIsNotNullAndAnioFallecimientoAutorIsNotNull(anio,anio);

        if (!librosEncontrados.isEmpty()){
            imprimirAutores(librosEncontrados);
        } else System.out.println("Autores no encontrados en ese año");
*//*
    }

    private void listarLibrosPorIdioma() {

    }

    private void imprimirLibro(LibroData libro){
        System.out.println("--------- LIBRO ---------");
        System.out.println(libro);
        System.out.println("-------------------------\n");
    }

    private void imprimirAutores(List<LibroData> librosEncontrados){
        *//*Map<String, Map<String, Object>> librosPorAutor = new HashMap<>();

        for (LibroData libro : librosEncontrados) {
            String[] autores = libro.getAutores().split("; ");
            String[] nacimiento = libro.getAnioDeNacimientoAutor().split(", ");
            String[] fallecimiento = libro.getAnioFallecimientoAutor().split(", ");

            for (int i = 0; i < autores.length; i++) {
                String autor = autores[i];
                String birthYear = nacimiento[i];
                String deathYear = fallecimiento[i];

                if (librosPorAutor.containsKey(autor)) {
                    Map<String, Object> autorInfo = librosPorAutor.get(autor);
                    List<String> libros = (List<String>) autorInfo.get("libros");
                    libros.add(libro.getTitulo());
                } else {
                    Map<String, Object> autorInfo = new HashMap<>();
                    autorInfo.put("anioDeNacimiento", birthYear);
                    autorInfo.put("anioDeFallecimiento", deathYear);
                    List<String> libros = new ArrayList<>();
                    libros.add(libro.getTitulo());
                    autorInfo.put("libros", libros);
                    librosPorAutor.put(autor, autorInfo);
                }
            }
        }

        librosPorAutor.forEach((autor, autorInfo) -> {
            System.out.println("Autor: " + autor);
            System.out.println("Fecha de nacimiento: " + autorInfo.get("anioDeNacimiento"));
            System.out.println("Fecha de fallecimiento: " + autorInfo.get("anioDeFallecimiento"));
            @SuppressWarnings("unchecked")
            List<String> libros = (List<String>) autorInfo.get("libros");
            System.out.println("Libros: {" + String.join("; ", libros) + "}");
            System.out.println();
        });*//*
    }
*/

}
