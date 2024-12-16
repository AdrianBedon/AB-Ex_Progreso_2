# Examen Progreso II

## Tabla de Contenidos

1. [Requisitos previos](#requisitos-previos)
2. [Configuración de la base de datos](#configuración-de-la-base-de-datos)
3. [Ejecución de los servicios](#ejecución-de-los-servicios)
4. [Puertos de los servicios](#puertos-de-los-servicios)
5. [Inserción de datos](#inserción-de-datos)

---

## Requisitos previos

Para ejecutar cada uno de los servicios se recomienda el uso de la herramienta **[Visual Studio Code](https://code.visualstudio.com/)**, ya que permite el manejo de diversos tipos de archivos.

---

## Configuración de la base de datos

1. Desde la línea de comandos (CLI), ejecute el siguiente comando para crear la instancia de base de datos necesaria para los servicios:

   ```bash
   docker-compose -f docker-compose.postgres.yml up -d
   ```

2. Una vez levantada la base de datos, ejecute todas las sentencias `CREATE` que se encuentran dentro del archivo `init.sql`. Esto permitirá crear las bases de datos requeridas para cada servicio.

---

## Ejecución de los servicios

Los servicios desarrollados están implementados en **Java** utilizando el framework **[Spring Boot](https://spring.io/projects/spring-boot)**. Siga los pasos a continuación para ejecutarlos correctamente:

1. Instale las extensiones necesarias para **Java** y **Spring Boot** en Visual Studio Code.

2. Ejecute el siguiente comando para instalar las dependencias definidas en el archivo `pom.xml` de cada servicio:

   ```bash
   mvn install
   ```

3. Diríjase a la clase principal de cada servicio y presione la tecla **F5** para ejecutarlo en modo debug.

---

## Puertos de los servicios

Una vez que los servicios estén levantados, estarán disponibles en los siguientes puertos:

- **REST Service**: puerto `8080`
- **Microservicio**: puerto `8081`
- **SOAP Service**: puerto `8082`

Además, durante la primera ejecución, se crearán automáticamente las tablas necesarias en las respectivas bases de datos.

---

## Inserción de datos

Tras levantar los servicios, podrá insertar datos en cada una de las tablas creadas dentro de las bases de datos correspondientes.