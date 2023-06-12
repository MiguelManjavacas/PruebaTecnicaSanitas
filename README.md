# Calculadora Java Spring-Boot
API en micro-servicio java con Spring-boot y Maven para realizar operaciones básicas como sumar, restar, multiplicar y dividir.

Comunicación a través de una API REST (p.e. ```GET /api/operate?operando1=3&operador=+&operando2=2```)

## Estructura del proyecto

Para la estructura de este proyecto se han utilizado las siguientes tecnologías:
	- Java 17
	- Spring Boot
	- Maven
	- JUnit5

La aplicación dispone de un controlador que gestiona un endpoint para realizar las diferentes operaciones.
La aplicación dispone de un servicio que ejecuta la funcionalidad desde el endpoint.

## Dependencias utilizadas

Se han utilizado dependencias esenciales de Springboot para el funcionamiento de aplicaciones rest. Por ejemplo:

```
	dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter</artifactId>
	</dependency>

	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-test</artifactId>
		<scope>test</scope>
	</dependency>

	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-web</artifactId>
	</dependency>

	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.1.0</version>
		<type>pom</type>
	</dependency>

	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>
```

## Funcionalidades implementadas y alcance del servicio

Las funcionalidades implementadas son las operaciones básicas de suma, resta, multiplicación y división. Es el alcance que tiene actualmente.
La aplicación está organizada por módulos que pueden ser replicados o actualizados para implementaciones futuras.

## Procedimientos de compilación y ejecución

1. Clonar el repositorio desde Github
2. Instalación limpia de Maven
3. Ejecutar el JAR de la carpeta /target

Abrir una consola y ejecutar:

```
git clone https://github.com/MiguelManjavacas/PruebaTecnicaSanitas
cd master
mvn clean install
java -jar target/PruebaTecnicaSanitas-0.0.1-SNAPSHOT.jar

```
Por último, para acceder a nuestra aplicación tendríamos que usar la siguiente url `http://localhost:8080/api/operate`

### Ejecutar tests

Para ejecutar los [tests](https://github.com/MiguelManjavacas/PruebaTecnicaSanitas/tree/master/src/test/java/com/pruetec/manj/sanitas/operations) debes ejecutar el comando `mvn clean test`.

### Librerías locales
Contiene la integración de librerías locales [tracer](https://github.com/MiguelManjavacas/PruebaTecnicaSanitas/tree/master/src/main/resources/lib) en Maven por lo que sería necesario ejecutar `mvn clean install` para poder utilizarlas en el proyecto.


## Ejemplos de llamada de la API
Los parámetros se le deben pasar por URL en formato URLEncoded. 
Los parametros son los siguientes:
	-`operando1` el primer numero de la operación.
	-`operador` una cadena de texto con la operación a realizar (`+`, `-`, `*`, `/`).
	-`operando2` el segundo numero de la operación. 

Por ejemplo:

`GET http://localhost:8080/api/operate?operando1=2&operador=+&operando2=3`

El resultado será un valor numerico:
`2 + 3 = 5`
