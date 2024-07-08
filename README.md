# IMC Web Application

## Descripción

Esta es una aplicación web para calcular y monitorear el Índice de Masa Corporal (IMC) de los usuarios. La aplicación permite a los usuarios registrarse, iniciar sesión, calcular su IMC y ver un historial de sus mediciones anteriores. Está construida utilizando Java EE con Servlets y JSP, y se conecta a una base de datos MySQL para almacenar la información del usuario y sus mediciones de IMC.

## Requisitos

- Java 8 o superior
- Apache Tomcat 9.0 o superior
- MySQL 8.0 o superior
- Maven 3.6 o superior

## Estructura del Proyecto

El proyecto sigue el patrón de diseño Modelo-Vista-Controlador (MVC) y está organizado de la siguiente manera:

src/
├── main/
│ ├── java/
│ │ └── com/
│ │ └── example/
│ │ └── evidencia/
│ │ ├── CalculoIMCServlet.java
│ │ ├── DBUtil.java
│ │ ├── IMCHistoricoServlet.java
│ │ ├── LoginServlet.java
│ │ └── RegistroServlet.java
│ ├── resources/
│ │ └── schema.sql
│ └── webapp/
│ ├── WEB-INF/
│ │ └── web.xml
│ ├── calculoIMC.jsp
│ ├── historicoIMC.jsp
│ ├── login.jsp
│ ├── registro.jsp
│ └── resultado.jsp
└── test/

# Uso de aplicación
## Registro de usuarios
-Navega a http://localhost:8080/my-imc-app/registro.jsp para registrar un nuevo usuario.
## Inicio de sesión
-Navega a http://localhost:8080/my-imc-app/login.jsp para iniciar sesión con un usuario registrado.

## Calculo de IMC
-Una vez iniciado sesión, navega a http://localhost:8080/my-imc-app/calculoIMC.jsp para calcular tu IMC.

## CHistorial IMC
-Navega a http://localhost:8080/my-imc-app/historicoIMC.jsp para ver el historial de tus mediciones de IMC.

# Estructura de clases
## Controladores Servlet
-CalculoIMCServlet.java: Maneja las solicitudes para calcular el IMC del usuario.
-IMCHistoricoServlet.java: Maneja las solicitudes para ver el historial de IMC del usuario.
-LoginServlet.java: Maneja las solicitudes de inicio de sesión.
-RegistroServlet.java: Maneja las solicitudes de registro de nuevos usuarios.

## Utilidades
-DBUtil.java: Proporciona métodos para conectar a la base de datos MySQL.

## Paginas JSP
-calculoIMC.jsp: Formulario para ingresar el peso y calcular el IMC.
-historicoIMC.jsp: Muestra el historial de mediciones de IMC.
-login.jsp: Formulario de inicio de sesión.
-registro.jsp: Formulario de registro de nuevos usuarios.
-resultado.jsp: Muestra el resultado del cálculo del IMC.

# Licencias
Este proyecto está licenciado por el autor: Martin Antonio Joaquin Landa
