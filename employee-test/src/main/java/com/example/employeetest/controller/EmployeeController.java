package com.example.employeetest.controller;

import com.example.employeetest.models.Employee;
import com.example.employeetest.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar las operaciones relacionadas con empleados.
 * Proporciona endpoints para obtener todos los empleados o un empleado específico por su ID.
 *
 * Permite el acceso desde aplicaciones frontend que se ejecuten en `http://localhost:4200` y `http://localhost:8080`.
 *
 * @author Juan Rojas
 * @since 1.0
 */
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
public class EmployeeController {

    private final EmployeeService employeeService;

    /**
     * Constructor del controlador EmployeeController.
     *
     * @param employeeService Servicio para gestionar la lógica de negocio de los empleados.
     */
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Endpoint para obtener la lista de todos los empleados.
     *
     * @return Lista de empleados.
     */
    @GetMapping("/employees")
    public List<Employee> getEmployee() {
        return employeeService.getEmployees();
    }

    /**
     * Endpoint para obtener un empleado por su ID.
     *
     * @param id Identificador único del empleado.
     * @return Objeto Employee con los datos del empleado encontrado.
     */
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.fetchEmployeeById(id);
    }
}
