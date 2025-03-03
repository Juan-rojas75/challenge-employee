package com.example.employeetest.service;

import com.example.employeetest.models.Employee;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio para gestionar las peticiones al API REST de empleados.
 * Permite obtener información de empleados y calcular su salario anual.
 *
 * @author Juan Rojas
 * @since 1.0
 */
@Service
public class EmployeeService {
    private final WebClient webClient;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final BusinessService businessService;
    private final String API_URL = "http://dummy.restapiexample.com/api/v1/";

    /**
     * Constructor del servicio EmployeeService.
     *
     * @param webClient       Cliente WebClient para realizar peticiones HTTP.
     * @param businessService Servicio de negocio para cálculos adicionales.
     */
    public EmployeeService(WebClient webClient, BusinessService businessService) {
        this.webClient = webClient;
        this.businessService = businessService;
    }

    /**
     * Obtiene la lista de empleados desde el API REST.
     *
     * @return Lista de empleados.
     */
    public List<Employee> getEmployees() {
        String response = webClient.get()
                .uri(API_URL + "employees")
                .header("cookie", "humans_21909=1")
                .header("Content-Type", "application/json")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return parseEmployees(response);
    }

    /**
     * Obtiene los datos de un empleado específico por su ID.
     *
     * @param id Identificador único del empleado.
     * @return Objeto Employee con los datos del empleado.
     */
    public Employee fetchEmployeeById(Long id) {
        String response = webClient.get()
                .uri(API_URL + "employee/" + id)
                .header("cookie", "humans_21909=1")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return parseEmployee(response);
    }

    /**
     * Convierte una cadena JSON en un objeto Employee.
     *
     * @param json Cadena JSON con los datos del empleado.
     * @return Objeto Employee o null si ocurre un error.
     */
    private Employee parseEmployee(String json) {
        try {
            JsonNode root = objectMapper.readTree(json);
            JsonNode data = root.get("data");
            return parseEmployeeNode(data);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Convierte una cadena JSON en una lista de empleados.
     *
     * @param json Cadena JSON con los datos de múltiples empleados.
     * @return Lista de empleados.
     */
    private List<Employee> parseEmployees(String json) {
        List<Employee> employees = new ArrayList<>();
        try {
            JsonNode root = objectMapper.readTree(json);
            JsonNode data = root.get("data");
            if (data.isArray()) {
                for (JsonNode node : data) {
                    employees.add(parseEmployeeNode(node));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

    /**
     * Convierte un nodo JSON en un objeto Employee.
     *
     * @param node Nodo JSON con los datos de un empleado.
     * @return Objeto Employee con la información extraída.
     */
    private Employee parseEmployeeNode(JsonNode node) {
        Long id = node.get("id").asLong();
        String name = node.get("employee_name").asText();
        int salary = node.get("employee_salary").asInt();
        int age = node.get("employee_age").asInt();
        String image = node.get("profile_image").asText();
        Float annualSalary = businessService.calculateAnnualSalary(salary);

        return new Employee(id, name, salary, age, image, annualSalary);
    }
}
