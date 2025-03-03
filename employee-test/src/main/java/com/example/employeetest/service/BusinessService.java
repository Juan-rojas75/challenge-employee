package com.example.employeetest.service;

import org.springframework.stereotype.Service;

/**
 * Servicio de negocio para realizar cálculos relacionados con empleados.
 * Proporciona métodos para calcular el salario anual.
 *
 * @author Juan Rojas
 * @since 1.0
 */
@Service
public class BusinessService {

    /**
     * Calcula el salario anual a partir del salario mensual.
     *
     * @param monthlySalary El salario mensual del empleado.
     * @return El salario anual calculado.
     * @throws IllegalArgumentException si el salario mensual es negativo.
     */
    public float calculateAnnualSalary(float monthlySalary) {
        return monthlySalary * 12;
    }
}
