### Descripción del Proyecto

Este proyecto fue desarrollado como parte del curso **Java y Spring Boot**, impartido por Allura Latam. Aquí encontrarás todos los detalles y funcionalidades implementadas.

Consiste en un sistema desarrollado en Java utilizando Spring Boot, JPA y PostgreSQL para gestionar una base de datos de libros y autores. El objetivo principal es aplicar los conocimientos adquiridos en el curso mediante la implementación de diversas funcionalidades de búsqueda y listado.

### Funcionalidades Implementadas

El proyecto incluye las siguientes funcionalidades principales:

- **Buscar libro por título y agregarlo**
  - Permite buscar un libro por su título y agregarlo a la base de datos si no está registrado.

- **Buscar libros registrados**
  - Lista todos los libros registrados en la base de datos.

- **Listar autores registrados**
  - Muestra todos los autores que están registrados en la base de datos.

- **Listar autores vivos en un determinado año**
  - Permite listar los autores que estuvieron vivos en un año específico, utilizando sus fechas de nacimiento y fallecimiento.

- **Listar libros por idioma**
  - Permite listar todos los libros que están disponibles en un idioma específico.

### Configuración y Ejecución

Para ejecutar el proyecto en tu entorno local, asegúrate de tener configurado lo siguiente:

1. **Base de Datos:**
  - Configura una base de datos PostgreSQL y es muy importante ajustar las configuraciones de conexión en `application.properties` para que coincidan con tu entorno.

2. **Dependencias:**
  - Asegúrate de tener todas las dependencias necesarias configuradas en tu archivo `pom.xml`, especialmente las relacionadas con Spring Boot, JPA y PostgreSQL.

3. **Ejecución:**
  - Ejecuta la clase `LiteraluraApplication` para iniciar la aplicación. Esto desplegará el menú interactivo donde podrás utilizar las funcionalidades mencionadas.
