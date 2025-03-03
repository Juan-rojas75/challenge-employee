# Employee Test - Backend

## Descripción
Este proyecto es una aplicación backend desarrollada en **Spring Boot** siguiendo el patrón **MVC**. Permite gestionar empleados, consumir una API externa y calcular los salarios anuales.

## Tecnologías utilizadas
- **Java 8**
- **Spring Boot 3.4.3**
- **Gradle**
- **Thymeleaf** (para vistas HTML)

## Requisitos previos
Antes de ejecutar la aplicación, asegúrate de tener instalado:
- **Java 8+**
- **Gradle**
- **Git**
- **Wildfly Server** (si deseas desplegar en un servidor externo)

## Instalación y configuración
### 1. Clonar el repositorio
```sh
git clone https://github.com/Juan-rojas75/challenge-employee.git
cd employee-test
```

### 2. Ejecutar la aplicación en modo desarrollo
Usar el siguiente comando:
```sh
./gradlew bootRun
```
Esto iniciará un servidor en `http://localhost:8080`.

## Despliegue en Wildfly
Para desplegar la aplicación en **Wildfly**, primero genera el archivo WAR:
```sh
./gradlew clean build
```
Esto generará un archivo WAR en `build/libs/employee-test-0.0.1-SNAPSHOT.war`.

### 1. Copiar el WAR a Wildfly
Mover el archivo WAR al directorio de despliegue de Wildfly:
```sh
cp build/libs/employee-test-0.0.1-SNAPSHOT.war $WILDFLY_HOME/standalone/deployments/
```

### 2. Iniciar Wildfly
```sh
$WILDFLY_HOME/bin/standalone.sh
```
Acceder a la aplicación en `http://localhost:8080/employee-test`

## API Endpoints
### Obtener todos los empleados
```
GET /api/v1/employees
```
### Obtener empleado por ID
```
GET /api/v1/employees/{id}
```
### Cálculo de salario anual
El salario anual se calcula como:
```
employee_anual_salary = employee_salary * 12
```

## Autor
Juan Rojas

