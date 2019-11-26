Booking Flight
===================


Booking Flight es una aplicación backend escrita en Java con el framework de SpringBoot que tiene como objetivo principal realizar reservaciones de vuelos a nivel nacional.

----------


Instalación de la aplicación
-------------

Una vez descargado el código fuente se debe ejecutar los siguientes comandos para su instalación y despliegue:

- Compilar la aplicación una vez estemos ubicados en la raiz del proyecto (donde se encuentra el archivo POM)
> mvn clean install

- Iniciar la micro aplicación a través del siguiente comando
> mvn spring-boot:run

También se puede iniciar como una aplicación java corriendo la clase principal llamada "CallCenterApplication.java"

> **Nota:**

>Los comandos de este ejemplo son realizado en Windows

Las URL de lo servicios son las siguientes:

Servicio para consultar reservaciones bajo el método GET:

>- http://localhost:9000/booking/flight/getReservations/{numeroDocumento}

Servicio consultar vuelos bajo el método POST:

>- http://localhost:9000/booking/flight/getFlights

Request del servicio de consulta de vuelos
```json
{
  "initDate": "2019-11-25T05:00:00.000Z",
  "endDate": "2019-11-26T05:00:00.000Z",
  "source": "Medellin",
  "destiny": "Bogota",
  "oneWay": false
}
```

Servicio para crear reservaciones bajo el método POST

>- http://localhost:9000/booking/flight/createReservation

Request del servicio de creaciónd de reservaciones
```json
{
  "code": "AQ021",
  "date": "2019-11-23",
  "document": "1234567890",
  "lastName": "Hinestroza",
  "firstName": "Andres",
  "birthDate": "1986-05-03",
  "flights": [
    {
      "id": 3,
      "code": "AV368",
      "initDate": "2019-11-25T18:22:00.000+0000",
      "endDate": "2019-11-25T19:32:00.000+0000",
      "source": "Medellin, CO",
      "destiny": "Bogotá, CO",
      "price": 90000
    },
    {
      "id": 6,
      "code": "AV368",
      "initDate": "2019-11-26T18:22:00.000+0000",
      "endDate": "2019-11-25T19:32:00.000+0000",
      "source": "Medellin, CO",
      "destiny": "Bogotá, CO",
      "price": 90000
    }
  ]
}
```


Artefactos de prueba
-------------
Como artefacto de prueba se ha puesto a su disposición un proyecto elaborado con SOAP-UI llamado "AlmundoCallCenter-soapui-project.xml" que permite consumir los servicios Rest expuestos con sus respectivos datos de prueba.

Tecnologías implementadas
-------------
La aplicación esta basada en microservicios realizados con SpringBoot en la versión 2.0.5.RELEASE con Java 8 y Spring Data JPA en la capa de acceso a datos.

> **Nota:**

> En esta aplicación se ha utilizado una base de datos embebida H2 y la cual es cargada con algunos empleados al momento de iniciar la aplicación.
