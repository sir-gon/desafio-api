# desafio-api

Aplicación (1 de 3) backend en forma de API REST, basada en Java. 
Consumida por [desafio-webapp](https://github.com/sir-gon/desafio-webapp) y soportada por [desafio-docker](https://github.com/sir-gon/desafio-docker).

Esta aplicación está construída en base a un ejemplo desarrollado en el framework Jersey, para el desarrollo de APIs en Java. El proyecto y sus dependencias están manejados por maven.

Este ejemplo se desarrolló para exponer endpoints HTTP-REST/JSON.

Para ejecutar la app en forma independiente:

```
mvn -X clean package exec:java
```
Para ejecutarla en conjunto con los otros componentes de la solucin, ver: [desafio-docker](https://github.com/sir-gon/desafio-docker)
