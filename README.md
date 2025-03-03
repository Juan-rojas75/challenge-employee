# challenge-employee
 Amaris challenge

## Descripción
Este proyecto es una aplicación backend desarrollada en **Spring Boot** siguiendo el patrón **MVC**. Permite gestionar empleados, consumir una API externa y calcular los salarios anuales.
Además una aplicación frontend desarrollada en **Angular 17** Que consta de una tabla para renderizar los datos obtenidos del servicio backend.

## Instalación y configuración
### 1. Clonar el repositorio
```sh
git clone https://github.com/Juan-rojas75/challenge-employee.git
```
## Ejecución backend
### 1. Acceder a directorio del proyecto
```sh
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

## Ejecución frontend
### 1. Acceder a directorio del proyecto
```sh
cd employee-front
```

### 2. Instalar dependencias
```sh
npm install
```

### 3. Ejecutar en modo desarrollo
```sh
ng s -o
```

## Autor
Juan Rojas

